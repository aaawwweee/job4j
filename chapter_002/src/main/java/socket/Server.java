package socket;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 11.07.2019
 * @version 1
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Метод принимает сообщения от клиента, отправляет авто-сообщения в ответ.
     */
    public void server() {
        try {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String ask = null;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("Hello, oracle".equals(ask)) {
                    out.println("Hello, dear friend, I'm oracle.");
                    out.println();
                } else if (!("exit".equals(ask))) {
                    out.println("I dont understand");
                    out.println();
                }
            } while (!("exit".equals(ask)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket);
        }
    }
}

