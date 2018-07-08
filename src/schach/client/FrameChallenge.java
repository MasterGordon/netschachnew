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
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameChallenge extends JFrame {

	private JPanel contentPane;
	private JTextField label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameChallenge frame = new FrameChallenge();
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
	public FrameChallenge() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FrameMainClient.class.getResource("/resources/chess-icon.png")));
		setTitle("Network Schach - Challenge");
		setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 133);
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

		JButton lblRegister = new JButton("Challenge");
		lblRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SchachClient.instance.send(Packet.create("challenge").addData("who", label.getText()).save());
				SchachClient.instance.frameMainClient.setVisible(true);
				label.setText("");
				setVisible(false);
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(37, 39, 77));
		lblRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblRegister.setBounds(10, 54, 404, 37);
		contentPane.add(lblRegister);

		 label = new JTextField("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(37, 39, 77));
		label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		label.setBounds(217, 11, 197, 32);
		contentPane.add(label);
	}

}
