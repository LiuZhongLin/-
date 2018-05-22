package studentMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentScore extends JFrame implements ActionListener{
	JLabel JL = new JLabel("查询成绩",JLabel.CENTER);
	JLabel JLNumber = new JLabel("请输入学号：");
	JTextField JTNumber = new JTextField();
	JLabel JLName = new JLabel("姓名");
	JTextField JTName = new JTextField();
	JLabel JLChinese = new JLabel("语文");
	JTextField JTChinese = new JTextField();
	JLabel JLMath = new JLabel("数学");
	JTextField JTMath = new JTextField();
	JLabel JLClass = new JLabel("班级");
	JTextField JTClass = new JTextField();
	JButton JBSet = new JButton("查询");
	JButton JBNext = new JButton("重置");
	String sql = "";
	public StudentScore() {
		this.setTitle("查询成绩");
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
		JLClass.setBounds(100,240,80,20);
		this.add(JLClass);
		JTClass.setBounds(200,240,80,20);
		this.add(JTClass);
		JLChinese.setBounds(100,280,60,20);
		this.add(JLChinese);
		JTChinese.setBounds(200,280,80,20);
		this.add(JTChinese);
		JLMath.setBounds(100,320,60,20);
		this.add(JLMath);
		JTMath.setBounds(200,320,80,20);
		this.add(JTMath);
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
		if(e.getSource() == JBSet){
			String snumber = JTNumber.getText();
			if (snumber.equals("num1")) {
				JTName.setText("num1");
			}
			String sname = JLName.getText();
			String schinese = JLChinese.getText();
			String ssex = "女";
			String smath = JLMath.getText();
			String sclass = JLClass.getText();
			sql = "select * from grade where Id='"+snumber+"'";
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:student1","","");
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if (rs.next()) {
					String name = rs.getString(2);
					JTName.setText(name);
					String chinese = rs.getString(3);
					JTChinese.setText(chinese);
					String math = rs.getString(5);
					JTMath.setText(math);
					String clas = rs.getString(6);
					JLClass.setText(clas);
					int n = stm.executeUpdate(sql);
					if(n > 0){
						JOptionPane.showMessageDialog(null, "查询成功！");
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
			JTNumber.setText(null);			
			JTName.setText(null);
			JTClass.setText(null);
			JTChinese.setText(null);
			JTMath.setText(null);
		}
	}
	public static void main(String[] args) {
		new StudentScore();
	}
}
