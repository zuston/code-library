package tool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zuston on 16-11-3.
 */
abstract public class ORM {
    public static Connection conn = null;
    private void getConn(){
        try {
            System.out.println("初始化连接");
//            String url = String.format("jdbc:mysql://localhost:3306/%d?user=root&password=shacha","patent");
            String url="jdbc:mysql://localhost:3306/patent?user=root&password=shacha";
            Class.forName("com.mysql.jdbc.Driver") ;
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("连接错误");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("找不到驱动");
            e.printStackTrace();
        }
    }
    public boolean save() throws IllegalAccessException {
        if(conn==null){
            getConn();
        }
        System.out.println(this.getClass().getSimpleName());
        for(Field f:this.getClass().getDeclaredFields()){
            System.out.println("--");
            System.out.println(f.getName());
            System.out.println(f.getType());
            try {
                /**
                 * 父类获取子类的值
                 */
                System.out.println(f.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        String url = String.format("insert into %s(%s) values(%s)",
                                    this.getClass().getSimpleName(),
                                    this.getClass().getDeclaredFields()[0].getName(),
                                    this.getClass().getDeclaredFields()[0].get(this));
        System.out.println(url);
        return false;
    }
}
