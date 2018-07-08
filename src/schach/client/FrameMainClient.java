package schach.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

public class FrameMainClient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMainClient frame = new FrameMainClient();
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
	public FrameMainClient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMainClient.class.getResource("/resources/chess-icon.png")));
		setTitle("Network Schach");
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
		setBounds(100, 100, 948, 586);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("User");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mnNewMenu.add(mntmRegister);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mnNewMenu.add(mntmLogin);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnNewMenu.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		JMenu mnPlay = new JMenu("Play");
		menuBar.add(mnPlay);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mnPlay.add(mntmSearch);
		
		JMenuItem mntmChallange = new JMenuItem("Challange");
		mnPlay.add(mntmChallange);
		
		JMenu mnNewMenu_1 = new JMenu("Load Replay");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnElo = new JMenu("Elo: 1000");
		menuBar.add(mnElo);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#AAABB8"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CanvasBrett canvas = new CanvasBrett("rnbqkbnrpppppppp00000000000000000000000000000000PPPPPPPPRNBQKBNR");
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
}
