import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class ClientVK {
    public static void main(String[] args) throws Exception{
        
            byte[] b2 = new byte[10000];
            FileInputStream fis = new FileInputStream("F:/vk/Assignment6/File Transfer/F2.txt");
            DatagramSocket ds = new DatagramSocket(4002);
            
            int i=0;
            //byte[] buffer = new byte[4096];
            while(fis.available()!=0){
                b2[i]=(byte)fis.read();
                i++;
            }
            fis.close();
            ds.send(new DatagramPacket(b2,i,InetAddress.getLocalHost(),4001));
         
    }
}
