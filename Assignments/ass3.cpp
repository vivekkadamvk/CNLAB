#include<bits/stdc++.h>
#include<iostream>
using namespace std;

//Sender

void repeat(int & j)
{
cout<<"Retransmitting Frame " << j << "..." << endl;
}

void go_back_n(int & i, int & N, int & M) {
  while (i <= M) {
    int z = 0;
    for (int j = i; j < i + N && j <= M; j++) {
      cout << "Sending Frame " << j << "..." << endl;
     
    }
    for (int j = i; j < i + N && j <= M; j++) {
      int f = rand() % 2;
      if (!f) {
        cout << "ACKNOWLEDGEMENT for Frame " << j << " Received" << endl;
        z++;
      } else {
        cout << "\tTimeout!!! \nACKNOWLEDGEMENT for Frame " << j << " Not Received" << endl;
        cout << "Retransmitting Window from Frame " <<j<< endl;
        break;
      }
    }
    cout << "\n";
    i = i + z;
  }
}

void selective_repeat(int & i, int & N, int & M) {
  while (i <= M) {
    int z = 0;
	
    for (int j = i; j < i + N && j <= M; j++) {
      cout << "Sending Frame " << j << "..." << endl;
	++z;
    }
	for (int j = i; j < i + N && j <= M; j++) {
			
	int f = rand() % 2;
      if (!f) {
        cout << "ACKNOWLEDGEMENT for Frame " << j << " Received" << endl;
		 
			}
		else {
        cout << "\tTimeout!!! \nACKNOWLEDGEMENT for Frame " << j << " Not Received OR NEGATIVE ACKNOWLEDGEMENT" << endl;
       repeat(j);
		cout << "ACKNOWLEDGEMENT for Frame " << j << " Received" << endl;
        
      }
	 }
    cout << "\n";
    i = i + z ;
  }
}

int main(){

int M,N,C,s,b[100],d[100];
int x=0;
int y=0;
cout<<"Enter the Total Window size:";
cin>>M;
cout<<"Enter the number of Frames to Send:";
cin>>N;
cout<<"\nEnter the Frames to send:";
for(int j=0;j<M;j++)
{
cin>>b[j];
x++;
}
cout<<"\nEnter number of Frames Received:";
cin>>s;

if(x==s)
{

for(int j=0;j<M;j++)
{
cout<<"\nAcknowlwdgement for Frame "<<b[j]<<" Received";
}

cout<<"\n\nSuccessfully Received all the Frames\n";
cout<<"\nReceived Frames:";
for(int j=0;j<M;j++)
{
cout<<b[j]<<" ";
}
cout<<"\n";
}
else{

do{
cout<<"\n\t*****MENU*****\n\t1.GO BACK N\n\t2.SELECTIVE REPEAT\n\t0.EXIT";
cout<<"\n\tEnter Your Choice:";
cin>>C;
switch(C){

case 1:
{
cout<<"\n\t***GO BACK N***\n\n";
int i=1;
go_back_n(i,N,M);
break;
}

case 2:
{
cout<<"\n\t***SELECTIVE REPEAT***\n\n";
int i=1;
selective_repeat(i,N,M);
break;
}

case 0:
{
cout<<"\n\t***Good Bye***\n..........Code BY VK..........\n\n";
break;
}
default:
{
cout<<"\n\tEnter Valid Choice\n";
break;
}
}
}while(C!=0);
}
return 0;
}

