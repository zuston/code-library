package main.java.io.github.zuston;

/**
 * Created by zuston on 16-11-3.
 */

import com.sun.java.swing.action.OkAction;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * 反射类型
 */
public class reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

//        ClassLoader cl = Thread.currentThread().getContextClassLoader();
//        Class ft = cl.loadClass("io.github.zuston.football");
//        System.out.println(ft.getSimpleName()+"   "+ft.getSuperclass().getSimpleName());
//        Object oj = ft.newInstance();
//        for(Method m:oj.getClass().getDeclaredMethods()){
//            System.out.println("当前方法名:"+m.getName());
//            System.out.println(m.isAnnotationPresent(action.class));
//            if(m.isAnnotationPresent(action.class)){
//                action a = m.getAnnotation(action.class);
//                System.out.println(a.url());
//            }
//        }


        ClassLoader baiduLoader = Thread.currentThread().getContextClassLoader();
        Class<?> baiduClass = Class.forName("main.com.baidu.hello",true,baiduLoader);

        System.out.println("----------------------------------");


        ClassLoader cp = Thread.currentThread().getContextClassLoader();
        Class<?> cll = Class.forName("main.java.io.github.zuston.football",false,cp);

        System.out.println("----------------------------------");



        Class newVirtual = null;
        newVirtual = Class.forName("main.java.io.github.zuston.football");
        System.out.println("当前class类名："+newVirtual.getName());
        System.out.println("当前class类："+newVirtual.getClass());
        System.out.println("是否是接口："+newVirtual.isInterface());
        for (Class c:newVirtual.getInterfaces()){
            System.out.println("class Name:"+c.getName());
            System.out.println("simple name:"+c.getSimpleName());
            System.out.println("Canoniacal name:"+c.getCanonicalName());
        }

        Object obj = null;
        obj = newVirtual.newInstance();
        System.out.println("当前实例信息："+obj.getClass());
        /**
         * 对于已经实例化的类，进行对于它的class进行判断
         */
        System.out.println(obj.getClass().getSimpleName());
        System.out.println(obj.getClass().getCanonicalName());

        System.out.println("===================");
        System.out.println("实例化类操作");
        football ftb = new football();
        System.out.println("输出class的类名"+ftb.getClass().getSimpleName());
        System.out.println("===================");

        System.out.println("====反射获取类方法=====");
        Method[] methods = ftb.getClass().getMethods();
        for (Method m : methods){
            if(m.toString().indexOf("action")!=-1){
                System.out.println("存在这个方法");
            }
            System.out.println(m);
        }

    }
}


class football implements ball{
    static {
        System.out.println("the football has generated");
    }

    @Override
    @action(url="post:/getAll")
    public void action() {
        System.out.println("the football action");
    }
}

interface ball{
    void action();
}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface action{
    public String url();
}
