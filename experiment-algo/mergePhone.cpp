#include <stdio.h>
#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main(int argc, char const *argv[]) {

  string s1[30],s2[30],s[60];
  int n,m;

  cin>>n;
  cin.ignore();
  for(int i=0;i<n;i++){
    getline(cin,s1[i]);
  }
  cin >> m;
  cin.ignore();
  
  for (int i = 0; i < m; i++) {
    /* code */
    getline(cin,s2[i]);
  }

  int i=0;
  int j=0;
  int k=0;
  while (i<n&&j<m) {
    /* code */
    if (s1[i]<s2[j]) {
      /* code */
      s[k++] = s1[i++];
    }else if(s1[i]>s2[i]){
      s[k++] = s2[j++];
    }else{
      s[k++] = s1[i++];
      j++;
    }
  }

  while (i!=n) {
    /* code */
    s[k++] = s1[i++];
  }
  while (j!=m) {
    /* code */
    s[k++] = s2[j++];
  }

  cout<<m+n<<endl;
  for(int i=0;i<m+n;i++){
    cout << s[i] << endl;
  }

  return 0;
}
