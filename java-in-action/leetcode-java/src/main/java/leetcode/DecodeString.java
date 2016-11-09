package leetcode;

/**
 * Created by zuston on 16/11/8.
 */

import javafx.scene.shape.SVGPath;

import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 */
public class DecodeString {


    public String decodeString(String s) {

        String res = "";

        stack<Character> zstack = new stack();
        stack<Integer> countStack = new stack();
        StringBuilder temp = new StringBuilder();
        int i = 0 ;
        while(i<s.length()){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                int value = Integer.parseInt(s.charAt(i)+"");
                i++;
                while(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    value = value*10+Integer.parseInt(s.charAt(i)+"");
                    i++;
                }
                countStack.push(value);
                continue;
            }

            if(s.charAt(i)==']'){
                StringBuilder sb = new StringBuilder();
                while (zstack.peek()!='['){
                    sb.insert(0,zstack.pop());
                }
                zstack.pop();
                int count = countStack.pop();
                temp.insert(0,sb.toString());
                String str = temp.toString();
                for(int j=0;j<count-1;j++){
                    temp.append(str);
                }
                System.out.println(temp.toString());
                if(zstack.isEmpty()){
                    res += temp.toString();
                    temp.delete(0,temp.length());
                }
                i++;
            }else{
                System.out.println(s.charAt(i));
                zstack.push(s.charAt(i));
                i++;
            }
        }

        while (!zstack.isEmpty()){
            res += zstack.popEnd();
        }

        System.out.println(temp);
        System.out.println(res);
        return res;
    }



    class stack<T>{
        LinkedList<T> list = new LinkedList<T>();
        public void push(T str){
            list.addFirst(str);
        }
        public T pop(){
            return list.removeFirst();
        }
        public T peek(){
            return list.getFirst();
        }

        public boolean isEmpty(){
            return list.isEmpty();
        }

        public T popEnd(){
            return list.removeLast();
        }
    }


    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        ds.decodeString("sd2[f2[e]g]i");
    }


}
