import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField idnum;
	private JTextField firstname;
	private JTextField middlename;
	private JTextField lastname;
	private JTextField nickname;
	private JComboBox month, day, year, courses;
	private JFrame thisFrame;
	boolean fine = true;

	/**
	 * Create the frame.
	 */

	public Form() {
		thisFrame = this;
		setAlwaysOnTop(true);
		class BackListener implements ActionListener {
			JFrame one;

			public BackListener(JFrame a) {
				one = a;
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WelcomeScreen ws = new WelcomeScreen();
				one.dispose();
			}
		}

		class KeyLimit implements KeyListener {
			int limit;
			JTextField field;

			public KeyLimit(int l, JTextField f) {
				limit = l;
				field = f;
			}

			public void keyTyped(KeyEvent e) {
				String text = field.getText();
				int length = text.length();
				if (length == limit) {
					e.consume();
				} else if (length > limit) {
					System.err
							.println("Character length is greater then specified in the database.");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		}

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation((int) screen.getWidth() / 2 - getWidth() / 2,
				(int) screen.getHeight() / 2 - getHeight() / 2);

		JLabel lblTitle = new JLabel("Please accomplish the form!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Impact", Font.PLAIN, 20));
		lblTitle.setBounds(10, 25, 395, 50);
		contentPane.add(lblTitle);

		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdNumber.setBounds(57, 109, 126, 14);
		contentPane.add(lblIdNumber);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(57, 171, 126, 14);
		contentPane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setBounds(392, 171, 126, 14);
		contentPane.add(lblLastName);

		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiddleName.setBounds(223, 171, 126, 14);
		contentPane.add(lblMiddleName);

		idnum = new JTextField();
		idnum.setHorizontalAlignment(SwingConstants.CENTER);
		idnum.setBounds(57, 140, 126, 20);
		contentPane.add(idnum);
		idnum.setColumns(10);
		idnum.addKeyListener(new KeyLimit(6, idnum));

		firstname = new JTextField();
		firstname.setHorizontalAlignment(SwingConstants.CENTER);
		firstname.setBounds(57, 196, 126, 20);
		contentPane.add(firstname);
		firstname.setColumns(10);

		middlename = new JTextField();
		middlename.setHorizontalAlignment(SwingConstants.CENTER);
		middlename.setBounds(223, 196, 126, 20);
		contentPane.add(middlename);
		middlename.setColumns(10);

		lastname = new JTextField();
		lastname.setHorizontalAlignment(SwingConstants.CENTER);
		lastname.setBounds(392, 196, 126, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);

		JLabel courselbl = new JLabel("Course");
		courselbl.setHorizontalAlignment(SwingConstants.CENTER);
		courselbl.setBounds(392, 109, 126, 14);
		contentPane.add(courselbl);

		JLabel lblNewLabel_2 = new JLabel("Birthdate");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(226, 225, 126, 14);
		contentPane.add(lblNewLabel_2);

		String[] months = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		month = new JComboBox(months);
		month.setModel(new DefaultComboBoxModel(new String[] { "Month",
				"January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" }));
		month.setBounds(57, 249, 126, 20);
		contentPane.add(month);

		day = new JComboBox();
		day.setModel(new DefaultComboBoxModel(new String[] { "Day", "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		day.setBounds(223, 249, 126, 20);
		contentPane.add(day);

		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] { "Year", "1985",
				"1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993",
				"1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001",
				"2002", "2003", "2004" }));
		year.setBounds(392, 249, 126, 20);
		contentPane.add(year);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 318, 539, 2);
		contentPane.add(separator);

		final JButton submit = new JButton("Submit");
		thisFrame.getRootPane().setDefaultButton(submit);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isComplete()) {
					try {
						SimpleDateFormat ft = new SimpleDateFormat(
								"MM'-'dd  hh:mm:ss a");
						Date date = new Date();
						File output = new File("Excel Sheets//Members.csv");
						FileWriter writer = new FileWriter(output, true);

						writer.write(idnum.getText() + "," + nickname.getText()
								+ "," + firstname.getText() + ","
								+ middlename.getText() + ","
								+ lastname.getText() + ","
								+ year.getSelectedItem() + "-"
								+ month.getSelectedIndex() + "-"
								+ day.getSelectedItem() + ","
								+ courses.getSelectedItem() + ","
								+ ft.format(date) + ",,\n");
						writer.flush();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();

						JPanel content;

						Toolkit.getDefaultToolkit().beep();
						final JFrame error = new JFrame();
						error.setTitle("Seems like something went wrong.");
						error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						error.setBounds(460, 250, 450, 230);
						content = new JPanel();
						content.setBorder(new EmptyBorder(5, 5, 5, 5));
						error.setContentPane(content);
						error.setAlwaysOnTop(true);
						content.setLayout(null);
						error.setVisible(true);
						error.setResizable(false);
						JLabel lblNewLabel = new JLabel(
								"Oops! Something went wrong!");
						JLabel lblNewLabel1 = new JLabel(
								"It's either your ID Number is already in the system,");
						JLabel lblNewLabel2 = new JLabel(
								"or the system malfunctioned.");
						JLabel lblNewLabel3 = new JLabel(
								"If I were you, I'd tell the person in the booth.");
						lblNewLabel.setBounds(10, 31, 414, 37);
						lblNewLabel1.setBounds(10, 71, 414, 37);
						lblNewLabel2.setBounds(10, 91, 414, 37);
						lblNewLabel3.setBounds(10, 111, 414, 37);

						lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 17));
						lblNewLabel1
								.setFont(new Font("Verdana", Font.PLAIN, 14));
						lblNewLabel2
								.setFont(new Font("Verdana", Font.PLAIN, 17));
						lblNewLabel3
								.setFont(new Font("Verdana", Font.PLAIN, 17));

						lblNewLabel
								.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel1
								.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel2
								.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel3
								.setHorizontalAlignment(SwingConstants.CENTER);
						content.add(lblNewLabel);
						content.add(lblNewLabel1);
						content.add(lblNewLabel2);
						content.add(lblNewLabel3);

						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(
								Error.class
										.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
						lblNewLabel_1.setBounds(20, 31, 35, 37);
						content.add(lblNewLabel_1);
						thisFrame.setEnabled(false);
						JButton btnDismiss = new JButton("Dismiss");
						btnDismiss.setBounds(166, 149, 89, 23);
						//

						error.getRootPane().setDefaultButton(btnDismiss);
						btnDismiss.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								error.dispose();
								thisFrame.setEnabled(true);
								thisFrame.toFront();

								fine = true;
							}
						});
						content.add(btnDismiss);

						fine = false;

					} catch (IOException e1) {

					}
					if (fine) {
						RegDone rd = new RegDone(nickname.getText(), thisFrame);
						thisFrame.setEnabled(false);

					}

				} else {
					fine = false;
					JPanel content;
					Toolkit.getDefaultToolkit().beep();
					thisFrame.setEnabled(false);
					final JFrame error = new JFrame();
					error.setTitle("Seems like there's a slight problem.");
					error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					error.setBounds(460, 300, 450, 180);
					content = new JPanel();
					content.setBorder(new EmptyBorder(5, 5, 5, 5));
					error.setContentPane(content);
					error.setAlwaysOnTop(true);
					content.setLayout(null);
					error.setVisible(true);
					error.setResizable(false);
					JLabel lblNewLabel = new JLabel("Hold on for a second!");
					JLabel lblNewLabel2 = new JLabel(
							"It seems like you missed something there!");
					lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 17));
					lblNewLabel2.setFont(new Font("Impact", Font.PLAIN, 17));
					lblNewLabel.setBounds(10, 31, 414, 37);
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel2.setBounds(10, 49, 414, 37);
					lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
					content.add(lblNewLabel);
					content.add(lblNewLabel2);

					JLabel lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setIcon(new ImageIcon(
							Error.class
									.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
					lblNewLabel_1.setBounds(20, 31, 35, 37);
					content.add(lblNewLabel_1);

					JButton btnDismiss = new JButton("Dismiss");
					btnDismiss.setBounds(166, 95, 89, 23);
					error.getRootPane().setDefaultButton(btnDismiss);
					btnDismiss.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							error.dispose();
							thisFrame.setEnabled(true);
							thisFrame.toFront();
							fine = true;
						}
					});
					content.add(btnDismiss);

				}

			}

		});
		submit.setBounds(218, 331, 136, 30);
		contentPane.add(submit);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 96, 529, 2);
		contentPane.add(separator_1);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new BackListener(this));
		btnBack.setBounds(430, 35, 89, 39);
		contentPane.add(btnBack);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setBounds(223, 109, 126, 14);
		contentPane.add(lblNickname);

		nickname = new JTextField();
		nickname.setHorizontalAlignment(SwingConstants.CENTER);
		nickname.setBounds(223, 140, 126, 20);
		contentPane.add(nickname);
		nickname.setColumns(10);

		courses = new JComboBox();
		courses.setModel(new DefaultComboBoxModel(new String[] { "Course",
				"BIO", "LfSci", "CH", "CH-MSE", "ES", "CS", "MS/CS", "MIS",
				"MIS-MSCS", "EcE", "PS", "APS-MSE", "MA", "AMF", "HS", "CoE" }));

		courses.setBounds(392, 140, 126, 20);
		contentPane.add(courses);
	}

	public void insert() throws FileNotFoundException, SQLException {
		SQLHandler sql = SQLHandler.getInstance();

	}

	public boolean isComplete() {
		if (idnum.getText().length() < 6)
			return false;
		if (nickname.getText().trim().equals(""))
			return false;
		if (firstname.getText().trim().equals(""))
			return false;
		if (lastname.getText().trim().equals(""))
			return false;
		if (middlename.getText().trim().equals(""))
			return false;
		if (month.getSelectedItem().equals("Month"))
			return false;
		if (year.getSelectedItem().equals("Year"))
			return false;
		if (day.getSelectedItem().equals("Day"))
			return false;
		if (courses.getSelectedItem().equals("Course"))
			return false;

		return true;
	}
}
