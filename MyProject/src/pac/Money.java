package pac;

import java.util.ArrayList;

public class Money {
    SqlMa SQL = new SqlMa();
    Student stu = new Student();
    ArrayList<String>arr = new ArrayList<>();

    public String search(String id){
        String sql = "select money from Money_Manage where id = '" + id + "'";
        arr.clear();
        SQL.search(sql,arr,1);
        return arr.get(0);
    }
    public int transfer(String num1,String num2,float w){
        if(num1.equals(num2))return 0;
        if(!stu.check(num1)||(!stu.check(num2) && !num2.equals("admin1")))return 1;
        if(num2.equals("admin1")){
            String sql = "update Money_Manage set money = money + " + Float.toString(w) + " where id = '" + num1 + "'";
            SQL.update(sql);
            return 3;
        }
        arr.clear();
        String sql = "select money from Money_Manage where id = '" + num2 + "'";
        SQL.search(sql,arr,1);
        float w1 = Float.parseFloat(arr.get(0));
        if(w1<w)return 2;
        sql = "update Money_Manage set money = money + " + Float.toString(w) + " where id = '" + num1 + "'";
        SQL.update(sql);
        sql = "update Money_Manage set money = money - " + Float.toString(w) + " where id = '" + num2 + "'";
        SQL.update(sql);
        return 3;
    }
}
