public class DengLuJieMian extends Frame implements ActionListener
{
   JLabel JLUserName = new JLabel("用户名");       //使用文本创建一个标签对象
   JLabel JLPaw = new JLabel("密码");              //使用文本创建一个标签对象
   JTextField JTUserName = new JTextField();      //创建一个文本框对象
   JPasswordField JPsw = new JPasswordField();    //创建一个密码框对象
   JButton JB1 = new JButton("登录");             //创建按钮对象
   JButton JB1 = new JButton("密码");             
   JLabel JL1 = new JLbael("身份：");             //使用文本创建一个标签对象
   JComboBox JC = new JComboBox();               //创建一个组合框对象
   
   public DengLuJieMian(){
      this.setTitle("学生信息管理系统");          //设置窗口标题
      this.setLayout(null);                     //设置窗口布局管理器
      JLUserName.setBounds(100,40,100,20);      //设置姓名标签的初始位置
      this.add(JLUserName);                     //将姓名标签组件添加到容器
      JTUserName.setBounds(200,40,80,20);       //设置文本框初始位置
      this.add(JTUserName);                     //将文本框组件添加到容器
      JLPaw.setBounds(100,100,60,20);           //设置密码标签的初始位置
      this.add(JLPaw);                          //将文本框组件添加到容器
      JPsw.setBounds(100,150,80,20);            //设置密码框的初始位置
      this.add(JPsw);                           //将密码框组件添加到容器
      JL1.setBounds(100,150,60,20);             //设置身份标签的初始位置
      this.add(JL1);
      JC.setBounds(200,150,80,20);
      this.add(JC);
      JC.addItem(new String("学生"));
      JC.addItem(new String("老师"));
      JB1.setBounds(100,200,60,20);
      this.add(JB1);
      JB1.addActionListener(this);
      JB2.setBounds(200,200,60,20);
      this.add(B2);
      JB2.addActionListener(this);
      this.setVisible(true);
      this.setBounds(10,10,400,250);
      addWindowListener(new WindowAdapter()
      {
          public void windowClosing(WindowEvent e)
          {
            System.exit(0);
          }
      });
   }
   public static void main(String[] args)
   {
      new DengLuJieMian();
   }
   public void ActionPerformed(ActionEvent e)
   {
      if(e.getSource() == JB1)
      {
          String name = JTUserName.getText();
          String password = new String (JPsw.getPassword());
          String box = (String)JC.getSelectedItem();
          if((name != null && (name.eqauls("daishu"))) && (password != null) && (password.equals("0816"))))
          {
              if(box.eqauls("学生"))
              {
                //new SudentJieMian();
              }
              else if(box.equals("教师"))
              {
                //new TeacherJieMian();
              }
          }
      }
   }
}


