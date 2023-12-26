import java.io.*;
import java.net.*;
public class Client5{
public static void main(String args[]) throws IOException{
try{
//System.out.println("I am Waiting");
//ServerSocket ss=null;
Socket cs=null;
String mg1=null;
String mg2="";
//ss=new ServerSocket(4000);
cs=new Socket("127.0.0.1",4000);
DataInputStream is=new DataInputStream(cs.getInputStream());
DataOutputStream os=new DataOutputStream(cs.getOutputStream());


while(true){
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
mg2=br.readLine();
if(mg2.equals("End"))
{


os.close();
is.close();
cs.close();
//ss.close();
System.exit(0);
}
os.writeUTF(mg2);
mg1=is.readUTF();

System.out.println("Message="+mg1);






}//try end
}
catch(Exception e){
System.out.println(e);}

}
}


