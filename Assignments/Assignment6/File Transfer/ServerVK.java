import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class ServerVK {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(4001);
            InetAddress ia = InetAddress.getByName("localhost");
            byte b[]=new byte[10000];

            byte c[];
            String st;
            File F1 = new File("F:/vk/Assignment6/File Transfer/F1.txt");
            FileOutputStream fos = new FileOutputStream(F1);
            
            while(true){
                DatagramPacket dp=new DatagramPacket(b,b.length);
                ds.receive(dp);
                st=new String (dp.getData(),0,dp.getLength());
                System.out.println(st);
                System.out.println("File Transferred Successfully...");
                st.getBytes();
                fos.write(b);
                fos.flush();
                fos.close();
                System.exit(0); 
            }
            
        } catch (IOException e) {
        }
    }
}