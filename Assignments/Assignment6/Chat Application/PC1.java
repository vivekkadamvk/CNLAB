import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class PC1 {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(4000);
            InetAddress ia = InetAddress.getByName("localhost");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Type Your Message:");
            while (true) {
                byte[] content1;
                String str = br.readLine();
                if (str.equals("End")) {
                    System.exit(0);
                }
                content1 = str.getBytes();

                DatagramPacket dp = new DatagramPacket(content1, content1.length, ia, 4001);
                ds.send(dp);

                byte[] content2 = new byte[10];
                DatagramPacket dp1 = new DatagramPacket(content2, content2.length);
                ds.receive(dp1);
                content2 = dp1.getData();

                String str1 = new String(content2, StandardCharsets.UTF_8);
                if (str1.equals("End")) {
                    System.exit(0);
                }
                System.out.println("Device 2:" + str1);
            }
        } catch (IOException e) {
        }
    }
}