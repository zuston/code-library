import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zuston on 16-10-26.
 */

/**
 * 这个括号序列只需要匹配就行了
 */
public class parenthesesPattern {
    public static String parent;
    public static StringBuilder p;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        parent = in.nextLine();
        p = new StringBuilder(parent);
        expand(0,parent.length()-1);
        System.out.println(p.toString());
    }
    public static void expand(int start,int end){
        if(start>end)   return;
        if(p.charAt(start)=='('&&p.charAt(end)==')'){
            expand(start+1,end-1);
        }
        if(p.charAt(start)=='['&&p.charAt(end)==']'){
            expand(start+1,end-1);
        }

        if(p.charAt(start)==')'||p.charAt(start)==']'){
            HashMap<Character,Character> map = new HashMap<>();
            map.put(')','(');
            map.put(']','[');
            p.insert(start,map.get(p.charAt(start)));
            expand(start+2,p.length()-1);
        }

        if(p.charAt(end)==')'||p.charAt(end)==']'){
            HashMap<Character,Character> m = new HashMap<>();
            m.put(')','(');
            m.put(']','[');
            p.insert(end, m.get(p.charAt(end)));
            System.out.println(p.toString());
//            expand(start,end-1);
        }

//        if(p.charAt(start)=='('||p.charAt(start)=='['){
//
//        }

    }
}
