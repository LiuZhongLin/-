package studentMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SelectStudent extends JFrame implements ActionListener{
	JLabel JL = new JLabel("查询学生信息",JLabel.CENTER);
	JLabel JLNumber = new JLabel("请输入学号：");
	JTextField JTNumber = new JTextField();
	JLabel JLName = new JLabel("姓名：");
	JTextField JTName = new JTextField();
	JLabel JLClass = new JLabel("班级：");
	JTextField JTClass = new JTextField();
	JLabel JLsex = new JLabel("性别：");
	ButtonGroup BG = new ButtonGroup();
	JRadioButton JRB1 = new JRadioButton("男");
	JRadioButton JRB2 = new JRadioButton("女");
	JLabel JL1 = new JLabel("学院：");
	JTextField JT1 = new JTextField();
	JButton JBSet = new JButton("查询");
	JButton JBNext = new JButton("重置");
	String sql="";
	public SelectStudent() {
		this.setTitle("查询学生信息");
		this.setLayout(null);
		JL.setForeground(Color.red);
		JL.setFont(new java.awt.Font("宋体", Font.PLAIN, 19));
		JL.setBounds(100,30,200,40);
		this.add(JL);
		JLNumber.setBounds(100,80,100,20);
		this.add(JLNumber);
		JTNumber.setBounds(200,80,80,20);
		this.add(JTNumber);
		JLName.setBounds(100,160,60,20);
		this.add(JLName);
		JTName.setBounds(200,160,80,20);
		this.add(JTName);
		JLsex.setBounds(100,200,100,20);
		this.add(JLsex);
		JRB1.setBounds(200,200,40,20);
		JRB2.setBounds(300,200,40,20);
		JRB2.setSelected(true);
		this.add(JRB1);
		this.add(JRB2);
		BG.add(JRB1);
		BG.add(JRB2);
		JLClass.setBounds(100,280,60,20);
		this.add(JLClass);
		JTClass.setBounds(200,280,80,20);;
		this.add(JTClass);
		JL1.setBounds(100,320,60,20);
		this.add(JL1);
		JT1.setBounds(200,320,60,20);
		this.add(JT1);
		JBSet.setBounds(80,120,90,20);
		this.add(JBSet);
		JBSet.addActionListener(this);
		JBNext.setBounds(190,120,90,20);
		this.add(JBNext);
		JBNext.addActionListener(this);
		this.setBounds(10,10,500,400);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == JBSet)
		{
			String snumber = JTNumber.getText();
			String sname = JTName.getText();
			String sclass = JTClass.getText();
			String ssex = "女";
			if (JRB1.isSelected()) {
				ssex = "男";
			}
			String scollect = JT1.getText();
			sql = "select * from student where Id='"+snumber+"'";
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:student1","","");
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if (rs.next()) {
					String name = rs.getString(2);
					JTName.setText(name);
					String clas = rs.getString(3);
					JTClass.setText(clas);
					String sex = rs.getString(4);
					JRB1.setText(sex);
					String collect = rs.getString(5);
					JT1.setText(collect);
					String bir = rs.getString(6);
					int n = stm.executeUpdate(sql);
					if (n > 0) {
						JOptionPane.showMessageDialog(null,"查询成功！");
					}
					else {
						JOptionPane.showMessageDialog(null, "查询失败！");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "此用户不存在！");
				}
			} catch (Exception ee) {
				// TODO: handle exception
			}
		}
		if (e.getSource() == JBNext) {
			JTName.setText(null);
			JTName.setText(null);
			JTClass.setText(null);
			JT1.setText(null);
			JRB2.setSelected(true);
		}
	}
	public static void main(String[] args) {
		new SelectStudent();
	}
}
