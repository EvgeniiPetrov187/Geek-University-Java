package server;

import client.SaveChat;
import commands.Command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private final int PORT = 18189;
    private ServerSocket server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {

        clients = new CopyOnWriteArrayList<>();
        //authService = new SimpleAuthServise();
        if (!DataBaseService.connect()) {
            throw new RuntimeException("Не удалось подключиться к БД");
        }
        authService = new DataBaseService();


        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                System.out.println("client: " + socket.getRemoteSocketAddress());
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                DataBaseService.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(ClientHandler sender, String msg) throws SQLException, IOException {
        String message = String.format("[ %s ]: %s", sender.getNickname(), msg);
        authService.savePrivateMessage(sender.getNickname(),"allusers", msg);
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public void privateMsg(ClientHandler sender,String receiver, String msg) throws SQLException, IOException {
        String message = String.format("[ %s ] to [ %s ]: %s", sender.getNickname(), receiver, msg);
        authService.savePrivateMessage(sender.getNickname(), receiver, msg);
        for (ClientHandler c : clients) {
            if(c.getNickname().equals(receiver)){
                c.sendMsg(message);
                if(!c.equals(sender)){
                    sender.sendMsg(message);
                }
                return;
            }
        }
        sender.sendMsg("not found user: "+ receiver);
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
        broadcastClientList();
    }

    public AuthService getAuthService() {
        return authService;
    }

    public boolean isLoginAuthenticated(String login){
        for (ClientHandler c : clients) {
            if(c.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public void broadcastClientList(){
        StringBuilder sb = new StringBuilder(Command.CLIENT_LIST);

        for (ClientHandler c : clients) {
            sb.append(" ").append(c.getNickname());
        }

        String msg = sb.toString();
        for (ClientHandler c : clients) {
            c.sendMsg(msg);
        }
    }
}
