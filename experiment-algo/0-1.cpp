// 0-1背包问题
// f[i][j] = max(f[i-1][j-w[i]]+v[i],f[i-1][j])
// 动态规划方程
// f[i][j]为到第i个物品时，在背包容量为j的情况的下，价值最大化为f[i-1][j-w[i]]+v[i]
#include <iostream>
#include <stdlib.h>
#include <algorithm>
#include <string.h>

using namespace std;
int f[600][600];
int w[60];  //n 个物品 1个背包
int v[60];
int main(int argc, char *argv[])
{
  int n,c,i,k;
  k=0;
  while(scanf("%d %d",&n,&c)!=EOF)
  {
        k++;
        memset(v,0,sizeof(v));
        memset(w,0,sizeof(w));
        memset(f,0,sizeof(f));
        for(int i=1;i<=n;i++)
              scanf("%d", &v[i]);
        for(int i=1;i<=n;i++)
              scanf("%d",&w[i]);
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=c;j++)
            {
                if(w[i]<=j)
                {
                    int tmp=f[i-1][j-w[i]]+v[i];
                    if(tmp>f[i-1][j])
                      f[i][j]=tmp;
                    else
                      f[i][j]=f[i-1][j];
                }
                else
                  f[i][j]=f[i-1][j];
            }
        }
        printf("Case %d:%d\n",k,f[n][c]);
   }

  //system("PAUSE");
  return 0;
}
