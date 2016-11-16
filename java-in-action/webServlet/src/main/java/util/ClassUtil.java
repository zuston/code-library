package util;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zuston on 16/11/12.
 */
public class ClassUtil {
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String classname,boolean isInitialized){
        ClassLoader cl = getClassLoader();
        Class<?> cls = null;
        try {
            cls = Class.forName(classname,isInitialized,cl);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cls;
    }

    public static Set<Class<?>> getClassSet(String packageName){
        Set<Class<?>> classset = new HashSet<Class<?>>();

        try {
            Enumeration<URL> urls = getClassLoader().getResources("util");
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(url!=null){
                    String protocol = url.getProtocol();
                    if(protocol.equals("file")){
                        String packagePath = url.getPath().replaceAll("%20"," ");

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classset;
    }
}
