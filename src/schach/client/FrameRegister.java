package schach.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class FrameRegister extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRegister frame = new FrameRegister();
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
	public FrameRegister() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMainClient.class.getResource("/resources/chess-icon.png")));
		setTitle("Network Schach - Register");
		setResizable(false);
		try 
	    {
	      UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 217);
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
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password:");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepeatPassword.setForeground(new Color(37, 39, 77));
		lblRepeatPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblRepeatPassword.setBounds(10, 97, 197, 32);
		contentPane.add(lblRepeatPassword);
		
		JButton lblRegister = new JButton("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(37, 39, 77));
		lblRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblRegister.setBounds(10, 140, 404, 37);
		contentPane.add(lblRegister);
		
		JTextField label = new JTextField("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(37, 39, 77));
		label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		label.setBounds(217, 11, 197, 32);
		contentPane.add(label);
		
		JPasswordField label_1 = new JPasswordField("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(37, 39, 77));
		label_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		label_1.setBounds(217, 54, 197, 32);
		contentPane.add(label_1);
		
		JPasswordField label_3 = new JPasswordField("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(37, 39, 77));
		label_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		label_3.setBounds(217, 97, 197, 32);
		contentPane.add(label_3);
	}

}
