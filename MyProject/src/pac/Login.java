package pac;
import java.util.ArrayList;

public class Login {   // 登录判断
    ArrayList<String>arr1 = new ArrayList<>();
    ArrayList<String>arr2 = new ArrayList<>();
    SqlMa SQL = new SqlMa();
    public int check(String us,String pa){
        String sql = "select username from User_Manage";
        SQL.search(sql,arr1,1);
        if(!arr1.contains(us))return 1;
        sql = "select password from User_Manage where username='" + us + "'";
        SQL.search(sql,arr2,1);
        if(!arr2.get(0).equals(pa))return 2;
        return 3;
    }
}
