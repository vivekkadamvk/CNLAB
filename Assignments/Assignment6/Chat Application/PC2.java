import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class PC2 {
    public static void main(String[] args) {
        try {

            DatagramSocket ds = new DatagramSocket(4001);
            System.out.println("Waiting for Message:");

            while (true) {
                byte[] content2 = new byte[10];
                DatagramPacket dp1 = new DatagramPacket(content2, content2.length);
                ds.receive(dp1);
                content2 = dp1.getData();

                String str1 = new String(content2, StandardCharsets.UTF_8);
                if (str1.equals("End")) {
                    System.exit(0);
                }
                System.out.println("Device 1:" + str1);

                InetAddress ia = InetAddress.getByName("localhost");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                byte[] content1;
                String str = br.readLine();
                content1 = str.getBytes();

                DatagramPacket dp = new DatagramPacket(content1, content1.length, ia, 4000);
                ds.send(dp);
            }
        } catch (IOException e) {
        }
    }
}