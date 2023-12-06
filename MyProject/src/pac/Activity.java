package pac;

import java.util.ArrayList;

public class Activity {
    SqlMa SQL = new SqlMa();
    ArrayList<String>arr = new ArrayList<>();
    public int input(String id,String str,String credit){
        arr.clear();
        String sql = "select id from Student";
        SQL.search(sql,arr,1);
        if(!arr.contains(id))return 1;
        sql = "insert into Credit_Manage values('" + id + "','" + str + "'," + credit + ")";
        SQL.update(sql);
        sql = "update Student set credit=credit+" + credit + " where id='" + id +"'";
        SQL.update(sql);
        return 2;
    }
    public String search(String id){
        arr.clear();
        String sql = "select credit from Student where id='" + id +"'";
        SQL.search(sql,arr,1);
        return arr.get(0);
    }

    public void look(String id, ArrayList<String>arr){
        String sql = "select * from Credit_Manage where id = '" + id + "'";
        SQL.search(sql,arr,3);
    }
}
