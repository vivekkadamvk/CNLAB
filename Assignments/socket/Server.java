import java.io.*;
import java.net.*;

public class Server
{
  public static void main(String args[]) throws IOException
  {
  try
  {
    System.out.println("Hello world");
    ServerSocket ss= new ServerSocket(4000);
    Socket cs=null;
    String m1=null;
    String m2=null;
    cs=ss.accept();
    DataOutputStream os=new DataOutputStream(cs.getOutputStream());
    DataInputStream is=new DataInputStream(cs.getInputStream());
    
    InetAddress ia= InetAddress.getByName("localhost");
    System.out.println("IP "+ia);
    
    while(true)
    {
      m1=is.readUTF();
      System.out.println("Message from client:"+m1);
      BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
      m2=br.readLine();
      
      if(m2.equals("End"))
      {
        cs.close();
        is.close();
        os.close();
        System.exit(0);
      }
    
    os.writeUTF(m2);
    }
  }catch(IOException e){}
 }
}
