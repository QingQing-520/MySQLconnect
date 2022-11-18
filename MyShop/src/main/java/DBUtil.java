import com.mysql.cj.util.EscapeTokenizer;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Kalvin
 */
public class DBUtil {
    public static String url = "jdbc:mysql://localhost:3306/mysql_DB?useSSL=false ";
    public static String user = "root";
    public static String password = "tv228222";

    //載入驅動
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("找不到驅動程式類別");
            e.printStackTrace();
        }
    }

    //SQLcreat
    static String strcre = "create table member (" + "id Integer primary key," + "name varchar(10)," + "sex varchar(10))";

    //SQL查詢語法
    static String strRead = "select * from mysql_DB.member where name like '%r%'";

    //SQL更新語法
    static String strUpdate = "update mysql_DB.member set name='merry' where name='jerry'";

    //SQL刪除語法



    //建立取得資料庫連街物件靜態方法
    public static Connection getConnection() {
        //取得資料庫連接物件
        Connection connection = null;
        try {
            //與資料庫連接
            connection = DriverManager.getConnection(url, user, password);
            //獲取SQL語法
            //ResultSet.TYPE_SCROLL_INSENSITIVE:使結果可以來回查看
            //ResultSet.CONCUR_UPDATATABLE:指定可以更新結果集
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //增加物件
            // statement.executeUpdate(strcre);

            //建立查詢物件
//            ResultSet rsR = statement.executeQuery(strRead);

            //查詢物件loop
//            while (rsR.next()){
//                System.out.println("第" + rsR.getRow() + "筆");
//                System.out.print(rsR.getInt("id") + "\t");
//                System.out.print(rsR.getString("name") + "\t");
//                System.out.println(rsR.getString("sex") + "\t");
//            }

            //更新物件
//            int count = statement.executeUpdate(strUpdate);
//            System.out.println("更新" + count +"筆");
//            System.out.println("connection open.");

        //System.out.println("member 資料表已建立");

//        新增成員進table
//        String[] str ={
//                "insert into mysql_DB.member(id,name,sex) values(3,\"marry\",\"女\")"
//        };
//        int count ;
//        for(String tmp:str){
//            count = statement.executeUpdate(tmp);
//            System.out.println("新增："+ count + "筆");
//        }


//        //移到資料庫結尾
//        rs.last();
//        if (rs.isLast()){
//            System.out.println("資料庫結尾");
//        }

//        //移到資料庫開頭
//        rs.first();
//        if (rs.isFirst()){
//            System.out.println("資料庫結開頭");
//        }
//
//        //移到資料庫第二筆
//        rs.absolute(2);
//        System.out.println(rs.getString("name") + "\t");
//        System.out.println();

//        //取得欄位數量
//        int columns = rs.getMetaData().getColumnCount();
//        for (int i = 1; i <= columns; i++){
//            System.out.print(rs.getMetaData().getColumnName(i) + ":");//取得欄位名稱
//            System.out.println(rs.getMetaData().getColumnTypeName(i));//取得欄位資料型態
//        }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
    //關閉資料
    public static void close(Connection connection){
        try {
            connection.close();
            System.out.println("connection close.");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}