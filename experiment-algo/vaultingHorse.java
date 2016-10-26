import java.util.Scanner;

/**
 * Created by zuston on 16-10-26.
 */
public class vaultingHorse {
    public static int step[][] = {{2,1},{2,-1},{1,-2},{1,2}};
    public static int minCount = 100;
    public static int tx;
    public static int ty;
    public static int n;
    public static int m;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int px = in.nextInt();
        int py = in.nextInt();
        tx = in.nextInt();
        ty = in.nextInt();
        search(px,py,0);
        System.out.println("统计最小步数："+minCount);
    }
    public static void search(int px,int py,int count){
        if(px==tx&&py==ty){
            System.out.println("数目"+count);
            minCount = minCount<count?minCount:count;
            return;
        }
        for (int i=0;i<4;i++){
            int x = px+step[i][0];
            int y = py+step[i][1];
            if(x>=n||y>=m||x<0||y<0)
                continue;
            search(x,y,count+1);
        }
    }
}
