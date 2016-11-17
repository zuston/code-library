#include <stdio.h>
#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int pos[4][2] = {{1,2},{2,1},{1,-2},{2,-1}};
int p = 1000;
void find(int x,int y,int step,int c,int d){
  if(x==c&&y==d){
    p=step<p?step:p;
    return;
  }
  for (int i = 0; i < 4; i++) {
    /* code */
    int ax = x + pos[i][0];
    int ay = y + pos[i][1];
    if(ax>c||ay>d||ax<0||ay<0){
      continue;
    }
    find(ax,ay,step+1,c,d);
  }
}


int main(int argc, char const *argv[]) {
  int a,b,c,d;
  while (cin>>a>>b>>c>>d) {
    /* code */
    find(a,b,0,c,d);
    cout<<p<<endl;
  }
  return 0;
}
