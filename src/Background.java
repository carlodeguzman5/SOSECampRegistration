import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class Background extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Background() {
		setAutoRequestFocus(false);
		setEnabled(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(false);
		//lblNewLabel.setIcon(new ImageIcon(getClass().getResource("Logos\\Classic 01.png")));
		lblNewLabel.setBounds(39, 0, 743, 706);
		contentPane.add(lblNewLabel);
		
	}

}
