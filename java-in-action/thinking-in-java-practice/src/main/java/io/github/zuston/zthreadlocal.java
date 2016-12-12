package main.java.io.github.zuston;

import java.util.HashMap;
import java.util.concurrent.ThreadFactory;

/**
 * Created by zuston on 16/11/13.
 */
public class zthreadlocal {
    public static void main(String[] args) {
        oj o = new oj();
        Thread t1 = new zthread(o);
        Thread t2 = new zthread(o);
        Thread t3 = new zthread(o);
        t1.start();
        t2.start();
        t3.start();
    }
}

class oj{
    zt<Integer> number = new zt<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public oj(){

    }

    public Integer getNumber(){
        Integer res = number.get();
        number.set(res+1);
        return res;
    }

}


class zthread extends Thread{

    private oj o = null;
    public zthread(oj o){
        this.o = o;
    }

    @Override
    public void run() {
        for(int i=0;i<30;i++){
            System.out.println(Thread.currentThread().getName()+"  "+this.o.getNumber());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class zt<T> {
    public HashMap<Thread,T> hm = new HashMap<Thread,T>();
    private T value = null;
    public zt(){
    }

    public  T get(){
        if(!hm.containsKey(Thread.currentThread())){
            hm.put(Thread.currentThread(),initialValue());
        }
        return hm.get(Thread.currentThread());
    }

    public synchronized void set(T v){
        hm.put(Thread.currentThread(),v);
    }

    protected synchronized T initialValue(){
        return null;
    }
}
