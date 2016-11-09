package leetcode;

/**
 * Created by zuston on 16/11/8.
 */

import java.util.LinkedList;

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
        int i = 0 ;
        int flag = 0;
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
                flag--;
                StringBuilder sb = new StringBuilder();
                while (zstack.peek()!='['){
                    sb.insert(0,zstack.pop());
                }
                zstack.pop();
                String nt = new String(sb);
                int count = countStack.pop();
                String str = nt.toString();
                for(int j=0;j<count-1;j++){
                    nt += str;
                }
                if(zstack.isEmpty()){
                    res += nt;
                    i++;
                    continue;
                }
                for(char a:nt.toCharArray()){
                    zstack.push(a);
                }
                System.out.println(nt);
                i++;
                continue;
            }
            if(s.charAt(i)=='['){flag++;zstack.push(s.charAt(i));i++;continue;}
            if(flag==0){res += s.charAt(i);i++;continue;}else{
                zstack.push(s.charAt(i));i++;
            }
        }

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
        ds.decodeString("2[abc]3[cd]ef");
    }


}
