import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4500);
            Socket socket = ss.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String m1 = dis.readUTF();
                System.out.println("Client Message:" + m1);

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Type Your Message:");
                String m2 = br.readLine();

                if (m2.equals("End")) {
                    socket.close();
                    dis.close();
                    dos.close();
                    System.exit(0);
                }
                dos.writeUTF(m2);
            }
        } catch (IOException e) {
        }
    }
}
