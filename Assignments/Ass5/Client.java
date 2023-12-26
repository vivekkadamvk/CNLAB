import java.io.*;
import java.net.*;

public class Client
{
  public static void main(String args[]) throws IOException
  {
  try
  {
    Socket cs=null;
    String m1=null;
    String m2=null;
    cs=new Socket("127.0.0.1",4000);
    DataOutputStream os=new DataOutputStream(cs.getOutputStream());
    DataInputStream is=new DataInputStream(cs.getInputStream());
    
    InetAddress ia= InetAddress.getByName("localhost");
    System.out.println("IP "+ia);
    
    while(true)
    {
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
      
      m1=is.readUTF();
      System.out.println("Message from Server:"+m1);
      
    }
  }catch(IOException e){}
 }
}
