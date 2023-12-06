package pac;

import java.util.ArrayList;

public class Manager {
    SqlMa SQL = new SqlMa();
    ArrayList<String> arr = new ArrayList<>();
    public int put(String us,String pa){
        arr.clear();
        if(us.length()>11||us.length()<6||pa.length()>11||pa.length()<6)return 1;
        String sql = "select username from User_Manage";
        SQL.search(sql,arr,1);
        if(arr.contains(us))return 2;
        sql = "insert into User_Manage values('" + us + "','" + pa + "')";
        SQL.update(sql);
        return 3;
    }
    public void look(ArrayList<String>arr){
        String sql = "select username from User_Manage";
        SQL.search(sql,arr,1);
    }
    public boolean check(String us,String pa){
        String sql = "select password from User_Manage where username='" + us + "'";
        arr.clear();
        SQL.search(sql,arr,1);
        if(arr.get(0).equals(pa))return true;
        return false;
    }
    public void delete(String us){
        String sql = "delete from User_Manage where username='" + us + "'";
        SQL.update(sql);
    }
}
