import java.io.*;
import java.util.*;

class CN3 extends Thread
{
	public void stop_n_wait(int e,int value)throws InterruptedException
	{
		System.out.println("\nRetransmit Frames:-");
		for(int i=e;i<=value;i++)
		{
			System.out.print(" "+i);
			Thread.sleep(1000);
		}
	}
	public void go_back_n(int e)
		{
			System.out.println("\nRetransmit Frame:-");
			
			System.out.print(" "+e);
		}
	
	public static void main(String args[]) throws IOException,NumberFormatException,InterruptedException
	{
		int m,i,e;
		System.out.println("Enter The value of m");
		InputStreamReader IR=new InputStreamReader(System.in);
		BufferedReader BR=new BufferedReader(IR);
		m=Integer.parseInt(BR.readLine());
		System.out.println("Value of M="+m);
		int value = (int)Math.pow(2,m)-1;
		System.out.println("Generate set No is :-");
		for(i=0;i<=value;i++)
		{
		System.out.print(" "+i);
		Thread.sleep(1000);
		}
		System.out.println("\nTransmit Frames:-");
		for(i=0;i<=value;i++)
		{
		System.out.print(" "+i);
		Thread.sleep(1000);		
		}
		System.out.println("\nEnter Which Frame has Error");
		e=Integer.parseInt(BR.readLine());
		System.out.println("\nFrame No:- "+e+" having error ");
		CN3 obj=new CN3();
		System.out.println("By Stop-N-Wait Technique::::");
		obj.stop_n_wait(e,value);
		System.out.println(" \nBy go-back-n Technique::::");
		obj.go_back_n(e);
		System.out.println("\nFrames Received Successfully ");
		System.out.println("\nReceived Frames are:-");
		for(i=0;i<=value;i++)
		{
		System.out.print(" "+i);
		Thread.sleep(1000);
		}
  
	}
}

