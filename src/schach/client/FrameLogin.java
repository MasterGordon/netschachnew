package schach.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import schach.Packet;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMainClient.class.getResource("/resources/chess-icon.png")));
		setTitle("Network Schach - Login");
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
		setBounds(100, 100, 427, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 197, 32);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(37, 39, 77));
		lblUsername.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(37, 39, 77));
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblPassword.setBounds(10, 54, 197, 32);
		contentPane.add(lblPassword);
		
		JButton lblRegister = new JButton("Login");
		lblRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SchachClient.instance.username = username.getText();
				SchachClient.instance.send(Packet.create("login").addData("username", username.getText()).addData("password", password.getText()).save());
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(37, 39, 77));
		lblRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblRegister.setBounds(10, 97, 404, 37);
		contentPane.add(lblRegister);
		
		username = new JTextField("");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setForeground(new Color(37, 39, 77));
		username.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		username.setBounds(217, 11, 197, 32);
		contentPane.add(username);
		
		password = new JPasswordField("");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setForeground(new Color(37, 39, 77));
		password.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		password.setBounds(217, 54, 197, 32);
		contentPane.add(password);
	}

}
