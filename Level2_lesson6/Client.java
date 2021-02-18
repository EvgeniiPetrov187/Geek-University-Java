package WorldOfChats;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Client {
    private static final int PORT = 9900;
    private static final String ADDR = "localhost";
    private static Socket socket;

    public static void main(String[] args) {
        try {
            System.out.println("Подключение к серверу...");
            socket = new Socket(ADDR, PORT);
            System.out.println("Сервер подключен");

            new Thread(() -> {
                Scanner scanClient = new Scanner(System.in);
                try {
                    while (true) {
                        String write = scanClient.nextLine();
                        PrintWriter print = new PrintWriter(socket.getOutputStream(), true);
                        print.println(write);
                        if (write.equals("/end")) {
                            scanClient.close();
                            System.out.println("Клиент отключается");
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
                        System.out.println("Сервер отключился");
                        break;
                    }
                    System.out.println("Сервер прислал: " + str);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    System.out.println("End");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("End");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("End");
            }
        }
    }
}
