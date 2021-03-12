package server;

import java.sql.*;


public class DataBaseService implements AuthService {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement insSet;
    private static PreparedStatement selSet;
    private static PreparedStatement selNickSet;
    private static PreparedStatement upNick;
    private static PreparedStatement insMsg;
    private static PreparedStatement findNick;
    private static PreparedStatement findPersonId;
    private static PreparedStatement findInArchive;
    private static PreparedStatement pubMsg;
    private ResultSet senderRS;
    private ResultSet recipientRS;
    private ResultSet messageRS;
    private ResultSet rs;
    private ResultSet nickRS;


    private static void prepareAllStatements() throws SQLException {
        insSet = connection.prepareStatement("INSERT INTO baseforchat.chat (login, passwort, nickname) VALUES (?, ?, ?);");
        selSet = connection.prepareStatement("SELECT login FROM baseforchat.chat WHERE login=? AND passwort=?;");
        selNickSet = connection.prepareStatement("SELECT nickname FROM baseforchat.chat WHERE login=? AND passwort=?;");
        upNick = connection.prepareStatement("UPDATE baseforchat.chat SET nickname=? WHERE nickname=?;");
        insMsg = connection.prepareStatement("INSERT INTO baseforchat.archive (sender, recipient, message, date) VALUES (?, ?, ?, ?);");
        findNick = connection.prepareStatement("SELECT nickname FROM baseforchat.chat WHERE id=?;");
        findPersonId = connection.prepareStatement("SELECT id FROM baseforchat.chat WHERE nickname=?;");
        findInArchive = connection.prepareStatement("SELECT sender, recipient, message, date FROM baseforchat.archive WHERE sender=? OR recipient=?;");
    }

    @Override
    public boolean registration(String login, String passwort, String nickname) {
        try {
            selSet.setString(1, login);
            selSet.setString(2, passwort);
            selSet.executeQuery();
            rs = selSet.executeQuery();
            if (login.equals(rs.getString("login")))
                return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            insSet.setString(1, login);
            insSet.setString(2, passwort);
            insSet.setString(3, nickname);
            insSet.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String passwort) {
        try {
            selNickSet.setString(1, login);
            selNickSet.setString(2, passwort);
            selNickSet.executeQuery();
            nickRS = selNickSet.executeQuery();
            nickRS.next();
            return nickRS.getString("nickname");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean changeNick(String nickname, String newNickName) {
        try {
            upNick.setString(1, newNickName);
            upNick.setString(2, nickname);
            upNick.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    /**
     * Метод сохраняет сообщения в базу данных
     * @param sender отправитель
     * @param recipient получатель
     * @param message сообщение
     * @throws SQLException ошибка базы данных
     */
    public void savePrivateMessage(String sender, String recipient, String message) throws SQLException {
        findPersonId.setString(1, sender);
        findPersonId.executeQuery();
        senderRS = findPersonId.executeQuery();
        senderRS.next();

        insMsg.setString(1, senderRS.getString("id"));

        findPersonId.setString(1, recipient);
        findPersonId.executeQuery();
        recipientRS = findPersonId.executeQuery();
        recipientRS.next();

        insMsg.setString(2, recipientRS.getString("id"));
        insMsg.setString(3, message);
        insMsg.setString(4, "time");
        insMsg.executeUpdate();
    }

    /**
     * Метод публикует в чате архив сообщений
     * @param sender клиент - отправитель
     * @return все отосланные сообщения
     * @throws SQLException ошибка базы данных
     */
    public String publicMessage(String sender) throws SQLException {
        StringBuilder messages = new StringBuilder();
        findPersonId.setString(1, sender); //find id sender
        findPersonId.executeQuery();
        senderRS = findPersonId.executeQuery();
        senderRS.next();

        findInArchive.setString(1, senderRS.getString("id"));
        findInArchive.setString(2, senderRS.getString("id"));//find id recipient
        findInArchive.executeQuery();
        messageRS = findInArchive.executeQuery();

        while (messageRS.next()) {
            findNick.setString(1, messageRS.getString("recipient"));
            findNick.executeQuery();
            recipientRS = findNick.executeQuery();
            recipientRS.next();
            String recipientString = recipientRS.getString("nickname");

            findNick.setString(1, messageRS.getString("sender"));
            findNick.executeQuery();
            senderRS = findNick.executeQuery();
            senderRS.next();
            String senderString = senderRS.getString("nickname");

            messages.append("["+ senderString + "] to [" + recipientString + "]: " + messageRS.getString("message") + " : " + messageRS.getString("date") + "\n");
        }
        return messages.toString();
    }

    public static boolean connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "13barsik!Z");
            statement = connection.createStatement();
            prepareAllStatements();
            System.out.println("connected with database");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static void disconnect() {
        try {
            insSet.close();
            selSet.close();
            selNickSet.close();
            upNick.close();
            insMsg.close();
            findNick.close();
            findPersonId.close();
            connection.close();
            statement.close();
            System.out.println("disconnected from database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


