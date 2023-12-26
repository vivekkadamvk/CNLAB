import java.io.IOException;
import java.net.*;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(4001);
            InetAddress ia = InetAddress.getByName("localhost");

            while (true) {
                byte[] content = new byte[65535];
                DatagramPacket DpReceive = new DatagramPacket(content, content.length);
                ds.receive(DpReceive);
                String inp = new String(content, 0, content.length);
                inp = inp.trim();
                System.out.println("Equation Received: " + inp);
                if (inp.equals("exit")) {
                    System.out.println("EXITING");
                    System.exit(0);
                }
                int result;
                StringTokenizer st = new StringTokenizer(inp);
                int oprnd1 = Integer.parseInt(st.nextToken());
                String operation = st.nextToken();
                int oprnd2 = Integer.parseInt(st.nextToken());

                if (operation.equals("+"))
                    result = oprnd1 + oprnd2;

                else if (operation.equals("-"))
                    result = oprnd1 - oprnd2;

                else if (operation.equals("*"))
                    result = oprnd1 * oprnd2;

                else
                    result = oprnd1 / oprnd2;

                System.out.println("Sending the result...");
                String res = Integer.toString(result);
                content = res.getBytes();
                int port = DpReceive.getPort();
                DatagramPacket DpSend = new DatagramPacket(content, content.length, ia, 4000);
                ds.send(DpSend);
                System.out.println("Result Sent");

            }
        } catch (IOException e) {
        }
    }
}
