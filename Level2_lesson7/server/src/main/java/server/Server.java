package server;

import commands.Command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private final int PORT = 8189;
    private ServerSocket server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
        authService = new SimpleAuthService();

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

    public void broadcastMsg(ClientHandler sender, String msg){
        String message = String.format("[ %s ]: %s", sender.getNickname(), msg);
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    //2. * Реализовать личные сообщения, если клиент пишет «/w nick3 Привет, как дела»,
    // то только клиенту с ником nick3, и отправителю сообщения должно прийти сообщение
    // «Привет, как дела»
    public void sendMsgTo(ClientHandler sender, String msg) {
        String[] token = msg.split("\\s");
        String[] smartMsg = new String[token.length-2];
        for (int i = 2; i < token.length; i++) {
            smartMsg[i-2] = token[i];
        }
        String phrase = String.join (" ", smartMsg);
        String message = String.format("[ %s ]: %s", sender.getNickname(), phrase);
        sender.sendMsg(message);
        for (ClientHandler c : clients)
        if (token[0].equals(Command.MSG) && c.getNickname().equals(token[1])) {
            c.sendMsg(message);
        }
    }



    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
