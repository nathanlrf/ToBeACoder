#include<iostream>

using namespace std;

int factorial(int x);

int main()
{
	int n;
	cout<<"Type in the n for n!"<<endl;
	cin>>n;
	cout<<"The result of n! is "<<factorial(n)<<endl;
	return 0;
}

int factorial(int x)
{
	if(x==1)
	{
		return 1;
	}
	else
	return x*factorial(x-1);
}
