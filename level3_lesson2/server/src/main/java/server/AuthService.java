package server;

import java.sql.SQLException;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password) throws SQLException;
    boolean registration(String login, String password, String nickname) throws SQLException;
    void changeNick(String nickname, String newNickName) throws SQLException;
    void savePrivateMessage(String sender, String recipient, String message, String login) throws SQLException;
    void saveBroadcastMessage(String sender, String message, String login) throws SQLException;
    String publicMessage (String login) throws SQLException;
}
