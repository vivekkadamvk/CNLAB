import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F1.txt"));
        
        Socket vk = new Socket("127.0.0.1", 5000);
        
        BufferedOutputStream bos = new BufferedOutputStream(vk.getOutputStream());
        
        byte[] b = new byte[1024];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
            bos.flush();
        }
        System.out.println("Uploading File...");

        System.out.println("File uploaded");

        
        bos.close();
        vk.close();
        bis.close();
        System.out.println("File upload completed");
    }
}
