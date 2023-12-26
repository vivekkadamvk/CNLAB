import java.io.*;
import java.net.*;

public class FServer
{
  public static void main(String args[]) throws IOException
  {
 
    System.out.println("Server Started");
    ServerSocket ss= new ServerSocket(4000);
    Socket cs=ss.accept();
    
    InetAddress ia= InetAddress.getByName("localhost");

    
    File fl= new File("/home/student/vk/file/f1.txt");
    FileInputStream fis= new FileInputStream(fl);
    BufferedInputStream bis = new BufferedInputStream(fis);
    
    OutputStream os= cs.getOutputStream();
    byte[] content;
    long flength= fl.length();
    long current=0;
    long st=System.nanoTime();
    
    while(current!=flength){
    int size=10000;
    if(flength-current>=size){
    current+=size;
    
    }
    else{
    size=(int)(flength-current);
    current=flength;
    
    }
    content= new byte[size];
    bis.read(content,0,size);
    os.write(content);
    System.out.print("Sending File");
    
    }
    os.close();
    cs.close();
    ss.close();
    
    System.out.println("File Sent Succesfully");
    
  }catch(IOException e){}
 }
}
