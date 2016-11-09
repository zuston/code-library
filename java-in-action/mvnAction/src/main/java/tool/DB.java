package tool;

import java.sql.*;

/**
 * Created by zuston on 16-11-3.
 */
public class DB {

    public static DB dbConnection = null;
    public Connection conn = null;
    public DB(){
        System.out.println("实例化对象");
        try {
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
        dbConnection = this;
    }

    public static DB getInstance(){
        if(dbConnection==null){
            new DB();
        }
        return dbConnection;
    }



    public void prepareQuery(String sql,int value) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,value);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(2));
        }
    }

    public static void main(String[] args) {

    }
}
