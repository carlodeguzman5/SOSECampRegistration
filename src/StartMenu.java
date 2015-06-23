import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.sql.SQLException;


public class StartMenu {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public StartMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 627, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screen.width/2-frame.getWidth()/2, screen.height/2-frame.getHeight()/2);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(getClass().getResource("Logos\\small.png")));
		lblNewLabel.setBounds(33, 11, 111, 82);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("Logos\\title.png")));
		lblNewLabel_1.setBounds(134, 23, 452, 70);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 104, 601, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblRegtitle = new JLabel("RecWeek System");
		lblRegtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegtitle.setFont(new Font("Agency FB", Font.PLAIN, 34));
		lblRegtitle.setBounds(87, 130, 499, 47);
		frame.getContentPane().add(lblRegtitle);
		
		final JButton btnStartSystem = new JButton("Start System");
		btnStartSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Background bg = new Background();
				bg.setVisible(true);
				WelcomeScreen ws = new WelcomeScreen();
				frame.dispose();
//				try {
//					SQLHandler sql = SQLHandler.getInstance();
//				} catch (FileNotFoundException | SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		frame.getRootPane().setDefaultButton(btnStartSystem);
		
		btnStartSystem.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnStartSystem.setBounds(120, 205, 130, 34);
		frame.getContentPane().add(btnStartSystem);
		
		JButton btnNewButton = new JButton("Help");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help h = new Help(frame);
				frame.setEnabled(false);
				
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnNewButton.setBounds(370, 205, 130, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon(getClass().getResource("Logos\\recweek.png")));
		label.setBounds(74, 103, 137, 101);
		frame.getContentPane().add(label);
		
		frame.setVisible(true);
	}
}
