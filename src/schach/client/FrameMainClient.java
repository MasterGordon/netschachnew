package schach.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import schach.Packet;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameMainClient extends JFrame {

	private JPanel contentPane;
	SchachClient client;
	private CanvasBrett canvas;
	public JMenuItem mntmRegister;
	public JMenuItem mntmLogin;
	public JMenuItem mntmLogout;
	public JMenu mnPlay;
	public JMenu mnElo;
	JMenu username;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public FrameMainClient(SchachClient client) {
		this.client = client;
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMainClient.class.getResource("/resources/chess-icon.png")));
		setTitle("Network Schach");
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
		setBounds(100, 100, 948, 586);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		menuBar.setBackground(Color.decode("#2E9CCA"));
		setJMenuBar(menuBar);
		
		username = new JMenu("Login / Register");
		username.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		menuBar.add(username);
		
		mntmRegister = new JMenuItem("Register");
		mntmRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.frameRegister.setVisible(true);
				setVisible(false);
			}
		});
		username.add(mntmRegister);
		
		mntmLogin = new JMenuItem("Login");
		mntmLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.frameLogin.setVisible(true);
				setVisible(false);
			}
		});
		username.add(mntmLogin);
		
		mntmLogout = new JMenuItem("Logout");
		mntmLogout.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.send(Packet.create("logout").save());
				mnPlay.setVisible(false);
				mntmLogout.setVisible(false);
				mnElo.setVisible(false);
				mntmRegister.setVisible(true);
				mntmLogin.setVisible(true);
				username.setText("Login / Register");
				client.isLoggedIn = false;
			}
		});
		username.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		username.add(mntmExit);
		
		mnPlay = new JMenu("Play");
		mnPlay.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		menuBar.add(mnPlay);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		mnPlay.add(mntmSearch);
		
		JMenuItem mntmChallange = new JMenuItem("Challange");
		mntmChallange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.frameChallenge.setVisible(true);
				setVisible(false);
			}
		});
		mntmChallange.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		mnPlay.add(mntmChallange);
		
		JMenu mnNewMenu_1 = new JMenu("Load Replay");
		mnNewMenu_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_1);
		
		mnElo = new JMenu("Elo: 1000");
		mnElo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		menuBar.add(mnElo);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#AAABB8"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		canvas = new CanvasBrett("rnbqkbnrpppppppp00000000000000000000000000000000PPPPPPPPRNBQKBNR");
		canvas.setBounds(10, 10, 512, 512);
		contentPane.add(canvas);
		
		JLabel lblNewLabel = new JLabel("Your Opponent");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(528, 123, 414, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblYou = new JLabel("You");
		lblYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblYou.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblYou.setBounds(528, 381, 414, 28);
		contentPane.add(lblYou);
		
		JLabel lblTimeLeft = new JLabel("Time Left: 1:00");
		lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeLeft.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblTimeLeft.setBounds(528, 233, 414, 28);
		contentPane.add(lblTimeLeft);
		
		JLabel lblTime = new JLabel("Time: 1:00");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblTime.setBounds(528, 272, 414, 28);
		contentPane.add(lblTime);
		
		lblNewLabel.setForeground(Color.decode("#25274D"));
		lblYou.setForeground(Color.decode("#25274D"));
		lblTimeLeft.setForeground(Color.decode("#25274D"));
		lblTime.setForeground(Color.decode("#25274D"));
	}
	
	public void updateCanvas(String s) {
		
	}
}
