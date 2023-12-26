import java.io.*;
import java.util.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket cs = new Socket("localhost", 4500);
            DataInputStream dis = new DataInputStream(cs.getInputStream());
            DataOutputStream dos = new DataOutputStream(cs.getOutputStream());

            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Type Your Message:");
                String m2 = br.readLine();

                if (m2.equals("End")) {
                    cs.close();
                    dos.close();
                    dis.close();
                    System.exit(0);
                }
                dos.writeUTF(m2);

                String m1 = dis.readUTF();
                System.out.println("Server Message: " + m1);
            }
        } catch (IOException e) {
        }
    }
}
