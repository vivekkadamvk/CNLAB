import java.io.*;
import java.net.*;

public class FClient
{
  public static void main(String args[]) throws IOException
  {
  try
  {
    Socket cs=null;
    cs=new Socket("127.0.0.1",4000);
    byte[] content = new byte[10000];
    InetAddress ia= InetAddress.getByName("localhost");
    System.out.println("IP "+ia);
    
    FileOutputStream fos= new FileOutputStream("/home/student/vk/file/f2.txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    
    InputStream is= cs.getInputStream();
    int bread=0;
    while((bread=is.read(content))!=-1){
    bos.write(content,0,bread);
    
    }
    bos.close();
    cs.close();
    System.out.println("File Saved");
    
  }catch(IOException e){}
 }
}
