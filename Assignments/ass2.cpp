/*CODE BY VK*/

#include <iostream>
using namespace std;

int main(){

int a[7],b[7];
int d1,d2,d3,d4,c1,c2,c3;
cout<<"*********CODE BY VK*********"<<endl<<endl;
cout<<"Welcome to the Error Detection System using Hamming Code\n"<<endl;
cout<<"Bit count starts from Right to Left as per Binary System\n"<<endl;
cout<<"Enter 4 Digit Binary Input:\n";

cin>>d1>>d2>>d3>>d4;

cout<<"You Entered:"<<d1<<" "<<d2<<" "<<d3<<" "<<d4<<endl;
a[4]=d1;
a[2]=d2;
a[1]=d3;
a[0]=d4;

//Calculation of parity
a[6]=a[0]^a[2]^a[4];
a[5]=a[0]^a[1]^a[4];
a[3]=a[0]^a[2]^a[1];

cout<<"Hammings Code:\n";
for(int i=0;i<=6;i++)
cout<<a[i]<<" ";
cout<<endl;

cout<<"Enter 7 Digit Receive code\n";
for(int j=0;j<=6;j++)
{
cin>>b[j];
}
c1=b[6]^b[0]^b[2]^b[4];
c2=b[5]^b[0]^b[1]^b[4];
c3=b[3]^b[0]^b[2]^b[1];

if(c1==0&&c2==0&&c3==0)
{
cout<<"NO Error Found\n";
}
else
{
cout<<"Error Found\n";
if(c1==1&&c2==0&&c3==0)
{
cout<<"Error Found at 1st bit Position \n";
	if(b[6]==0)
	{
		b[6]=1;
	}
	else
	{ b[6]=0; }
}
else if(c1==0&&c2==1&&c3==0)
{
cout<<"Error Found at 2nd bit Position\n";
	if(b[5]==0)
	{
		b[5]=1;
	}
	else
	{ b[5]=0; }
}
else if(c1==1&&c2==1&&c3==0)
{
cout<<"Error Found at 3rd bit Position\n";
	if(b[4]==0)
	{
		b[4]=1;
	}
	else
	{ b[4]=0; }
}
else if(c1==0&&c2==0&&c3==1)
{
cout<<"Error Found at 4th bit Position\n";
	if(b[3]==0)
	{
		b[3]=1;
	}
	else
	{ b[3]=0; }
}
else if(c1==1&&c2==0&&c3==1)
{
cout<<"Error Found at 5th bit Position\n";
	if(b[2]==0)
	{
		b[2]=1;
	}
	else
	{ b[2]=0; }
}
else if(c1==0&&c2==1&&c3==1)
{
cout<<"Error Found at 6th bit Position\n";
	if(b[1]==0)
	{
		b[1]=1;
	}
	else
	{ b[1]=0; }
}
else if(c1==1&&c2==1&&c3==1)
{
cout<<"Error Found at 7th bit Position\n";
	if(b[0]==0)
	{
		b[0]=1;
	}
	else
	{ b[0]=0; }
}

cout<<"Corrected Hamming Code:\n";
for(int j=0;j<=6;j++)
cout<<b[j]<<" ";
cout<<endl<<endl;
cout<<"Thank You\n";
}
return 0;

}

/*CODE BY VK*/
