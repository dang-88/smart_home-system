package studentapp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.apache.commons.codec.binary.Base64;

import com.sun.org.apache.xml.internal.security.Init;

import studentapp.dal.Entity.Student;
import studentapp.dal.daoimpl.StudentDaoImpl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudentJFrame extends JFrame {

	private JPanel contentPane;
	private Student student;
	private JTextField sname;
	private JTextField sage;
	private JTextField saddress;
	private JTextField snumber;
	private JTextField sphone;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudentJFrame frame = new UpdateStudentJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateStudentJFrame() {
		setTitle("更新家具信息");
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		sname = new JTextField();
		sname.setBounds(216, 66, 128, 21);
		contentPane.add(sname);
		sname.setColumns(10);
		
		sage = new JTextField();
		sage.setBounds(216, 115, 128, 21);
		contentPane.add(sage);
		sage.setColumns(10);
		
		saddress = new JTextField();
		saddress.setBounds(216, 160, 128, 21);
		contentPane.add(saddress);
		saddress.setColumns(10);
		
		snumber = new JTextField();
		snumber.setBounds(216, 211, 128, 21);
		contentPane.add(snumber);
		snumber.setColumns(10);
		
		sphone = new JTextField();
		sphone.setBounds(216, 260, 128, 21);
		contentPane.add(sphone);
		sphone.setColumns(10);
		
		JLabel labelName = new JLabel("用户名称：");
		labelName.setBounds(123, 69, 70, 15);
		contentPane.add(labelName);
		
		JLabel labelAge = new JLabel("空调状态：");
		labelAge.setBounds(123, 115, 70, 15);
		contentPane.add(labelAge);
		
		JLabel labelAddress = new JLabel("窗帘状态：");
		labelAddress.setBounds(123, 163, 70, 15);
		contentPane.add(labelAddress);
		
		JLabel labelSno = new JLabel("门的状态：");
		labelSno.setBounds(123, 217, 70, 15);
		contentPane.add(labelSno);
		
		JLabel labelPhone = new JLabel("灯的状态：");
		labelPhone.setBounds(123, 263, 70, 15);
		contentPane.add(labelPhone);
		
		JButton buttonUpdate = new JButton("\u66F4\u65B0");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStudentActionPerformed(e);
			}
		});
		buttonUpdate.setBounds(102, 328, 93, 23);
		contentPane.add(buttonUpdate);
		
		JButton buttonCancel = new JButton("\u53D6\u6D88");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		buttonCancel.setBounds(261, 330, 93, 23);
		contentPane.add(buttonCancel);
	}
	public UpdateStudentJFrame(Student student) throws HeadlessException {
		super();
		initComponents();
		this.student = student;
		sname.setText(student.getSname());
		sage.setText(student.getSage()+"");
		saddress.setText(student.getSaddress());
		snumber.setText(student.getSnumber());
		sphone.setText(student.getSphone());
	}
	
	private void updateStudentActionPerformed(ActionEvent actionEvent) {
		 StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
		try {
			student.setSname(this.sname.getText());
			student.setSage(this.sage.getText());
			student.setSaddress(this.saddress.getText());
			student.setSnumber(this.snumber.getText());			
			student.setSphone(this.sphone.getText());			
			studentDaoImpl.updateStudent(student);
			JOptionPane.showMessageDialog(this, "更新成功！");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "更新失败！");
		}		
	}
	
	private void cancelActionPerformed(ActionEvent actionEvent) {
		this.setVisible(false);
		this.dispose();
	}
}
