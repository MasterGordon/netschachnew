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

public class FrameChallengeAccept extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChallengeAccept frame = new FrameChallengeAccept();
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
	public FrameChallengeAccept() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMainClient.class.getResource("/resources/chess-icon.png")));
		setTitle("Network Schach - Challenge");
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
		setBounds(100, 100, 427, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username challenged you!");
		lblUsername.setBounds(10, 11, 404, 32);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(37, 39, 77));
		lblUsername.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		contentPane.add(lblUsername);
		
		JButton lblRegister = new JButton("Accept");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(37, 39, 77));
		lblRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblRegister.setBounds(10, 54, 196, 37);
		contentPane.add(lblRegister);
		
		JButton btnDecline = new JButton("Decline");
		btnDecline.setHorizontalAlignment(SwingConstants.CENTER);
		btnDecline.setForeground(new Color(37, 39, 77));
		btnDecline.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		btnDecline.setBounds(218, 54, 196, 37);
		contentPane.add(btnDecline);
	}
}
