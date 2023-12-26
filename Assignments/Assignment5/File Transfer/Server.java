import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Service started, waiting for connection...");
        
        ServerSocket ss = new ServerSocket(5000);
        
        Socket vvk = ss.accept();
        
        BufferedInputStream bis = new BufferedInputStream(vvk.getInputStream());
        
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F2.txt"));

        byte[] b = new byte[1024];
        
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }

        bos.close();
        bis.close();
        vvk.close();
        System.out.println("Download succeeded");
    }
}