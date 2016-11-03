package io.github.zuston;

/**
 * Created by zuston on 16-11-3.
 */

import java.lang.reflect.Method;

/**
 * 反射类型
 */
public class reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class newVirtual = null;
        newVirtual = Class.forName("io.github.zuston.football");
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
    public void action() {
        System.out.println("the football action");
    }
}

interface ball{
    void action();
}
