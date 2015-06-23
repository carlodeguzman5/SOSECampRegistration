import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.io.FileNotFoundException;

import javax.swing.SwingConstants;


public class WelcomeScreen {
	private JFrame frmRecweekSystem;
	public WelcomeScreen() {
		initialize();
	}
	
	class OpenForm implements ActionListener{
		JFrame frame;
		public OpenForm(JFrame f){
			frame = f;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Form form = new Form();
			form.setVisible(true);
			
			frame.dispose();
			
		}	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecweekSystem = new JFrame();
		frmRecweekSystem.setResizable(false);
		frmRecweekSystem.setType(Type.UTILITY);
		frmRecweekSystem.setTitle("RecWeek 2014 System");
		frmRecweekSystem.setBounds(100, 100, 600, 253);
		frmRecweekSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecweekSystem.getContentPane().setLayout(null);
		frmRecweekSystem.setAlwaysOnTop(true);;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmRecweekSystem.setLocation((int)screen.getWidth()/2-frmRecweekSystem.getWidth()/2,(int)screen.getHeight()/2-frmRecweekSystem.getHeight()/2);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		//lblTitle.setIcon(new ImageIcon(getClass().getResource("Logos\\title.png")));
		lblTitle.setBounds(10, 35, 574, 68);
		frmRecweekSystem.getContentPane().add(lblTitle);
		
		JLabel lblSub = new JLabel("");
		//lblSub.setIcon(new ImageIcon(getClass().getResource("Logos\\sub.png")));
		lblSub.setBounds(195, 107, 321, 34);
		frmRecweekSystem.getContentPane().add(lblSub);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 114, 574, 2);
		frmRecweekSystem.getContentPane().add(separator);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Impact", Font.PLAIN, 18));
		Dimension screenSize = frmRecweekSystem.getSize();
		btnRegister.setBounds(205, 141, 178,43 );
		//btnRegister.setLocation((int)screenSize.getWidth()/2-btnRegister.getWidth()/2, 209);
		frmRecweekSystem.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new OpenForm(frmRecweekSystem));
		
		frmRecweekSystem.setVisible(true);
		
		frmRecweekSystem.getRootPane().setDefaultButton(btnRegister);
		
	}
}
