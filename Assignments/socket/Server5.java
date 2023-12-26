import java.io.*;
import java.net.*;
public class Server5{
public static void main(String args[]) throws IOException{
try{
System.out.println("I am Waiting");
ServerSocket ss=null;
Socket cs=null;
String mg1=null;
String mg2="";
ss=new ServerSocket(4000);
cs=ss.accept();
DataInputStream is=new DataInputStream(cs.getInputStream());
DataOutputStream os=new DataOutputStream(cs.getOutputStream());

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
while(true){
mg1=is.readUTF();

System.out.println("Message="+mg1);



mg2=br.readLine();
os.writeUTF(mg2);
if(mg2.equals("End"))
{


os.close();
is.close();
cs.close();
ss.close();
System.exit(0);
}

}//try end
}
catch(Exception e){
System.out.println(e);}

}
}




