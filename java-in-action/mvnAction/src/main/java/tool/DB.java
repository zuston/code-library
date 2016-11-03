package tool;

import model.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 直接执行语句
     * @param sql
     * @throws SQLException
     */
    public List actQuery(String sql) throws SQLException {
        Statement stst = this.conn.createStatement();
        ResultSet rs = stst.executeQuery(sql);
        List resList = new ArrayList();
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String number = rs.getString(3);
            int patent_number = rs.getInt(5);
            company oneCompany = new company(id,name,number,patent_number);
            resList.add(oneCompany);
        }
        return resList;
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
        DB db = DB.getInstance();
        try {
            System.out.println(db.actQuery("select * from company limit 10"));
        } catch (SQLException e) {
            System.out.println("执行错误");
            e.printStackTrace();
        }

        try {
            db.prepareQuery("select * from company where id = ?",1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
