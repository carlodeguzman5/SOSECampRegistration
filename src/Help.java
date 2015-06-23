import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Help extends JFrame {

	private JPanel contentPane;
	JFrame thisFrame, parent;

	public Help(JFrame f) {
		thisFrame = this;
		parent = f;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		setLocation((int)screen.getWidth()/2-getWidth()/2,(int)screen.getHeight()/2-getHeight()/2);
		
		JLabel lblMsg = new JLabel("For question and problems, please contact");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(10, 34, 279, 44);
		contentPane.add(lblMsg);
		
		JLabel lblCarloDeGuzman = new JLabel("Carlo De Guzman 09177900072");
		lblCarloDeGuzman.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarloDeGuzman.setBounds(10, 73, 279, 44);
		contentPane.add(lblCarloDeGuzman);
		
		JButton btnDismiss = new JButton("Dismiss");
		btnDismiss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thisFrame.dispose();
				parent.setEnabled(true);
			}
		});
		btnDismiss.setBounds(105, 142, 89, 23);
		contentPane.add(btnDismiss);
		setVisible(true);
	}
}
