package tool;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * Created by zuston on 16-11-3.
 */
abstract public class ORM {
    public static Connection conn = null;
    private void getConn(){
        try {
            System.out.println("初始化连接");
            String url="jdbc:mysql://localhost:3306/uml?user=root&password=zuston&characterEncoding=utf8";
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

        String url = String.format("insert into %s(%s) values(%s)",
                                    this.getClass().getSimpleName(),
                                    this.getClass().getDeclaredFields()[0].getName(),
                                    this.getClass().getDeclaredFields()[0].get(this));

        String tableName = this.getClass().getSimpleName();
        String sqlFormatFront = "insert into "+tableName+"(";
        String sqlFormatEnd = "values(";
        for(Field field:this.getClass().getDeclaredFields()){
            String name = field.getName();
            Object type = field.getType();
            Object value = field.get(this);
            sqlFormatFront = sqlFormatFront+name+",";
            if(type.equals(String.class)){
                sqlFormatEnd = sqlFormatEnd + "'" + (String)value + "',";
            }else{
                sqlFormatEnd = sqlFormatEnd + value + ",";
            }
        }
        sqlFormatFront = sqlFormatFront.substring(0,sqlFormatFront.length()-1)+")";
        sqlFormatEnd = sqlFormatEnd.substring(0,sqlFormatEnd.length()-1)+")";
        String sql = sqlFormatFront + " " + sqlFormatEnd;
        System.out.println(sql);

        try {
            Statement state = conn.createStatement();
            System.out.println(state.executeUpdate(sql));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
