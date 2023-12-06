package pac;

import java.util.ArrayList;

public class Student {
    ArrayList<String>arr = new ArrayList<>();
    SqlMa SQL = new SqlMa();
    public boolean check(String id){
        String sql = "select id from Student";
        arr.clear();
        SQL.search(sql,arr,1);
        if(arr.contains(id))return true;
        return false;
    }
    public void look(String id,String[] vec){
        String sql = "select id,name,age,major,phone from Student where id='" + id + "'";
        arr.clear();
        SQL.search(sql,arr,5);
        for(int i=0;i<5;i++)vec[i] = arr.get(i);
    }
    public void put(String s1,String s2,String s3,String s4,String s5,String s6){
        String sql = "insert into Student values('" + s1 + "','" + s2 + "'," + s3 + ",'" + s4 + "','" + s5 + "'," + s6 + ")";
        SQL.update(sql);
    }
    public void delete(String id){
        String sql = "delete from Student where id='" + id + "'";
        SQL.update(sql);
    }
}
