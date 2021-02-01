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
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import com.toedter.calendar.JDateChooser;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.Spring;

import com.toedter.calendar.JDateChooser;

public class passengerinfo extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField email;
	private JTextField phone;
	private JTextField add1;
	private JTextField add2;
	private JTextField add3;
	private JTextField cardno;
	private JTextField cvv;
	private JTextField holder;
	static String flightname;
	static String source;
	static String destination;
	static String date;
	static String fare;
	static String flightid;
	String additionalFare;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passengerinfo frame = new passengerinfo(flightid,flightname, source, destination,date,fare );
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
	public passengerinfo(String flightid,String flightname,String source,String destination,String date,String fare) {
		this.flightname=flightname;
		this.source=source;
		this.destination=destination;
		this.date=date;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(335, 130, 740, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY));
		panel.setBounds(0, 0, 724, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFrom = new JLabel(source);
		lblFrom.setBounds(86, 9, 79, 14);
		panel.add(lblFrom);
		
		JLabel lblTo = new JLabel(destination);
		lblTo.setBounds(215, 9, 116, 14);
		panel.add(lblTo);
		
		JLabel lblFlightName = new JLabel(flightname);
		lblFlightName.setBounds(86, 34, 61, 14);
		panel.add(lblFlightName);
		
		JLabel lblDate = new JLabel(date);
		lblDate.setBounds(215, 34, 129, 14);
		panel.add(lblDate);
		
		JLabel lblTo_1 = new JLabel("To");
		lblTo_1.setBounds(168, 8, 20, 14);
		panel.add(lblTo_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("G:\\Eclipseprojects\\Airline_booking\\res\\logo.jpg"));
		label.setBounds(5, 5, 65, 50);
		panel.add(label);
		
		JLabel lblOn = new JLabel("On");
		lblOn.setBounds(168, 34, 20, 14);
		panel.add(lblOn);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFirstName.setBounds(33, 116, 75, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLastName.setBounds(364, 116, 75, 14);
		contentPane.add(lblLastName);
		
		JLabel label_2 = new JLabel("Email:");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_2.setBounds(33, 141, 75, 14);
		contentPane.add(label_2);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhone.setBounds(364, 143, 75, 14);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address 1:");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAddress.setBounds(33, 229, 75, 14);
		contentPane.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address 2:");
		lblAddress_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAddress_1.setBounds(33, 254, 75, 14);
		contentPane.add(lblAddress_1);
		
		JLabel lblAddress_2 = new JLabel("Address 3:");
		lblAddress_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAddress_2.setBounds(33, 280, 75, 14);
		contentPane.add(lblAddress_2);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(122, 112, 162, 24);
		contentPane.add(fname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(452, 114, 162, 24);
		contentPane.add(lname);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(122, 139, 162, 24);
		contentPane.add(email);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(452, 141, 162, 24);
		contentPane.add(phone);
		
		add1 = new JTextField();
		add1.setColumns(10);
		add1.setBounds(122, 227, 162, 24);
		contentPane.add(add1);
		
		add2 = new JTextField();
		add2.setColumns(10);
		add2.setBounds(122, 252, 162, 24);
		contentPane.add(add2);
		
		add3 = new JTextField();
		add3.setColumns(10);
		add3.setBounds(122, 278, 162, 24);
		contentPane.add(add3);
		
		JLabel label_7 = new JLabel("Gender:");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_7.setBounds(33, 173, 75, 14);
		contentPane.add(label_7);
		
		JRadioButton male = new JRadioButton("Male");
		male.setActionCommand("M");
		male.setBounds(122, 170, 61, 23);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setActionCommand("F");
		female.setBounds(205, 170, 79, 23);
		contentPane.add(female);
	
	//Buttongroup
		ButtonGroup gender=new ButtonGroup();
		gender.add(male);
		gender.add(female);
		//String radio1=gender.getSelection().getActionCommand();
		
		JLabel label_8 = new JLabel("No. Seats:");
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_8.setBounds(364, 172, 75, 14);
		contentPane.add(label_8);
		
		JSpinner seats = new JSpinner();
		seats.setModel(new SpinnerNumberModel(1, 1,20, 1));
		seats.setBounds(452, 170, 42, 20);
		contentPane.add(seats);
		
		JLabel label_9 = new JLabel("Class:");
		label_9.setHorizontalAlignment(SwingConstants.TRAILING);
		label_9.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_9.setBounds(33, 201, 75, 14);
		contentPane.add(label_9);
		
		JRadioButton economy = new JRadioButton("Economy");
		economy.setActionCommand("Economy");
		economy.setBounds(122, 198, 81, 23);
		contentPane.add(economy);
		
		JRadioButton business = new JRadioButton("Business");
		business.setActionCommand("Business");
		business.setBounds(205, 196, 89, 23);
		contentPane.add(business);
		
		JLabel lblPayment_1 = new JLabel(additionalFare);
		lblPayment_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPayment_1.setBounds(177, 470, 107, 15);
		contentPane.add(lblPayment_1);
		
		//Buttongroup
		ButtonGroup tier=new ButtonGroup();
		tier.add(economy);
		tier.add(business);
		//String radio2=tier.getSelection().getActionCommand();
		economy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblPayment_1.setText(fare.toString());
				additionalFare=fare;
			}
		});
		
		business.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int fare2=Integer.parseInt(fare);
				fare2=fare2+1800;
				lblPayment_1.setText(Integer.toString(fare2));
				additionalFare=Integer.toString(fare2);
			}
		});
		
		JLabel lblCreditCardNo = new JLabel("Credit Card No:");
		lblCreditCardNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCreditCardNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCreditCardNo.setBounds(33, 353, 99, 14);
		contentPane.add(lblCreditCardNo);
		
		JLabel lblExpiryDate = new JLabel("Expiry date:");
		lblExpiryDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExpiryDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblExpiryDate.setBounds(31, 378, 99, 21);
		contentPane.add(lblExpiryDate);
		
		JLabel lblCardHolder = new JLabel("Card holder:");
		lblCardHolder.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCardHolder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCardHolder.setBounds(40, 410, 90, 19);
		contentPane.add(lblCardHolder);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCvv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCvv.setBounds(55, 442, 75, 14);
		contentPane.add(lblCvv);
		
		cardno = new JTextField();
		cardno.setColumns(10);
		cardno.setBounds(138, 349, 212, 24);
		contentPane.add(cardno);
		
		cvv = new JTextField();
		cvv.setColumns(10);
		cvv.setBounds(140, 438, 162, 24);
		contentPane.add(cvv);
		
		holder = new JTextField();
		holder.setColumns(10);
		holder.setBounds(138, 409, 162, 24);
		contentPane.add(holder);
		
		JLabel lblIco = new JLabel("Ico");
		lblIco.setBounds(364, 347, 42, 32);
		contentPane.add(lblIco);
		
		JLabel label_10 = new JLabel("Ico");
		label_10.setBounds(414, 347, 42, 32);
		contentPane.add(label_10);
		
		JLabel lblPassengerInfo = new JLabel("Passenger Info");
		lblPassengerInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassengerInfo.setBounds(10, 73, 125, 19);
		contentPane.add(lblPassengerInfo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 95, 682, 5);
		contentPane.add(separator);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPayment.setBounds(10, 313, 102, 19);
		contentPane.add(lblPayment);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 335, 682, 5);
		contentPane.add(separator_1);
		
		JDateChooser dob = new JDateChooser();
		dob.setBounds(452, 195, 162, 26);
		dob.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dob);

		JDateChooser expiry = new JDateChooser();
		expiry.setBounds(140, 378, 160, 23);
		expiry.setDateFormatString("yyyy-MM-dd");
		contentPane.add(expiry);
		
		JButton btnSubmit = new JButton("Confirm");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					seats.commitEdit();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","paul","admin");
					pnrGenerator pnr=new pnrGenerator();
					String pnr1=pnr.generateRandomString().toString();
					
					String sql1="insert into passenger (fname,lname,email,phone,gender,seats,tier,dob,address1,address2,address3,cardno,expiry,holder,cvv,paid,flightid,pnr) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement stmt1=con.prepareStatement(sql1);
			
					stmt1.setString(1,fname.getText());
					stmt1.setString(2,lname.getText());
					stmt1.setString(3,email.getText());
					stmt1.setString(4,phone.getText());
					stmt1.setString(5,gender.getSelection().getActionCommand());
					stmt1.setString(6,seats.getValue().toString());
					stmt1.setString(7,tier.getSelection().getActionCommand());
					stmt1.setString(8,((JTextField)dob.getDateEditor().getUiComponent()).getText());
					stmt1.setString(9,add1.getText());
					stmt1.setString(10,add2.getText());
					stmt1.setString(11,add3.getText());
					stmt1.setString(12,cardno.getText());
					stmt1.setString(13,((JTextField)expiry.getDateEditor().getUiComponent()).getText());
					stmt1.setString(14,holder.getText());
					stmt1.setString(15,cvv.getText());
					stmt1.setString(16,additionalFare);
					stmt1.setString(17,flightid);
					stmt1.setString(18,pnr1);
					
					String sql2="update flight set seats=seats-'"+seats.getValue()+"' where flightname='"+flightname+"'";
					PreparedStatement stmt2=con.prepareStatement(sql2);
					stmt2.execute();

					stmt1.execute();
					JOptionPane.showMessageDialog(null,"Payment Complete\n\nTotal Amount: "+additionalFare+" INR\n"+ "Flight: "+flightname+"\nSeat(s): "+seats.getValue()+"\nYour PNR is: "+pnr1+"\nBooking Status: Confirmed");
					
					con.close();
					
					booking frame = new booking();
					frame.setVisible(true);
					dispose();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnSubmit.setBounds(211, 497, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fname.setText(null);
				lname.setText(null);
				email.setText(null);
				phone.setText(null);
				tier.clearSelection();
				gender.clearSelection();
				seats.setValue(1);
				dob.setDate(null);
				add1.setText(null);
				add2.setText(null);
				add3.setText(null);
				cardno.setText(null);
				expiry.setDate(null);
				holder.setText(null);
				cvv.setText(null);
				
			}
		});
		btnClear.setBounds(323, 497, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				close();
				booking frame = new booking();
				frame.setVisible(true);
			}
		});
		btnCancel.setBounds(435, 496, 89, 23);
		contentPane.add(btnCancel);
		
		
		
		JLabel lblDob = new JLabel("D.O.B:");
		lblDob.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDob.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDob.setBounds(364, 202, 75, 14);
		contentPane.add(lblDob);
		
		JLabel lblTotalFare = new JLabel("Total Fare = Rs.");
		lblTotalFare.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotalFare.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTotalFare.setBounds(65, 470, 107, 14);
		contentPane.add(lblTotalFare);
		
		
	}
}
