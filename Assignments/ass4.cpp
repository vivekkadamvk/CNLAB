#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int dec_to_bin(int n)
{
int b[32];

int i=0;
while (n>0)
{
b[i]=n%2;
n=n/2;
i++;
}
for (int j=i-1;j>=0;j--)
{
cout<<b[j];
}
cout<<".";

return b[32];
}



int main()
{
int ip[4],mask[4];
char c[8];
int s[8];
int k=0;
cout<<"\n\t\t**********CODE BY VK*********\t\t\n";
cout<<"\nEnter IP Address:"<<endl;
for(int i=0;i<4;i++)
{
cin>>ip[i];
}

cout<<"\nEnter Subnet Mask:"<<endl;
for(int i=0;i<4;i++)
{
cin>>mask[i];
//cin>>c;
}

cout<<"\nIP Address: ";
for(int i=0;i<4;i++)
{
cout<<ip[i]<<".";
}
cout<<endl;
cout<<"\nSubnet Mask: ";
for(int i=0;i<4;i++)
{
cout<<mask[i]<<".";
}
cout<<"\n";
cout<<endl;
cout<<"Binary IP Address: ";
for(int i=0;i<4;i++)
{
dec_to_bin(ip[i]);

}
cout<<"\n";
cout<<endl;

cout<<"Binary Subnet Mask:";
for(int i=0;i<4;i++)
{
dec_to_bin(mask[i]);
}
cout<<"\n";
cout<<endl;

// Display Subnet Address
cout<<"\nBinary Subnet Address: ";
for(int i=0;i<3;i++)
{
dec_to_bin(ip[i]);
}
dec_to_bin(mask[3]);
cout<<endl;

cout<<"\nSubnet Address: ";
for(int i=0;i<3;i++)
{
cout<<ip[i]<<".";
}
cout<<mask[3]<<endl;
cout<<endl;

cout<<"\nFirst Address: ";
for(int i=0;i<3;i++)
{
cout<<ip[i]<<".";
}
cout<<mask[3]+1<<endl;
cout<<endl;

cout<<"\nLast Address: ";
for(int i=0;i<3;i++)
{
cout<<ip[i]<<".";
}
cout<<"254"<<endl;
cout<<endl;

ostringstream os;
os<< mask[3];
string str(os.str());

//Number of Subnets
/*cout<<"Enter Last 8 bits of Subnet Address:";
for(int i=0;i<8;i++){
cin>>s[i];
}*/
for(int i=0;i<8;i++){
if(s[i]==1){
k++;
}
}
cout<<"\nNumber of Subnet Addresses: ";
cout<<pow(2,k+8);
cout<<endl;

//DISPLAY NO. OF HOST Addresses
cout<<"\nNumber of Host Addresses: ";
cout<<pow(2,8-k)-2<<endl;
cout<<endl;
cout<<"\t\t**********CODE BY VK*********\t\t\n";
return 0;

}
