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
void nm_rec(string name,int strsize,int i[],ofstream fout);
void dorep(string name,int i[],ofstream fout);
void find(string name,ofstream fout);

int main()
{
	ifstream fin("namenum.in");
	ofstream fout("namenum.out");
	string N;//N has no more than 12 digits,is consist of 2~9
	fin>>N;
	int i[Nsize];//store N into int array
	int j=0;

	//transform string to int[]
	str2int(N,i);
	int name_length=N.length();
	
	
	//output
	cout<<clock()/(double)CLOCKS_PER_SEC;
	return 0;

}

void str2int(string N,int i[])//transform string to int[]
{
	int j;
	for(j=0;j<N.length();j++)
	{
		i[j]=N[j]-'0';
	}
}
/*我要循环的是什么？
 * 根据的是数字的个数 比如4732 字符个数strsize=4
 * 我循环的顺序是什么？比如从后往前循环 即对于字符串ABCD A先变换三次=>B变换=>C变换=>D变换
 * 如上 A对应的循环位于最底层，D对应的循环对应最外层for
 * 但是现在我没法控制循环嵌套的层数
 * 所以选择使用递归
 * 递归次数就是strsize
 * strsize和字符串ABCD的对应：使用位置变量pos
 * pos=strsize
 * 所以pos从4D变到1A
 * pos=1的时候递归停止
 * 对于每个位置的操作：遍历这个位置上对应的三个字母，使用dorep来实现
 * 递归的样子应该是：
 * nm_rec(pos)
 * {
*	if(pos==1)
	{
		dorep();	
	}
	else
	{
		dorep
		nm_rec(pos-1);
	}
 * }
*/
void nm_rec(string name,int strsize,int i[],ofstream fout)
{
	int j;
	int pos=strsize;
	string letter;
	
	if(pos==1)
	{
		dorep(name,i,fout);
	}
	else
	{
		for(j=0;j<lettersize;j++)
		{
			letter=keypad[i[pos-1]][j];
			name.replace(pos-1,1,letter);
			nm_rec(name,pos-1,i,fout);
		}
	}
	

}

void dorep(string name,int i[],ofstream fout)
{
	int j=0;
	int pos;
	string letter;
	for(j=0;j<lettersize;j++)
	{
		pos=i[0];
		letter=keypad[pos][j];
		name.replace(0,1,letter);
		find(name,fout);
	}
}

void find(string name,ofstream fout)
{
	ifstream fin("dict.txt");
	string dict;
	/*
	while(fin)
	{
		fin>>dict;
		if(dict==name)
			fout<<name<<endl;
	}
	*/
	fout<<name<<endl;
}
