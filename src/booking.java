
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Box;

public class booking extends JFrame {

	private JPanel contentPane;
	private JPanel bookpnl;
	private JPanel schedulepnl;
	private JPanel ticketpnl;
	private JLayeredPane layeredPane;
	private JTable table;
	private JTable table_1;
	private JTextField enterpnr;
	String checkpnr;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void switchpanel(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public void close()
	{
		
		WindowEvent winclose=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
		
	}
	

	/**
	 * Create the frame.
	 */
	public booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(335, 130, 740, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 29, 724, 448);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_564855164067273");
		panel.setLayout(null);
		
		bookpnl = new JPanel();
		layeredPane.add(bookpnl, "name_564078073992470");
		bookpnl.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 704, 229);
		bookpnl.add(scrollPane);
		
		table = new JTable() {
			@Override
			public boolean isCellEditable(int rowIndex,int colIndex) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		table.setToolTipText("Book Now");
	
		ListSelectionModel model=table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener()
		{
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!model.isSelectionEmpty())
				{
					int index=table.getSelectedRow();
					int no_ofseats=(int) table.getValueAt(index, 7);
					
					if(no_ofseats!=0) {
					String flightid=table.getValueAt(index,0).toString();
					String flightname=table.getValueAt(index,1).toString();
					String source=table.getValueAt(index,2).toString();
					String destination=table.getValueAt(index,3).toString();
					String date=table.getValueAt(index, 6).toString();
					String fare=table.getValueAt(index, 8).toString();
					passengerinfo frame = new passengerinfo(flightid,flightname, source, destination,date,fare);
					frame.setVisible(true);
					dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No seats available.");
					}
				}
			}
		});
		
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFrom.setBounds(124, 35, 40, 14);
		bookpnl.add(lblFrom);
		
		JComboBox combofrom = new JComboBox();
		combofrom.setModel(new DefaultComboBoxModel(new String[] {"Bangalore", "Chennai", "Goa", "Mumbai", "Guwahati"}));
		combofrom.setBounds(162, 32, 153, 22);
		bookpnl.add(combofrom);
		
		JComboBox comboto = new JComboBox();
		comboto.setModel(new DefaultComboBoxModel(new String[] {"Bangalore", "Chennai", "Goa", "Mumbai", "Guwahati"}));
		comboto.setBounds(416, 35, 153, 22);
		bookpnl.add(comboto);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTo.setBounds(378, 38, 40, 14);
		bookpnl.add(lblTo);
		
		JButton btnSearchFlights = new JButton("Search Flights");
		btnSearchFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","paul","admin");
					String query="select * from flight where source='"+combofrom.getSelectedItem().toString()+"'and destination='"+comboto.getSelectedItem().toString()+"'";
					PreparedStatement stmt=con.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnSearchFlights.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearchFlights.setBounds(287, 83, 120, 23);
		bookpnl.add(btnSearchFlights);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanel(panel);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(287, 117, 120, 23);
		bookpnl.add(btnCancel);
		
		schedulepnl = new JPanel();
		layeredPane.add(schedulepnl, "name_564110509685325");
		schedulepnl.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 62, 704, 375);
		schedulepnl.add(scrollPane_1);
		
		table_1 = new JTable() {
			@Override
			public boolean isCellEditable(int rowIndex,int colIndex) {
				return false;
			}
		};
		table_1.setRowSelectionAllowed(false);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnShowFlightSchedule = new JButton("Show Flight Schedule");
		btnShowFlightSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","paul","admin");
					String querys="select * from flight";
					PreparedStatement stmt0=con.prepareStatement(querys);
					ResultSet rs1=stmt0.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
					con.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnShowFlightSchedule.setBounds(239, 22, 197, 23);
		schedulepnl.add(btnShowFlightSchedule);
		
		ticketpnl = new JPanel();
		layeredPane.add(ticketpnl, "name_564113347234263");
		ticketpnl.setLayout(null);
		
		enterpnr = new JTextField();
		enterpnr.setBounds(285, 192, 121, 20);
		ticketpnl.add(enterpnr);
		enterpnr.setColumns(10);
		
		
		JLabel lblEnterYourPnr = new JLabel("Enter your PNR");
		lblEnterYourPnr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterYourPnr.setBounds(293, 159, 105, 20);
		ticketpnl.add(lblEnterYourPnr);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					checkpnr=enterpnr.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","paul","admin");
					Statement stmt=con.createStatement();
					String sql="Select pnr from passenger where pnr='"+checkpnr+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
					try
					{
					    
					    ticket frame = new ticket(checkpnr);
						frame.setVisible(true);
						con.close();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
					}
					else
						JOptionPane.showMessageDialog(null, "PNR does not Exists");
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnShow.setBounds(301, 234, 89, 23);
		ticketpnl.add(btnShow);
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 724, 29);
		contentPane.add(toolBar);
		
		JButton btnBookFlight = new JButton("Book Flight");
		btnBookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanel(bookpnl);
			}
			
		});
		toolBar.add(btnBookFlight);
		
		JButton btnFlightSchedule = new JButton("Flight Schedule");
		btnFlightSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanel(schedulepnl);
				
			}
		});
		toolBar.add(btnFlightSchedule);
		
		JButton btnViewTicket = new JButton("View Ticket");
		btnViewTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanel(ticketpnl);
			
			}
		});
		toolBar.add(btnViewTicket);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		toolBar.add(btnExit);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home frame = new home();
				frame.setVisible(true);
				dispose();
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_3);
		
		Component horizontalStrut_22 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_22);
		
		Component horizontalStrut_21 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_21);
		
		Component horizontalStrut_20 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_20);
		
		Component horizontalStrut_19 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_19);
		
		Component horizontalStrut_18 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_18);
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_17);
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_16);
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_15);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_14);
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_13);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_12);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_11);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_10);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_9);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_7);
		toolBar.add(btnLogout);
	}
}
