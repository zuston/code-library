// 数字三角形
// 问题描述：
// 给定每行由数字组成的数字三角形，寻找从顶至低某处的一条路径，使该路径所经过的数字的总和最大，每一步只能向左下或右下走。
// 输入：
// 输入有若干测试数据。每一组测试数据的第一行为一个整数H，表示有高度为H的数字三角形，接下来的H行描述一个数字三角形，其中的第i行有i个整数，整数之间用一个空格分开。当输入时表示数字三角形的高度的整数为0时，表示输入结束。
// 输出：
// 输出有H行。第i行输出第i个数字三角形从顶至低边某处的一条最优路径所经过的最大数字之和。
// 输入样例：
// 5
// 7
// 3  8
// 8  1  0
// 2  7  4  4
// 4  5  2  6  5
// 4
// 6
// 2  1
// 4  3  4
// 1  2  3  4
// 0
// 输出样例：
// 30
// 15

// f[i-1][j] = max(f[i][j],f[i][j+1])
// 动态规划方程

#include <stdlib.h>
#include <string.h>
#include <stdio.h>

int main(int argc, char const *argv[]) {
  /* code */
  int n;
  scanf("%d",&n);
  while (n!=0) {
    int list[300][300];
    
    /* code */
    for (int i = 1; i <=n; i++) {
      /* code */
      for(int j=1;j<=i;j++){
        scanf("%d",&list[i-1][j-1]);
      }
    }
    for(int i=n-1;i<=1;i--){
      for(int j=0;j<i;j++){
        if (list[i][j]<list[i][j+1]) {
          /* code */
          list[i-1][j] += list[i][j+1];
        }else{
          list[i-1][j] += list[i][j];
        }
      }
    }
    printf("最大值%d\n",list[0][0]);
    printf("%s", "下一次循环,请先输入n值：");
    scanf("%d",&n);
  }
  return 0;
}
