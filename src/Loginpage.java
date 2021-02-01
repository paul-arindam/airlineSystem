import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
;public class Loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage frame = new Loginpage();
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
	public Loginpage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(430, 200, 452, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisteredMembers = new JLabel("Registered Members");
		lblRegisteredMembers.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRegisteredMembers.setBounds(131, 11, 187, 34);
		contentPane.add(lblRegisteredMembers);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.GRAY));
		panel.setBounds(22, 61, 394, 198);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Username:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setBounds(180, 19, 78, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_1.setBounds(181, 84, 78, 14);
		panel.add(label_1);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBounds(180, 44, 200, 25);
		panel.add(user);
		
		pass = new JPasswordField();
		pass.setBounds(181, 109, 200, 25);
		panel.add(pass);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","paul","admin");
					Statement stmt=con.createStatement();
					String sql="Select * from login where username='"+user.getText()+"'and password='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Successful\n   Welcome "+user.getText());
						close();
						booking frame = new booking();
						frame.setVisible(true);
						
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					con.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button.setBounds(180, 164, 96, 26);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\Eclipseprojects\\Airline_booking\\res\\Lock.png"));
		lblNewLabel.setBounds(10, 19, 149, 158);
		panel.add(lblNewLabel);
		
		JCheckBox showpass = new JCheckBox("Show Password");
		showpass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(showpass.isSelected())
				{
					pass.setEchoChar((char)0);
				}
				else 
					pass.setEchoChar('*');
			}
		});
		showpass.setBounds(183, 135, 131, 23);
		panel.add(showpass);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home frame = new home();
				frame.setVisible(true);
				close();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(284, 164, 96, 26);
		panel.add(btnCancel);
	}
}
