import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ticket extends JFrame {

	private JPanel contentPane;
	static String checkpnr;
	static String fname;
	static String lname;
	static String flight;
	static String seats;
	static String tier;
	static String source;
	static String destination;
	static String date;
	static String arrival;
	static String departure;
	static String phone;
	static String paid;
	static String email;
	static String address1;
	static String address2;
	static String address3;
	static int baseFare;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticket frame = new ticket(checkpnr);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ticket(String checkpnr) {
		this.checkpnr=checkpnr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(335, 130, 740, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","paul","admin");
			Statement stmt=con.createStatement();
			String sql="Select fname,lname,p.seats,tier,flightname,source,destination,date,arrival,departure,phone,email,paid,address1,address2,address3 from passenger p,flight f where p.flightid=f.flightid and pnr='"+checkpnr+"'";
			ResultSet rs=stmt.executeQuery(sql);
				while (rs.next()) 
				{
					fname = rs.getString("fname");
					lname = rs.getString("lname");
					flight = rs.getString("flightname");
					seats = rs.getString("seats");
					tier = rs.getString("tier");
					source = rs.getString("source");
					destination = rs.getString("destination");
					date = rs.getString("date");
					arrival = rs.getString("arrival");
					departure = rs.getString("departure");
					phone = rs.getString("phone");
					paid = rs.getString("paid");
					email = rs.getString("email");
					address1 = rs.getString("address1");
					address2 = rs.getString("address2");
					address3 = rs.getString("address3");
				}

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 62, 704, 2);
		contentPane.add(separator);
		
		JLabel lblTraveller = new JLabel("Traveller");
		lblTraveller.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTraveller.setBounds(10, 75, 71, 14);
		contentPane.add(lblTraveller);
		
		JLabel lblName = new JLabel(fname+" "+lname);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(10, 94, 195, 21);
		contentPane.add(lblName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 704, 57);
		contentPane.add(scrollPane);
		
		table = new JTable(){
			@Override
			public boolean isCellEditable(int rowIndex,int colIndex) {
				return false;
			}
		};
		table.setBackground(SystemColor.menu);
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		table.setBorder(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{date, departure, flight, source, destination, seats, tier, arrival},
			},
			new String[] {
				"Date", "Dep Time", "Flight", "From", "To", "No. of Seats", "Class", "Arrival Time"
			}
		));
		
		JLabel lblBookingReference = new JLabel("Booking Reference");
		lblBookingReference.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblBookingReference.setBounds(10, 206, 124, 21);
		contentPane.add(lblBookingReference);
		
		JLabel lblBookingStatus = new JLabel("Booking Status");
		lblBookingStatus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblBookingStatus.setBounds(185, 206, 106, 21);
		contentPane.add(lblBookingStatus);
		
		JLabel lblPaymentStatus = new JLabel("Payment Status");
		lblPaymentStatus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPaymentStatus.setBounds(337, 206, 106, 21);
		contentPane.add(lblPaymentStatus);
		
		JLabel lblPnr = new JLabel(checkpnr);
		lblPnr.setBounds(10, 231, 89, 14);
		contentPane.add(lblPnr);
		
		JLabel lblConfirmed = new JLabel("Confirmed");
		lblConfirmed.setBounds(186, 231, 89, 14);
		contentPane.add(lblConfirmed);
		
		JLabel lblComplete = new JLabel("Complete");
		lblComplete.setBounds(337, 231, 89, 14);
		contentPane.add(lblComplete);
		
		JLabel lblPriceSummary = new JLabel("Price Summary");
		lblPriceSummary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceSummary.setBounds(10, 273, 106, 22);
		contentPane.add(lblPriceSummary);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 298, 349, 2);
		contentPane.add(separator_1);
		
		JLabel lblAirfareCharges = new JLabel("Airfare Charges");
		lblAirfareCharges.setBounds(10, 311, 96, 14);
		contentPane.add(lblAirfareCharges);
		
		JLabel lblPassengerServiceFee = new JLabel("Passenger Service Fee");
		lblPassengerServiceFee.setBounds(10, 336, 150, 14);
		contentPane.add(lblPassengerServiceFee);
		
		JLabel lblUserDevelopmentFee = new JLabel("User Development Fee");
		lblUserDevelopmentFee.setBounds(10, 361, 150, 14);
		contentPane.add(lblUserDevelopmentFee);
		
		JLabel lblConvenienceFee = new JLabel("Convenience Fee");
		lblConvenienceFee.setBounds(10, 386, 96, 14);
		contentPane.add(lblConvenienceFee);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalPrice.setBounds(10, 411, 96, 14);
		contentPane.add(lblTotalPrice);
		
		JLabel lblInr = new JLabel("153.00 INR");
		lblInr.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInr.setBounds(294, 336, 65, 14);
		contentPane.add(lblInr);
		
		JLabel lblInr_1 = new JLabel("361.00 INR");
		lblInr_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInr_1.setBounds(294, 361, 65, 14);
		contentPane.add(lblInr_1);
		
		JLabel lblInr_2 = new JLabel("200.00 INR");
		lblInr_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInr_2.setBounds(294, 386, 65, 14);
		contentPane.add(lblInr_2);
		
		JLabel lblTotal = new JLabel(paid +" INR");
		lblTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotal.setBounds(294, 412, 65, 14);
		contentPane.add(lblTotal);
		
		baseFare=Integer.parseInt(paid);
		baseFare=baseFare-714;
		JLabel lblBasefare = new JLabel(Integer.toString(baseFare)+" INR");
		lblBasefare.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBasefare.setBounds(294, 311, 65, 14);
		contentPane.add(lblBasefare);
		
		JLabel lblPassengerContactDetails = new JLabel("Passenger Contact Details");
		lblPassengerContactDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassengerContactDetails.setBounds(526, 206, 164, 22);
		contentPane.add(lblPassengerContactDetails);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(526, 231, 158, 2);
		contentPane.add(separator_2);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblMobileNumber.setBounds(526, 244, 96, 14);
		contentPane.add(lblMobileNumber);
		
		JLabel lblPhonedynamic = new JLabel(phone);
		lblPhonedynamic.setBounds(526, 262, 132, 14);
		contentPane.add(lblPhonedynamic);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmail.setBounds(526, 294, 96, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEmaildynamic = new JLabel(email);
		lblEmaildynamic.setBounds(526, 310, 188, 20);
		contentPane.add(lblEmaildynamic);
		
		JLabel lblAirlineBooking = new JLabel("Airline Booking");
		lblAirlineBooking.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lblAirlineBooking.setBounds(10, 11, 180, 27);
		contentPane.add(lblAirlineBooking);
		
		JLabel lblEticket = new JLabel("E-Ticket");
		lblEticket.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lblEticket.setBounds(10, 37, 150, 21);
		contentPane.add(lblEticket);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAddress.setBounds(526, 345, 96, 14);
		contentPane.add(lblAddress);
		
		JLabel address1dynamic = new JLabel(address1);
		address1dynamic.setBounds(526, 364, 188, 20);
		contentPane.add(address1dynamic);
		
		JLabel address2dynamic = new JLabel(address2);
		address2dynamic.setBounds(526, 385, 188, 20);
		contentPane.add(address2dynamic);
		
		JLabel addressdynamic = new JLabel(address3);
		addressdynamic.setBounds(526, 406, 188, 20);
		contentPane.add(addressdynamic);
		
		JButton btnOk = new JButton("Ok");
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(331, 446, 53, 23);
		contentPane.add(btnOk);
	}
}
