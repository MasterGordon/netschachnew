package schach.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameConnect extends JFrame {

	private JPanel contentPane;
	private JTextField serverIP;
	private JTextField port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConnect frame = new FrameConnect();
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
	public FrameConnect() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMainClient.class.getResource("/resources/chess-icon.png")));
		setTitle("Network Schach - Connect");
		setResizable(false);
		try 
	    {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("IP Adress:");
		lblUsername.setBounds(10, 11, 121, 32);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(37, 39, 77));
		lblUsername.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Port:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(37, 39, 77));
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblPassword.setBounds(10, 54, 121, 32);
		contentPane.add(lblPassword);
		
		JButton lblRegister = new JButton("Login");
		lblRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SchachClient(serverIP.getText(), Integer.parseInt(port.getText()));
				dispose();
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(37, 39, 77));
		lblRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblRegister.setBounds(10, 97, 329, 37);
		contentPane.add(lblRegister);
		
		serverIP = new JTextField("127.0.0.1");
		serverIP.setHorizontalAlignment(SwingConstants.CENTER);
		serverIP.setForeground(new Color(37, 39, 77));
		serverIP.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		serverIP.setBounds(141, 11, 198, 32);
		contentPane.add(serverIP);
		
		port = new JTextField("1010");
		port.setHorizontalAlignment(SwingConstants.CENTER);
		port.setForeground(new Color(37, 39, 77));
		port.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		port.setBounds(141, 54, 198, 32);
		contentPane.add(port);
	}

}
