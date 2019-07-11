package socket;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 11.07.2019
 * @version 1
 */

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        new Client("localhost", 5000);
    }

    /**
     * Отправляет сообщения на сервер, умеет принимать авто-сообщения сервера
     * @param ip - ip
     * @param port - port
     */
    public Client(String ip, int port) {
        try {
            Socket socket = new Socket(InetAddress.getByName(ip), port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);
            String request = null;
            String response = null;
            System.out.println("Отправьте сообщение серверу: ");
             while (!("exit".equals(request))) {
                 request = console.nextLine();
                 out.println(request);
                 request = in.readLine();
                 System.out.println("Сообщение от сервера: " + request);
                 if ("exit".equals(request)) {
                     while (!(response = in.readLine()).isEmpty()) {
                         System.out.println(response);
                     }
                 }
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
