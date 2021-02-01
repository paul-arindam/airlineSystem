import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void close()
	{
		
		WindowEvent winclose=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
		
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setTitle("Airlines Booking");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(335, 130, 740, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToVvit = new JLabel("Airlines Booking System");
		lblWelcomeToVvit.setForeground(Color.DARK_GRAY);
		lblWelcomeToVvit.setBackground(Color.WHITE);
		lblWelcomeToVvit.setFont(new Font("Castellar", Font.BOLD | Font.ITALIC, 30));
		lblWelcomeToVvit.setBounds(121, 49, 519, 44);
		contentPane.add(lblWelcomeToVvit);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("Login to existing account.");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					close();
					Loginpage frame = new Loginpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnLogin.setBounds(281, 244, 153, 29);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					registration frame = new registration();
					frame.setVisible(true);
					close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnRegister.setToolTipText("Create a new account.");
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnRegister.setBounds(281, 327, 153, 29);
		contentPane.add(btnRegister);
		
		JButton btnSkipLogin = new JButton("Skip Login");
		btnSkipLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				booking frame = new booking();
				frame.setVisible(true);
			}
		});
		btnSkipLogin.setToolTipText("Create a new account.");
		btnSkipLogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnSkipLogin.setBounds(281, 410, 153, 29);
		contentPane.add(btnSkipLogin);
		
		JLabel lblWelcomeLoginTo = new JLabel("Welcome! Login to access you account");
		lblWelcomeLoginTo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblWelcomeLoginTo.setBounds(221, 209, 302, 29);
		contentPane.add(lblWelcomeLoginTo);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account? Register here:");
		lblDontHaveAn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDontHaveAn.setBounds(221, 296, 288, 22);
		contentPane.add(lblDontHaveAn);
		
		JLabel lblOrContinueAs = new JLabel("Or continue as a guest:");
		lblOrContinueAs.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblOrContinueAs.setBounds(221, 381, 288, 22);
		contentPane.add(lblOrContinueAs);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("G:\\Eclipseprojects\\Airline_booking\\res\\bg1 copy1.jpg"));
		label.setBounds(0, 0, 724, 477);
		contentPane.add(label);
	}
}
