#include<iostream>

using namespace std;

void arrangement(int *,int,int);

int main()
{
	int arr[]={1,2,3,4};
	int start=0;
	int end=sizeof(arr)/sizeof(int);
	combination(arr,start,end);
	return 0;
}

void combination(int *a,int start,int end,int nselN)  
  
{  
        static int nselTemp=nselN;  
        static std::vector<int> selArray(nselN);  
         if(nselN==0)  
  
             {  
                          
                     for(int i=0;i<nselTemp;++i)  
                     cout<<a[selArray[nselTemp-i-1]]<<" ";  
                     cout<<endl;  
                     return;  
             }  
  
           for(int i=start;i<=end-nselN+1;++i)  
  
        {  
  
                  selArray[nselN-1]=i;  
                  Portfolio(a,i+1,end,nselN-1);  
  
        }  
  
}  