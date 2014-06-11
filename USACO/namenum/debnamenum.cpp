/*
ID:nathanlrf
LANG:C++
TASK:namenum
*/
#include<iostream>
#include<fstream>
#include<string>
#include <sstream>
#include<time.h>
#include<assert.h>

using namespace std;

const int keysize=10,lettersize=3;
const int Nsize=12;
const char keypad[keysize][lettersize]={'0','0','0','0','0','0','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','V','W','X','Y'};


void str2int(string N,int i[]);
void nm_rec(string name,int strsize,int i[]);
void dorep(string name,int i[]);
void find(string name);


int main()
{
	ifstream fin("namenum.in");

	string N;//N has no more than 12 digits,is consist of 2~9
	fin>>N;
	int i[Nsize];//store N into int array
	int j=0;

	//transform string to int
	str2int(N,i);

	string name;
	int pos;
	string temp;

	//initialize name
	for(j=0;j<N.length();j++)
	{
		pos=i[j];
		temp=keypad[pos][0];
		name.append(temp);
	}
	cout<<name<<endl;
	//string s1("a");
	//name.replace(name.begin(),name.begin()+1,s1);
	//cout<<name<<endl;
	//permutation of letters
	nm_rec(name,N.length(),i);



	//output
//	fout<<endl;
	cout<<clock()/(double)CLOCKS_PER_SEC;
	return 0;

}

void str2int(string N,int i[])
{
	int j;
	for(j=0;j<N.length();j++)
	{
		i[j]=N[j]-'0';
	}
}

void nm_rec(string name,int strsize,int i[])
{
	int j;
	string letter;
	if(strsize==0)
	{
		dorep(name,i);
	}
	else
	{
		for(j=0;j<lettersize;j++)
		{
			letter=keypad[i[strsize-1]][j];
			name.replace(name.begin()+strsize-1,name.begin()+strsize,letter);
			nm_rec(name,strsize-1,i);
		}
	}
	

}

void dorep(string name,int i[])
{
	int j=0;
	int pos;
	string letter;
	for(j=0;j<lettersize;j++)
	{
		pos=i[0];
		letter=keypad[pos][j];
		name.replace(name.begin(),name.begin()+1,letter);
		find(name);
	}
}

void find(string name)
{
	ifstream fin("dict.txt");
	ofstream fout("namenum.out");
	string dict;
	while(fin)
	{
		fin>>dict;
		if(dict==name)
			fout<<name<<endl;
	}
}