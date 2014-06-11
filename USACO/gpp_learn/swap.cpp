#include<iostream>

void swap(int a,int b);

using namespace std;

int main()
{
	int a=3,b=4;
	swap(3,4);
	cout<<a<<" "<<b;
	return 0;
}

void swap(int a,int b)
{
	int t=a;a=b;b=t;
}