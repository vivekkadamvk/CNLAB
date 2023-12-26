import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            DatagramSocket ds = new DatagramSocket(4000);

            InetAddress ip = InetAddress.getLocalHost();
            while (true) {
                System.out.print("Enter the Math Equation to Execute:");

                String input = sc.nextLine();
                byte[] content = new byte[65535];
                content = input.getBytes();

                DatagramPacket DpSend = new DatagramPacket(content, content.length, ip, 4001);
                ds.send(DpSend);
                if (input.equals("End")) {
                    System.exit(0);
                }
                content = new byte[65535];
                DatagramPacket DpReceive = new DatagramPacket(content, content.length);

                ds.receive(DpReceive);
                System.out.println("Answer = " + new String(content, 0, content.length));
            }
        } catch (IOException e) {
        }
    }
}
