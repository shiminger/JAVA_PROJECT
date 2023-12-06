package pac;
import java.sql.*;
import java.util.ArrayList;

public class SqlMa {
    public void search(String sql,ArrayList<String>arr,int cnt){
        Connection conn = null;  //用于数据库连接
        Statement st = null;    //用于执行数据库语句
        ResultSet rs = null;    //用于存储查询结果
        try{
            // 加载SQLServer JDBC驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 使用DriverManager建立与数据库的连接
            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=javaProject;encrypt=true;trustServerCertificate=true","sa","728611");
            // 使用连接创建了一个Statement对象，用于执行SQL语句
            st = conn.createStatement();
            // 使用Statement对象执行SQL语句，并获取结果集
            rs = st.executeQuery(sql);

            while(rs.next()){   // 当结果集还有下一行时，进入循环 （打印3列的值）
                for(int i=1;i<=cnt;i++)arr.add(rs.getString(i));
            }
        }catch (Exception e){
            System.out.println("连接数据库失败！");
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void update(String sql){
        Connection conn = null;  //用于数据库连接
        Statement st = null;    //用于执行数据库语句
        ResultSet rs = null;    //用于存储查询结果
        try{
            // 加载SQLServer JDBC驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 使用DriverManager建立与数据库的连接
            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=javaProject;encrypt=true;trustServerCertificate=true","sa","728611");
            // 使用连接创建了一个Statement对象，用于执行SQL语句
            st = conn.createStatement();
            // 使用Statement对象执行SQL语句，并获取结果集
            st.executeUpdate(sql);

        }catch (Exception e){
            System.out.println("连接数据库失败！");
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
