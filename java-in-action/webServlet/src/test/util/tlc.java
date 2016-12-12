package util;

/**
 * Created by zuston on 16/11/12.
 */
public class tlc {
    private static ThreadLocal<Integer> numberC = new ThreadLocal<Integer>(){
        protected Integer initialValue(){
            return 0;
        }
    };


    public int getNumber(){
        int number = numberC.get();
        int p = number+1;
        numberC.set(p);
        return number;
    }



    public static void main(String[] args) {
        tlc a = new tlc();
        Thread a1 = new client(a);
        Thread a2 = new client(a);
        Thread a3 = new client(a);
        a1.start();
        a2.start();
        a3.start();
    }
}


class client extends Thread{
    public tlc a;
    public client(tlc a){
        this.a = a;
    }

    public void run(){
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+" => "+a.getNumber());
        }
    }
}
