#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[]) {
    int n,m;
    scanf("%d %d",&n,&m);
    while (n!=0&&m!=0) {
        int count=0;
        int row[100];
        int all[100][100];
        for(int i=0;i<m;i++){
            scanf("%d",&row[i]);
            for(int j=0;j<row[i];j++){
                scanf("%d",all[i][j]);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<row[i];j++){
                if(all[i][j]==0){
                    count += i;
                }
            }
        }
    }
    return 0;
}
