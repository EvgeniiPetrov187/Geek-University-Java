package server;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class DataBaseService implements AuthService {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement insSet;
    private static PreparedStatement selSet;
    private static PreparedStatement selNickSet;
    private static PreparedStatement upNick;
    private static PreparedStatement insMsg;
    private static PreparedStatement pubMsg;
    private ResultSet messagesRS;
    private ResultSet rs;
    private ResultSet nickRS;

    public DataBaseService() {
        try {
            connect();
            prepareAllStatements();
            System.out.println("connected with database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            disconnect();
            System.out.println("disconnected from database");
        }
    }

    private static void prepareAllStatements() throws SQLException {
        insSet = connection.prepareStatement("INSERT INTO baseforchat.chat (login, passwort, nickname) VALUES (?, ?, ?);");
        selSet = connection.prepareStatement("SELECT login FROM baseforchat.chat WHERE login=? AND passwort=?;");
        selNickSet = connection.prepareStatement("SELECT nickname FROM baseforchat.chat WHERE login=? AND passwort=?;");
        upNick = connection.prepareStatement("UPDATE baseforchat.chat SET nickname=? WHERE nickname=?;");
        insMsg = connection.prepareStatement("INSERT INTO baseforchat.archive (sender, recipient, message, login) VALUES (?, ?, ?, ?);");
        pubMsg = connection.prepareStatement("SELECT sender, recipient, message FROM baseforchat.archive WHERE login=?;");
    }

    //3.* Добавить в сетевой чат регистрацию через базу данных
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

    //1. Добавить в сетевой чат авторизацию через базу данных
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

    //2.*Добавить в сетевой чат возможность смены ника.
    // ник сменяется при следующем входе
    @Override
    public void changeNick(String nickname, String newNickName) throws SQLException {
        upNick.setString(1, newNickName);
        upNick.setString(2, nickname);
        upNick.executeUpdate();
    }

    // метод сохраняет личные сообщения в базу
    public void savePrivateMessage(String sender, String recipient, String message, String login) throws SQLException {
        insMsg.setString(1, sender);
        insMsg.setString(2, recipient);
        insMsg.setString(3, message);
        insMsg.setString(4, login);
        insMsg.executeUpdate();
    }

    // метод сохраняет общие сообщения в базу
    public void saveBroadcastMessage(String sender, String message, String login) throws SQLException {
        insMsg.setString(1, sender);
        insMsg.setString(2, "all users");
        insMsg.setString(3, message);
        insMsg.setString(4, login);
        insMsg.executeUpdate();
    }

    // отправка архива чата со старым и новым ником
    public String publicMessage(String login) throws SQLException {
        StringBuilder messages = new StringBuilder();
        pubMsg.setString(1, login);
        pubMsg.executeQuery();
        messagesRS = pubMsg.executeQuery();
        while (messagesRS.next()) {
            messages.append("[" + messagesRS.getString("sender") + "] to [" + messagesRS.getString("recipient") + "]: " + messagesRS.getString("message") + "\n");
        }
        return messages.toString();
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "13barsik!Z");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

