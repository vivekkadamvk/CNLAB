
//  Assignment No :- 1   Sub:- CNL(Computer Network Lab)
//  Error Detection And Correction Using Hamming Code

#include<iostream>
using namespace std;
int cnt(int d[],int i,int j,int k) //cnt() function returns the 0 or 1 according to the even or odd parity
{
	int count=0;
	if(d[i]==1)
		count++;
	if(d[j]==1)
		count++;
	if(d[k]==1)
		count++;
	if((count%2)==0)
		return 0; // if count of one's is even 
	else
		return 1; // if count of one's is zero
}


char cnt1(int d[],int i,int j,int k,int l)
{
	int count=0;
	if(d[i]==1)
		count++;
	if(d[j]==1)
		count++;
	if(d[k]==1)
		count++;
	if(d[l]==1)
		count++;
	if((count%2)==0)
		return '0'; // if count of one's is even 
	else
		return '1'; // if count of one's is zero
}

int main()
{
	int a[7];
	cout<<"\nEnter the data  bits for Generating hamming code \t";

	cin>>a[6];
	cin>>a[5];
	cin>>a[4];
	cin>>a[2];


	a[0]=cnt(a,2,4,6); // calculate parity bit of postion 0
	a[1]=cnt(a,2,5,6); // calculate parity bit of postion 1
	a[3]=cnt(a,4,5,6); // calculate parity bit of postion 3

	cout<<"\n \n Created Hamming Code For Sending Is  :-";
	cout<<"\n \n"<<a[6]<<" "<<a[5]<<" "<<a[4]<<" "<<a[3]<<" "<<a[2]<<" "<<a[1]<<" "<<a[0];


	int b[7];
	cout<<"\n \n Enter the Recived  Hamming Code :-\t";
	cin>>b[6];
	cin>>b[5];
	cin>>b[4];
	cin>>b[3];
	cin>>b[2];
	cin>>b[1];
	cin>>b[0];

	cout<<"\n \n Recived Hamming Code Is :-";
	cout<<b[6]<<" "<<b[5]<<" "<<b[4]<<" "<<b[3]<<" "<<b[2]<<" "<<b[1]<<" "<<b[0];

	char e1,e2,e3;
	e1=cnt1(b,2,4,6,0); // calculate  error bit 0 th position	
	e2=cnt1(b,2,5,6,1); // calculate  error bit 1 th position
	e3=cnt1(b,4,5,6,3); // calculate  error bit 2 th position
	if(e3=='0'&&e2=='0'&&e1=='0')
		cout<<"\n \n No Error in Recived Hamming Code";
	else
	{
		cout<<"\n \n Error Will Be Found At Position :-"<<e3<<e2<<e1;
	}

// 1. if error in bit 1 then change bit 0
	if(e3=='0'&&e2=='0'&&e1=='1')
		if(b[0]==1)
			b[0]=0;
		else
			b[0]=1;

// 2.  if error in bit 2 then change bit 1
	if(e3=='0'&&e2=='1'&&e1=='0')
		if(b[1]==1)
			b[1]=0;
		else
			b[1]=1;

// 3.  if error in bit 3 then change bit 2
	if(e3=='0'&&e2=='1'&&e1=='1')
		if(b[2]==1)
			b[2]=0;
		else
			b[2]=1;

// 4. if error in bit 4 then change bit 3
	if(e3=='1'&&e2=='0'&&e1=='0')
		if(b[3]==1)
			b[3]=0;
		else
			b[3]=1;

// 5. if error in bit 5 then change bit 4
	if(e3=='1'&&e2=='0'&&e1=='1')
		if(b[4]==1)
			b[4]=0;
		else
			b[4]=1;

// 6. if error in bit 6 then change bit 5
	if(e3=='1'&&e2=='1'&&e1=='0')
		if(b[5]==1)
			b[5]=0;
		else
			b[5]=1;

// 7. if error in bit 7 then change bit 6
	if(e3=='1'&&e2=='1'&&e1=='1')
		if(b[6]==1)
			b[6]=0;
		else
			b[6]=1;

	cout<<"\n \n Correted Hamming Code Is :-";
	cout<<b[6]<<" "<<b[5]<<" "<<b[4]<<" "<<b[3]<<" "<<b[2]<<" "<<b[1]<<" "<<b[0];

return 0;

}
