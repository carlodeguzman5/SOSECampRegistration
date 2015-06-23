import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class RegDone extends JDialog {
	JFrame mom;
	private final JPanel contentPanel = new JPanel();

	
	class RestartListener implements ActionListener{
		JFrame frame;
		JDialog thisFrame;
		public RestartListener(JFrame f, JDialog f2){
			frame = f;
			thisFrame = f2;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			thisFrame.dispose();
			Form form = new Form();
			form.setVisible(true);
			form.toFront();
		}
	}
	
	
	public RegDone(String name, JFrame m) {
		setTitle("Welcome!");
		Toolkit.getDefaultToolkit().beep();
		setVisible(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
		mom = m;
		setBounds(100, 100, 450, 167);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)screen.getWidth()/2-this.getWidth()/2,(int)screen.getHeight()/2-this.getHeight()/2);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel welcome = new JLabel("Hello "+ name +"! Registration complete!");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Impact", Font.PLAIN, 20));
		welcome.setBounds(10, 26, 414, 51);
		contentPanel.add(welcome);
		
		JButton btnDismiss = new JButton("Dismiss");
		btnDismiss.addActionListener(new RestartListener(mom, this));
		btnDismiss.setBounds(170, 85, 105, 33);
		contentPanel.add(btnDismiss);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(getClass().getResource("Logos\\logoSmall.png")));
		lblNewLabel.setBounds(365, 26, 69, 80);
		contentPanel.add(lblNewLabel);
	}
}
