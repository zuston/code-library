import java.util.Scanner;

/**
 * Created by zuston on 16-10-26.
 */
public class h7n9 {
    public static void main(String[] args) {
        int n;
        int m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        while(n!=0&&m!=0){
            int p[] = new int[n];
            int num[] = new int[m];
            for(int i=0;i<n;i++){
                p[i] = -1;
            }
            for(int i=0;i<m;i++){
                num[i] = in.nextInt();
                int a[] = new int[num[i]];
                for(int j=0;j<num[i];j++){
                    a[j] = in.nextInt();
                    int t = a[0];
                    int tt = p[a[j]];
                    if(tt==-1){
                        p[a[j]] = t;
                    }else{
                        for(int k=0;k<n;k++){
                            if(tt==p[k]){
                                p[k] = t;
                            }
                        }
                    }
                }
            }

            int count = 1;
            if(p[0]!=-1){
                for(int i=1;i<n;i++){
                    if(p[i]==p[0]){
                        count++;
                    }
                }
            }
            System.out.println(count);
            n = in.nextInt();
            m = in.nextInt();
        }
    }
}
