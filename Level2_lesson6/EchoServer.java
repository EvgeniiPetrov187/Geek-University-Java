package WorldOfChats;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EchoServer {
    private static final int PORT = 9900;
    private static ServerSocket server;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен, ждём подключения...");
            socket = server.accept();
            System.out.println("Клиент подключился");

            new Thread(() -> {
                Scanner scanServer = new Scanner(System.in);
                try {
                    while (true) {
                        String write = scanServer.nextLine();
                        PrintWriter print = new PrintWriter(socket.getOutputStream(), true);
                        print.println(write);
                        if (write.equals("/end")) {
                            scanServer.close();
                            System.out.println("Сервер отключается");
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("End");
                }
            }).start();

            Scanner sc = new Scanner(socket.getInputStream());

            while (true) {
                try {
                    String str = sc.nextLine();
                    if (str.equals("/end")) {
                        System.out.println("Клиент отключился");
                        break;
                    }
                    System.out.println("Клиент прислал: " + str);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    System.out.println("End");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("End");
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("End");
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("End");
            }
        }
    }
}


