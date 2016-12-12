#include <stdio.h>
#include <iostream>
#include <string>
#include <stdlib.h>
#include <sstream>
using namespace std;


int a,b,c,d;
int pos[8][2] = {{-1,2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
int min = 10000;

void find(int a,int b,int c,int d){
  if()
}

int main(int argc, char const *argv[]) {
  /* code */
  while(cin>>a>>b>>c>>d){
    find(a,b,c,d,0);
    cout<<min<<endl;
  }
  return 0;
}
