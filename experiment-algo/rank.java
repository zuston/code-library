import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by zuston on 16-10-26.
 */
public class rank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n!=0){
            TreeSet<Integer> set = new TreeSet<>();
            for (int i=0;i<n;i++){
                set.add(in.nextInt());
            }
            Iterator<Integer> i = set.iterator();
            while (i.hasNext()){
                System.out.print(i.next()+" ");
            }
        }
    }
}
