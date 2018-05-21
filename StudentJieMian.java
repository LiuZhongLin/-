package studentMS;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentJieMian extends JFrame implements ActionListener{
	JMenuBar jm = new JMenuBar();
	JMenu jm1 = new JMenu("信息");
	JMenuItem jmi1 = new JMenuItem("插入");
	JMenuItem jmi2 = new JMenuItem("查询");
	JMenu jm2 = new JMenu("成绩");
	JMenuItem jmi21 = new JMenuItem("查询");
	public StudentJieMian(){
		this.setTitle("学生界面");
		this.setLayout(new CardLayout());
		this.setJMenuBar(jm);
		jm.add(jm1);
		jm.add(jm2);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jm2.add(jmi21);
		jmi21.addActionListener(this);
		this.setBounds(10,10,500,400);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jmi1){
			//new AddStudent();
		}
		if(e.getSource() == jmi2){
			//new SelectStudent();
		}
		if(e.getSource() == jmi21){
			//new SelectStudent();
		}
	}
	public static void main(String[] args) {
		new StudentJieMian();
	}
}
