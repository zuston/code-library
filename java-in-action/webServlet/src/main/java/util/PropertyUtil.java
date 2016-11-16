package util;

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Struct;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ThreadFactory;

/**
 * Created by zuston on 16/11/12.
 */

/**
 * 读取配置文件目录
 */
public class PropertyUtil {
    public static Properties load(String filename){
        Properties prop = null;
        InputStream ins = null;
        ins = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
        if(ins==null){
            try {
                throw new FileNotFoundException("load file failure");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        prop = new Properties();
        try {
            prop.load(ins);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("close the inputstream failure");
            }
        }
        return prop;
    }

    public static int getInt(Properties prop,String key,int defaultValue){
        int value = defaultValue;
        if(prop.contains(key)){
            value = CastUtil.castInt(prop.getProperty(key));
        }
        return value;
    }

    public static int getInt(Properties prop,String key){
        return getInt(prop,key,0);
    }

    public static String getString(Properties prop,String key,String defaultValue){
        String value = defaultValue;
        if(prop.contains(key)){
            value = CastUtil.castString(prop.getProperty(key));
        }
        return value;
    }

    public static String getString(Properties prop,String key){
        return getString(prop,key,"");
    }


    public static void main(String[] args){
        Properties pop = PropertyUtil.load("dbConfig.properties");
        System.out.println(pop.getProperty("jdbc.pwd"));
    }
}
