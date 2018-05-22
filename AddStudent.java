package studentMS;

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

public class AddStudent extends JFrame implements ActionListener{
	JLabel JL = new JLabel("添加基本信息",JLabel.CENTER);
	JLabel JLNumber = new JLabel("学号：");
	JTextField JTNumber = new JTextField();
	JLabel JLName = new JLabel("姓名：");
	JTextField JTName = new JTextField();
	JLabel JLClass = new JLabel("班级");
	JTextField JTClass = new JTextField();
	JLabel JLsex = new JLabel("性别");
	ButtonGroup BG = new ButtonGroup();
	JRadioButton JRB1 = new JRadioButton("男");
	JRadioButton JRB2 = new JRadioButton("女");
	JLabel JL1 = new JLabel("学院");
	JTextField JT1 = new JTextField();
	JButton JBAdd = new JButton("添加");
	JButton JBNext = new JButton("重置");
	String sql = "";
	public AddStudent() {
		this.setTitle("添加学生信息");		
		this.setLayout(null);
		JL.setBounds(100,30,200,40);
		this.add(JL);
		JLNumber.setBounds(100,80,100,20);
		this.add(JLNumber);
		JTNumber.setBounds(200,80,80,20);
		this.add(JTNumber);
		JLName.setBounds(100,120,60,20);
		this.add(JLName);
		JTName.setBounds(200,120,80,20);
		this.add(JTName);
		JLsex.setBounds(100,160,100,20);
		this.add(JLsex);
		JRB1.setBounds(200,160,40,20);
		JRB2.setBounds(300,160,40,20);
		JRB2.setSelected(true);
		this.add(JRB1);
		this.add(JRB2);
		BG.add(JRB1);
		BG.add(JRB2);
		JLClass.setBounds(100,240,60,20);
		this.add(JLClass);
		JTClass.setBounds(200,240,80,20);
		this.add(JTClass);
		JL1.setBounds(100,280,60,20);
		this.add(JL1);
		JT1.setBounds(200,280,80,20);
		this.add(JT1);
		JBAdd.setBounds(80,320,90,20);
		this.add(JBAdd);
		JBAdd.addActionListener(this);
		JBNext.setBounds(190,320,90,20);
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
		if (e.getSource() == JBAdd) {
			String snumber = JTNumber.getText();
			String sname = JTName.getText();
			String sclass = JTClass.getText();
			String ssex = "女";
			if(JRB1.isSelected()){
				ssex = "男";
			}
			String scollect = JT1.getText();
			sql = "select * from student where Id='"+snumber+"'";
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:student1","","");
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "该号已经存在！");
				}
				else {
					sql = "insert into student 99 values('"+snumber+"','"+sname+"','"+sclass+"','"+
							ssex+"','"+scollect+"'";
					int i = stm.executeUpdate(sql);
					if (i > 0 ) {
						JOptionPane.showMessageDialog(null, "添加成功！");
					}
					else {
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				}
			} catch (Exception ee) {
				// TODO: handle exception
			}
		}
		if (e.getSource() == JBNext) {
			JTNumber.setText(null);
			JTName.setText(null);
			JTClass.setText(null);
			JT1.setText(null);
			JRB2.setSelected(true);
		}
	}
	public static void main(String[] args) {
		new AddStudent();
	}
}
