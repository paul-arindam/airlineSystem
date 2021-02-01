import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class registration extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField user;
	private JPasswordField pass;
	private JTextField email;
	private JTextField country;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void close()
	{
		
		WindowEvent winclose=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
		
	}

	/**
	 * Create the frame.
	 */
	public registration() {
		setTitle("Registration");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(335, 130, 740, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, new Color(128, 128, 128), new Color(192, 192, 192), new Color(128, 128, 128)));
		panel.setBounds(0, 78, 426, 399);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFirstName.setBounds(50, 45, 80, 14);
		panel.add(lblFirstName);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(140, 41, 200, 24);
		panel.add(fname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(140, 80, 200, 24);
		panel.add(lname);
		
		JLabel label_1 = new JLabel("Last Name :");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_1.setBounds(57, 84, 73, 14);
		panel.add(label_1);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(50, 122, 80, 14);
		panel.add(lblUsername);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBounds(140, 118, 200, 24);
		panel.add(user);
		
		pass = new JPasswordField();
		pass.setBounds(140, 160, 200, 24);
		panel.add(pass);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(57, 164, 73, 14);
		panel.add(lblPassword);
		
		JLabel label_4 = new JLabel("Email_ID :");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_4.setBounds(58, 210, 73, 14);
		panel.add(label_4);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(141, 206, 200, 24);
		panel.add(email);
		
		JDateChooser dob = new JDateChooser();
		dob.setBounds(140, 285, 200, 24);
		dob.setDateFormatString("yyyy-MM-dd");
		panel.add(dob);
		
		JLabel label_5 = new JLabel("Country :");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_5.setBounds(57, 326, 73, 17);
		panel.add(label_5);
		
		JLabel lbldateOfBirth = new JLabel("Date Of Birth :");
		lbldateOfBirth.setHorizontalAlignment(SwingConstants.TRAILING);
		lbldateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbldateOfBirth.setBounds(29, 289, 101, 14);
		panel.add(lbldateOfBirth);
		
		country = new JTextField();
		country.setColumns(10);
		country.setBounds(140, 323, 200, 24);
		panel.add(country);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(140, 245, 200, 24);
		panel.add(phone);
		
		JLabel labelphone = new JLabel("Phone:");
		labelphone.setHorizontalAlignment(SwingConstants.TRAILING);
		labelphone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		labelphone.setBounds(57, 248, 73, 17);
		panel.add(labelphone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY));
		panel_1.setBounds(436, 78, 288, 399);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","paul","admin");
					String sql1="insert into customer (fname,lname,email,phone,dob,country) values (?,?,?,?,?,?)";
					
					String sql2="insert into login (username,password) values (?,?)";
					
					PreparedStatement stmt1=con.prepareStatement(sql1);
					PreparedStatement stmt2=con.prepareStatement(sql2);
					
					
					stmt1.setString(1,fname.getText());
					stmt1.setString(2,lname.getText());
					stmt1.setString(3,email.getText());
					stmt1.setString(4,phone.getText());
					stmt1.setString(5,((JTextField)dob.getDateEditor().getUiComponent()).getText());
					stmt1.setString(6,country.getText());
					
					stmt2.setString(1,user.getText());
					stmt2.setString(2,pass.getText().toString());
					
					stmt1.execute();
					stmt2.execute();
					JOptionPane.showMessageDialog(null, "You have been Successfully Registered as "+fname.getText()+" "+lname.getText());
					
					con.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		button.setBounds(82, 125, 97, 29);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Clear");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fname.setText(null);
				lname.setText(null);
				user.setText(null);
				pass.setText(null);
				email.setText(null);
				phone.setText(null);
				dob.setDate(null);
				country.setText(null);
			}
		});
		button_1.setBounds(82, 183, 97, 29);
		panel_1.add(button_1); 
		
		JButton button_2 = new JButton("Cancel");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home frame = new home();
				frame.setVisible(true);
				close();
			}
		});
		button_2.setBounds(82, 240, 97, 29);
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY));
		panel_2.setBounds(0, 0, 724, 67);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter your informations to create a new account.");
		lblPleaseEnterYour.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPleaseEnterYour.setBounds(90, 36, 396, 25);
		panel_2.add(lblPleaseEnterYour);
		
		JLabel lblRegisterToVvit = new JLabel("Register to Airlines Booking System");
		lblRegisterToVvit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRegisterToVvit.setBounds(93, 11, 310, 25);
		panel_2.add(lblRegisterToVvit);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("G:\\Eclipseprojects\\Airline_booking\\res\\logo.jpg"));
		label_6.setBounds(10, 8, 65, 50);
		panel_2.add(label_6);
	}
}
