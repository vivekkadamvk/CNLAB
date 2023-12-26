import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            while (true) {
                String input = dis.readUTF();
                if (input.equals("bye"))
                    break;
                System.out.println("Equation Received");
                int result = 0;

                StringTokenizer st = new StringTokenizer(input);
                int operand1 = Integer.parseInt(st.nextToken());
                String operation = st.nextToken();
                int operand2 = Integer.parseInt(st.nextToken());

                if (operation.equals("+")) {
                    result = operand1 + operand2;
                } else if (operation.equals("-")) {
                    result = operand1 - operand2;
                } else if (operation.equals("/")) {
                    result = operand1 / operand2;
                } else if (operation.equals("*")) {
                    result = operand1 * operand2;
                }
                System.out.println("Sending the Result to the Client");
                System.out.println("Result Sent");

                dos.writeUTF(Integer.toString(result));
            }
        } catch (IOException e) {
        }
    }
}