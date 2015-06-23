import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class Error extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Error() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 41, 414, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnDismiss = new JButton("Dismiss");
		btnDismiss.setBounds(166, 89, 89, 23);
		contentPane.add(btnDismiss);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Error.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		lblNewLabel_1.setBounds(20, 11, 35, 37);
		contentPane.add(lblNewLabel_1);
	}

}
