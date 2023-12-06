package pac;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MFrame extends JFrame{
    Font font = new Font("Dialog",Font.BOLD,20);
    Font font0 = new Font("宋体",Font.BOLD,15);
    Font font1 = new Font("Dialog",Font.BOLD,17);
    Font font2 = new Font("Dialog",Font.BOLD,30);
    JLabel lab1 = new JLabel("学生事务管理系统");
    JTextField username = new JTextField(10);
    JPasswordField password = new JPasswordField(10);
    JButton butok = new JButton("  登录  ");
    JButton butexit = new JButton("  退出  ");
    JMenuBar menubar = new JMenuBar();
    JMenu menuhelp = new JMenu("帮助");
    JMenuItem menuitem = new JMenuItem("关于");
    CardLayout cl = new CardLayout();
    JPanel pane = new JPanel();
    public String me = "";
    JLabel labshow1 = new JLabel("查询/录入结果将在这里显示哦！");
    JLabel labshow2 = new JLabel("");
    Manager man = new Manager();
    Student stu = new Student();
    Activity act = new Activity();
    Money mon = new Money();
    String now = "login";


    public MFrame(String s){
        super(s);
        Init();
    }
    private void Init(){
        setSize(600,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        butok.setFont(font1);
        butexit.setFont(font1);
        lab1.setFont(font2);
        labshow1.setForeground(Color.GRAY);
        labshow2.setForeground(Color.GRAY);
        // 菜单
        /*-------------------------------------------------------------*/
        setJMenuBar(menubar);
        menubar.add(menuhelp);
        menuhelp.add(menuitem);
        menuitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl.show(pane,"about");
            }
        });
        JPanel pan0 = new JPanel();
        pan0.setLayout(null);
        JLabel l1 = new JLabel("        #欢迎使用本管理系统！以下将介绍该程序相关事项#");
        JLabel l2 = new JLabel("---------------------------------------------------------------------");
        JLabel l3 = new JLabel("    本程序包含1位主管理员'admin1'以及若干位次管理员。其中，主管理员账号无");
        JLabel l4 = new JLabel("法注销，且主管理员有权限查看管理员名单，次管理员无法查看管理员名单。");
        JLabel l5 = new JLabel("    在学生信息页面可根据学号查看该学生除学分和余额外的相关信息，并可进行录");
        JLabel l6 = new JLabel("入信息操作和根据学号删除对应学生信息的操作。");
        JLabel l7 = new JLabel("    在学分页面可录入/查询x学生在x活动中获得了x学分量和查询学生的学分总量。");
        JLabel l8 = new JLabel("    在学生资金页面可进行学生间的转账操作，也可从'admin1'源对学生进行充值。");
        JLabel l9 = new JLabel("---------------------------------------------------------------------");

        JButton b1 = new JButton("返回");
        b1.setFont(font1);
        l1.setFont(font);
        l2.setFont(font0);
        l3.setFont(font0);
        l4.setFont(font0);
        l5.setFont(font0);
        l6.setFont(font0);
        l7.setFont(font0);
        l8.setFont(font0);
        l9.setFont(font0);
        pan0.add(l1);
        pan0.add(b1);
        pan0.add(l2);
        pan0.add(l3);
        pan0.add(l4);
        pan0.add(l5);
        pan0.add(l6);
        pan0.add(l7);
        pan0.add(l8);
        pan0.add(l9);
        l1.setBounds(0,0,600,20);
        l2.setBounds(0,30,600,20);
        l3.setBounds(0,60,600,20);
        l4.setBounds(0,85,600,20);
        l5.setBounds(0,110,600,20);
        l6.setBounds(0,135,600,20);
        l7.setBounds(0,160,600,20);
        l8.setBounds(0,185,600,20);
        l9.setBounds(0,250,600,20);
        b1.setBounds(250,310,100,35);
        l1.setForeground(Color.BLUE);
        l2.setForeground(Color.MAGENTA);
        l9.setForeground(Color.MAGENTA);

        b1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl.show(pane,now);
            }
        });

        // 页面一（登录）
        /*-------------------------------------------------------------*/
        JPanel pan1 = new JPanel();
        BoxLayout box = new BoxLayout(pan1,BoxLayout.Y_AXIS);
        pan1.setLayout(box);
        JPanel pan = new JPanel();
        pan1.add(pan);
        pan.add(lab1);
        pan1.add(pan);
        pan = new JPanel();
        pan1.add(pan);
        pan.add(new JLabel("用户名： "));
        pan.add(username);
        pan1.add(pan);
        pan = new JPanel();
        pan.add(new JLabel("密码：   "));
        pan.add(password);
        pan1.add(pan);
        pan = new JPanel();
        pan.add(butok);
        pan1.add(pan);
        pan = new JPanel();
        pan.add(butexit);
        pan1.add(pan);
        pan1.add(new JPanel());
        butok.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOk(evt);}
        });
        butexit.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        // 页面二（首页）
        /*-------------------------------------------------------------*/
        JPanel pan2 = new JPanel();
        pan2.setLayout(null);
        JButton but_st = new JButton("学生信息管理");
        JButton but_ac = new JButton("学分活动管理");
        JButton but_mo = new JButton("学生资金管理");
        JButton but_back = new JButton("返回登录");
        JButton but_ma = new JButton("管理员账号管理");
        but_st.setFont(font1);
        but_ac.setFont(font1);
        but_mo.setFont(font1);
        but_back.setFont(font1);
        but_ma.setFont(font1);
        pan2.add(but_st);
        pan2.add(but_ac);
        pan2.add(but_mo);
        pan2.add(but_back);
        pan2.add(but_ma);
        but_st.setBounds(80,50,180,35);
        but_ac.setBounds(80,150,180,35);
        but_mo.setBounds(80,250,180,35);
        but_ma.setBounds(320,100,180,35);
        but_back.setBounds(350,200,120,35);
        but_st.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSt(evt);}
        });
        but_ac.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAc(evt);}
        });
        but_mo.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMo(evt);}
        });
        but_ma.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMa(evt);}
        });
        but_back.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBack(evt);}
        });
        // 页面三（管理员账号）
        /*-------------------------------------------------------------*/
        JPanel pan3 = new JPanel();
        pan3.setLayout(null);
        JButton but_put_ma = new JButton("添加管理员");
        JButton but_ma_ma = new JButton("管理员账号名单");
        JButton but_cancle = new JButton("注销此账号");
        JButton but_back1 = new JButton("返回");
        but_put_ma.setFont(font1);
        but_cancle.setFont(font1);
        but_ma_ma.setFont(font1);
        but_back1.setFont(font1);
        pan3.add(but_put_ma);
        pan3.add(but_back1);
        pan3.add(but_ma_ma);
        pan3.add(but_cancle);
        but_put_ma.setBounds(70,50,170,35);
        but_ma_ma.setBounds(70,150,170,35);
        but_cancle.setBounds(320,50,170,35);
        but_back1.setBounds(320,150,170,35);
        but_put_ma.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPutMa(evt);}
        });
        but_ma_ma.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMaMa(evt);}
        });
        but_cancle.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancle(evt);}
        });
        but_back1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBack1(evt);}
        });
        // 页面四（学生信息）
        /*-------------------------------------------------------------*/
        JPanel pan4 = new JPanel();
        pan4.setLayout(null);
        labshow1.setFont(font1);
        pan4.add(labshow1);
        labshow1.setBounds(70,200,500,35);
        labshow2.setFont(font1);
        pan4.add(labshow2);
        labshow2.setBounds(70,250,500,35);
        JButton but_st1 = new JButton("查询学生信息");
        JButton but_st2 = new JButton("录入学生信息");
        JButton but_back2 = new JButton("返回");
        JButton but_st3 = new JButton("删除学生信息");
        but_st1.setFont(font1);
        but_st2.setFont(font1);
        but_st3.setFont(font1);
        but_back2.setFont(font1);
        pan4.add(but_st1);
        pan4.add(but_st2);
        pan4.add(but_st3);
        pan4.add(but_back2);
        but_st1.setBounds(70,100,170,35);
        but_st2.setBounds(320,70,170,35);
        but_st3.setBounds(320,130,170,35);
        but_back2.setBounds(230,310,100,35);
        but_st1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSt1(evt);}
        });
        but_st2.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSt2(evt);}
        });
        but_back2.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBack1(evt);}
        });
        but_st3.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSt3(evt);}
        });
        // 页面五（活动页面）
        /*-------------------------------------------------------------*/
        JPanel pan5 = new JPanel();
        pan5.setLayout(null);
        JButton but_ac1 = new JButton("录入活动");
        JButton but_ac2 = new JButton("学生学分查询");
        JButton but_ac3 = new JButton("学生活动查询");
        JButton but_ac4 = new JButton("返回");
        but_ac1.setFont(font1);
        but_ac2.setFont(font1);
        but_ac3.setFont(font1);
        but_ac4.setFont(font1);
        pan5.add(but_ac1);
        pan5.add(but_ac2);
        pan5.add(but_ac3);
        pan5.add(but_ac4);
        but_ac1.setBounds(140,60,170,35);
        but_ac2.setBounds(140,160,170,35);
        but_ac3.setBounds(140,260,170,35);
        but_ac4.setBounds(370,155,120,45);
        but_ac1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAc1(evt);}
        });
        but_ac2.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAc2(evt);}
        });
        but_ac3.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAc3(evt);}
        });
        but_ac4.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBack1(evt);}
        });
        // 页面六（资金管理）
        /*-------------------------------------------------------------*/
        JPanel pan6 = new JPanel();
        pan6.setLayout(null);
        JButton but_m1 = new JButton("余额查询");
        JButton but_m2 = new JButton("转账");
        JButton but_m3 = new JButton("返回");
        but_m1.setFont(font1);
        but_m2.setFont(font1);
        but_m3.setFont(font1);
        pan6.add(but_m1);
        pan6.add(but_m2);
        pan6.add(but_m3);
        but_m1.setBounds(80,100,170,35);
        but_m2.setBounds(320,100,170,35);
        but_m3.setBounds(200,250,170,35);
        but_m1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMo1(evt);}
        });
        but_m2.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMo2(evt);}
        });
        but_m3.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBack1(evt);}
        });

        /*-------------------------------------------------------------*/
        pane.setLayout(cl);
        pane.add(pan1,"login");
        pane.add(pan2,"main");
        pane.add(pan3,"manager");
        pane.add(pan4,"student");
        pane.add(pan5,"activity");
        pane.add(pan6,"money");
        pane.add(pan0,"about");
        setContentPane(pane);
        /*-------------------------------------------------------------*/
        setVisible(true);
    }



    public void butOk(java.awt.event.ActionEvent evt){
        String us = username.getText();
        System.out.println("您输入的用户名为："+us);
        String pa = new String(password.getPassword());
        System.out.println("您输入的密码为："+pa);
        Login login = new Login();
        username.setText("");
        password.setText("");
        int p = login.check(us,pa);
        switch (p){
            case 1:
                System.out.println("该管理员不存在！");
                JOptionPane.showMessageDialog(this,"该管理员不存在，请重新输入！","登录失败",JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                System.out.println("密码错误！");
                JOptionPane.showMessageDialog(this,"密码错误，请重新输入！","登录失败",JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                System.out.println("登录成功！");
                cl.show(pane,"main");
                now = "main";
                me = us;
                break;
        }
    }
    public void butSt(java.awt.event.ActionEvent evt){
        System.out.println("进入学生信息页面");
        cl.show(pane,"student");
        now = "student";
    }
    public void butAc(java.awt.event.ActionEvent evt){
        System.out.println("进入学生活动页面");
        cl.show(pane,"activity");
        now = "activity";
    }
    public void butMo(java.awt.event.ActionEvent evt){
        System.out.println("进入资金管理页面");
        cl.show(pane,"money");
        now = "money";
    }
    public void butMa(java.awt.event.ActionEvent evt){
        System.out.println("进入管理员账号管理页面");
        cl.show(pane,"manager");
        now = "manager";
    }
    public void butBack(java.awt.event.ActionEvent evt){
        System.out.println("返回登录");
        cl.show(pane,"login");
        now = "login";
    }
    public void butPutMa(java.awt.event.ActionEvent evt){
        String num1 = String.format(JOptionPane.showInputDialog(this, "请添加管理员用户名："));
        System.out.println("添加管理员用户名："+num1);
        String num2 = String.format(JOptionPane.showInputDialog(this, "请添加管理员密码："));
        System.out.println("添加管理员密码："+num2);
        int p = man.put(num1,num2);
        switch (p){
            case 1:
                JOptionPane.showMessageDialog(this,"用户名或密码长度有误，合法长度区间为[6,11]！","操作失败",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("管理员录入失败");
                break;
            case 2:
                JOptionPane.showMessageDialog(this,"该管理员已存在","操作失败",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("管理员录入失败");
                break;
            default:
                JOptionPane.showMessageDialog(this,"管理者账号录入成功！","操作成功",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("管理员录入成功");
                break;
        }
    }
    public void butMaMa(java.awt.event.ActionEvent evt){
        if(!me.equals("admin1")){
            JOptionPane.showMessageDialog(this,"管理员名单仅管理员'admin1'有权限查看哦！","无查看权限",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("查看管理员名单失败");
        }else{
            JPanel jp = new JPanel();
            jp.setLayout(null);
            ArrayList<String> arr = new ArrayList<>();
            man.look(arr);
            DefaultListModel<String> li = new DefaultListModel<>();
            for(int i=0;i<arr.size();i++)li.addElement(arr.get(i));
            JList list = new JList(li);
            list.setFont(font1);
            jp.add(list);
            list.setBounds(100,60,130,200);
            JButton b1 = new JButton("返回");
            jp.add(b1);
            b1.setBounds(300,100,100,35);
            b1.setFont(font1);
            b1.addActionListener(new java.awt.event.ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cl.show(pane,"manager");
                    now = "manager";
                    pane.remove(jp);
                }
            });
            pane.add(jp,"list");
            cl.show(pane,"list");
            now = "list";
        }
    }
    public void butCancle(java.awt.event.ActionEvent evt){
        if(me.equals("admin1")){
            JOptionPane.showMessageDialog(this,"该管理员为主管理员'admin1'，账号无法注销！","注销失败",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("注销失败");
        } else{
            String num1 = String.format(JOptionPane.showInputDialog(this, "请输入当前用户的密码："));
            if(man.check(me,num1)){
                cl.show(pane,"login");
                man.delete(me);
                JOptionPane.showMessageDialog(this,"管理员注销成功！","注销成功",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("管理员：'"+me+"'已注销");
            }else{
                JOptionPane.showMessageDialog(this,"密码错误，注销失败","注销失败",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("注销失败");
            }
        }
    }
    public void butBack1(java.awt.event.ActionEvent evt){
        System.out.println("返回首页");
        cl.show(pane,"main");
        now = "main";
        labshow1.setText("查询/录入结果将在这里显示哦！");
        labshow2.setText("");
        labshow1.setForeground(Color.GRAY);
        labshow2.setForeground(Color.GRAY);
    }
    public void butSt1(java.awt.event.ActionEvent evt){
        labshow1.setText("");
        labshow2.setText("");
        String num1 = String.format(JOptionPane.showInputDialog(this, "请输入学生学号："));
        if(!stu.check(num1)){
            JOptionPane.showMessageDialog(this,"该学生不存在！","查找失败",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("学生信息查找失败");
        }else{
            labshow1.setForeground(Color.BLUE);
            labshow2.setForeground(Color.BLUE);
            String[] vec = new String[5];
            stu.look(num1,vec);
            String s = "学号：" + num1 + "，   姓名：" + vec[1] + "，   年龄：" + vec[2];
            labshow1.setText(s);
            s = "专业：" + vec[3] + "，   联系方式：" + vec[4];
            labshow2.setText(s);
            System.out.println("学生信息查找成功");
        }
    }
    public void butSt2(java.awt.event.ActionEvent evt){
        labshow2.setText("");
        labshow1.setText("");
        String num1 = String.format(JOptionPane.showInputDialog(this, "请输入学生学号："));
        if(num1.length()!=10){
            JOptionPane.showMessageDialog(this,"学号长度不合法！","录入失败",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("录入失败");
        } else if (stu.check(num1)) {
            JOptionPane.showMessageDialog(this,"该学生已存在！","录入失败",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("录入失败");
        }else{
            System.out.println("录入学号为："+num1);
            String num2 = String.format(JOptionPane.showInputDialog(this, "请输入学生姓名："));
            System.out.println("录入姓名为："+num2);
            String num3 = String.format(JOptionPane.showInputDialog(this, "请输入学生年龄："));
            System.out.println("录入年龄为："+num3);
            String num4 = String.format(JOptionPane.showInputDialog(this, "请输入学生专业："));
            System.out.println("录入专业为："+num4);
            String num5 = String.format(JOptionPane.showInputDialog(this, "请输入学生联系方式："));
            System.out.println("录入联系方式为："+num5);
            String num6 = String.format(JOptionPane.showInputDialog(this, "请输入学生所得学分："));
            System.out.println("录入学分为："+num6);
            stu.put(num1,num2,num3,num4,num5,num6);
            JOptionPane.showMessageDialog(this,"学生信息录入成功！","录入成功",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("学生："+num1+" ，已录入");
            String s = "学生：" + num1 + "， 已录入";
            labshow1.setForeground(Color.BLACK);
            labshow1.setText(s);
        }
    }
    public void butSt3(java.awt.event.ActionEvent evt){
        labshow1.setText("");
        labshow2.setText("");
        String num1 = String.format(JOptionPane.showInputDialog(this, "请输入删除的学生学号："));
        if(!stu.check(num1))JOptionPane.showMessageDialog(this,"该学生不存在！","删除失败",JOptionPane.INFORMATION_MESSAGE);
        else{
            labshow1.setForeground(Color.RED);
            labshow1.setText("学生："+num1+"， 已删除");
            stu.delete(num1);
            JOptionPane.showMessageDialog(this,"学生已删除！","删除成功",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("学生："+num1+"， 已删除");
        }
    }
    public void butAc1(java.awt.event.ActionEvent evt){
        String num1 = String.format(JOptionPane.showInputDialog(this, "请输入学生学号："));
        String num2 = String.format(JOptionPane.showInputDialog(this, "请输入活动名称："));
        String num3 = String.format(JOptionPane.showInputDialog(this, "请输入活动学分："));
        int p = act.input(num1,num2,num3);
        switch (p){
            case 1:
                JOptionPane.showMessageDialog(this,"该学生不存在！","录入失败",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("活动录入失败");
                break;
            default:
                JOptionPane.showMessageDialog(this,"活动添加成功","录入成功",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("活动录入成功");
                break;
        }
    }
    public void butAc2(java.awt.event.ActionEvent evt){
        String num1 = String.format(JOptionPane.showInputDialog(this, "请输入学生学号："));
        if(!stu.check(num1)){
            JOptionPane.showMessageDialog(this,"该学生不存在！","查询失败",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("学分查询失败");
        }else{
            JOptionPane.showMessageDialog(this,"该学生学分为："+act.search(num1),"查询成功",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("学分查询成功");
        }
    }
    public void butAc3(java.awt.event.ActionEvent evt){
        String num1 = String.format(JOptionPane.showInputDialog(this, "请输入学生学号："));
        if(!stu.check(num1)){
            JOptionPane.showMessageDialog(this,"该学生不存在！","查询失败",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("学分查询失败");
            return;
        }
        JPanel jp = new JPanel();
        jp.setLayout(null);
        ArrayList<String> arr = new ArrayList<>();
        act.look(num1,arr);
        DefaultListModel<String> li = new DefaultListModel<>();
        StringBuilder s = new StringBuilder("");
        for(int i=0;i<arr.size();i++){
            if(i%3==0){
                s.append("学号：");
                s.append(arr.get(i));
                s.append(" ---- ");
            } else if (i%3==1) {
                s.append("活动：");
                s.append(arr.get(i));
                s.append(" ---- ");
            }else{
                s.append("学分：");
                s.append(arr.get(i));
                li.addElement(s.toString());
                s = new StringBuilder("");
            }
        }
        JList list = new JList(li);
        list.setFont(font1);
        jp.add(list);
        list.setBounds(10,10,550,300);
        JButton b1 = new JButton("返回");
        jp.add(b1);
        b1.setBounds(210,330,150,35);
        b1.setFont(font1);
        b1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl.show(pane,"activity");
                now = "activity";
                pane.remove(jp);
            }
        });
        pane.add(jp,"list");
        cl.show(pane,"list");
        now = "list";
    }
    public void butMo1(java.awt.event.ActionEvent evt){
        String num1 = String.format(JOptionPane.showInputDialog(this, "请输入学生学号："));
        if(!stu.check(num1)){
            JOptionPane.showMessageDialog(this,"该学生不存在！","查询失败",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("余额查询失败");
        }else{
            JOptionPane.showMessageDialog(this,"该学生余额为："+mon.search(num1),"查询成功",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("余额查询成功");
        }
    }
    public void butMo2(java.awt.event.ActionEvent evt){
        JPanel jp = new JPanel();
        jp.setLayout(null);
        JLabel lab1 = new JLabel("资金流入方：");
        JLabel lab2 = new JLabel(" <<--- 资金流出方：");
        JLabel lab = new JLabel("转账金额：");
        JLabel lab3 = new JLabel("资金流出方若非学生请填写'admin1'！");
        JButton but = new JButton("转账");
        JButton but1 = new JButton("返回");
        but.setFont(font1);
        but1.setFont(font1);
        jp.add(but);
        jp.add(but1);
        but.setBounds(180,250,170,35);
        but1.setBounds(180,310,170,35);
        lab1.setFont(font1);
        lab2.setFont(font1);
        lab3.setFont(font1);
        lab.setFont(font1);
        JTextField id1 = new JTextField(10);
        JTextField id2 = new JTextField(10);
        JTextField mo = new JTextField(10);
        id1.setFont(font1);
        id2.setFont(font1);
        mo.setFont(font1);
        jp.add(lab1);
        jp.add(lab2);
        jp.add(id1);
        jp.add(id2);
        jp.add(mo);
        jp.add(lab3);
        jp.add(lab);
        lab1.setBounds(30,40,110,35);
        id1.setBounds(140,40,110,35);
        lab2.setBounds(255,40,150,35);
        id2.setBounds(410,40,110,35);
        lab3.setBounds(30,170,500,35);
        lab.setBounds(140,100,100,35);
        mo.setBounds(250,100,100,35);
        lab3.setForeground(Color.GRAY);

        pane.add(jp,"m1");
        cl.show(pane,"m1");
        now = "m1";
        but.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    String num1 = id1.getText();
                    String num2 = id2.getText();
                    float w = Float.parseFloat(mo.getText());
                    int p = mon.transfer(num1,num2,w);
                    switch (p) {
                        case 0:
                            JOptionPane.showMessageDialog(jp, "单人转账无意义！", "转账失败", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(jp, "输入对象不存在！", "转账失败", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(jp, "资金流出方余额不足！", "转账失败", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            id1.setText("");
                            id2.setText("");
                            mo.setText("");
                            lab3.setForeground(Color.BLUE);
                            lab3.setText(num2 + " --> " + num1 + " ,转账金额：" + Float.toString(w) + " , 转账成功！");
                            JOptionPane.showMessageDialog(jp, "转账成功", "转账成功", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                }catch(Exception e){
                    id1.setText("");
                    id2.setText("");
                    mo.setText("");
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(jp, "操作有误！", "异常", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        but1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cl.show(pane,"money");
                pane.remove(jp);
            }
        });
    }




    public static void main(String[] args){
        MFrame frame = new MFrame("管理系统");
    }
}

