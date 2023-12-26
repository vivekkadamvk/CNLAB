#include<bits/stdc++.h>
#include<iostream>
#include<sstream>
using namespace std;


int main() {

int mask[4];
char c[8];


cout<<"\nEnter Subnet Mask:"<<endl;
for(int i=0;i<4;i++)
{
cin>>mask[i];

}

ostringstream os;
os<< mask[3];
string str(os.str());
cout<<str;

return 0;
}

