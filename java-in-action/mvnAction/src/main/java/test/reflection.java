package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zuston on 16/11/3.
 */
public class reflection extends base{
    public static void main(String[] args) {
        reflection rf = new reflection();
        rf.getReflection();

        System.out.println("=====向上转型=======");
        base tb = new reflection();
        tb.getReflection();
    }

    public void echo(){
        System.out.println("the echo function has been invoked");
    }

}


class base{
    public void getReflection(){
        System.out.println(this.getClass().getSimpleName());
        System.out.println(this.getClass().getSuperclass().getSimpleName());

        System.out.println("==========================");
        Object obj = null;
        try {
            obj = this.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method fun = null;
        Method fun2 = null;
        try {
            fun = this.getClass().getMethod("echo");
            fun2 = this.getClass().getMethod("echoBase");
            fun2.invoke(obj);
            fun.invoke(obj);
            System.out.println("^^^^^实践父类");
            Object parentO = this.getClass().getSuperclass().newInstance();
            Method parentFun = this.getClass().getSuperclass().getDeclaredMethods()[0];
            for(Method m:this.getClass().getSuperclass().getDeclaredMethods()){
                System.out.println(m.getName());
            }
            parentFun.invoke(parentO);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public void echoBase(){
        System.out.println("the echoBase has been invoked");
    }

    public void echo(){
        System.out.println("the base echo has been invoked");
    }
}