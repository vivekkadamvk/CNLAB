import java.io.*;
import java.net.*;
import java.io.File.*;
import java.io.FileInputStream.*;
import java.io.FileOutputStream.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);
            System.out.println("Connected to Server");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Enter the Math Expression to Execute:");
                String input = sc.nextLine();

                if (input.equals("End"))
                    break;
                dos.writeUTF(input);

                String ans = dis.readUTF();
                System.out.println("Answer = " + ans);
            }
        } catch (IOException e) {
        }
    }
}