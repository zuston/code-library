import java.util.Scanner;

/**
 * Created by zuston on 16-10-26.
 */
public class moreAndBetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n!=0){
            int num[] = new int[100];
            int father[] = new int[100];
            for(int i=0;i<100;i++){
                father[i] = i;
                num[i] = 0;
            }
            for (int i=0;i<n;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                a = find(father,a);
                b = find(father,b);
                father[a] = b;
            }

            for (int i=0;i<100;i++){
                for (int j=0;j<100;j++){
                    if(find(father,i)==find(father,j)){
                        num[i] ++;
                    }
                }
            }
            int max = 0;
            for (int i=0;i<100;i++){
                max = max>num[i]?max:num[i];
            }
            System.out.println(max);
            n = in.nextInt();
        }

    }

    public static int find(int father[],int a){
        if(a!=father[a]){
            return find(father,father[a]);
        }
        return father[a];
    }
}
