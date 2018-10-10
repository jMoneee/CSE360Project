import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
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
	public gui() {
		
		backEnd b= new backEnd();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 142, 829);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setForeground(Color.BLACK);
		contentPane.add(panel);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAbout.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				JLabel about = new JLabel("Program lets you input activities and lets you track them");
				about.setFont(new Font("Tahoma", Font.PLAIN, 30));
				JOptionPane pane = new JOptionPane(about);
				JDialog window = pane.createDialog("About");
				window.setSize(1800,300);
				window.show();
			}
		});
		panel.add(btnAbout);
		
		JButton button = new JButton("Help");
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				JLabel help = new JLabel("Input activity name, duration and dependencies. \nPress 'Enter Activity' to save the data. Change tab to 'Output' to see results.");
				help.setFont(new Font("Tahoma", Font.PLAIN, 30));
				JOptionPane pane = new JOptionPane(help);
				JDialog window = pane.createDialog("Help");
				window.setSize(1800,300);
				window.show();
			}
		});
		panel.add(button);
		
		
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnRestart);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Activity Organizer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setBounds(252, 0, 744, 59);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(148, 54, 887, 640);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(new Rectangle(0, 0, 500, 400));
		panel_1.setLocation(new Point(10, 10));
		panel_1.setSize(new Dimension(10, 10));
		panel_1.setPreferredSize(new Dimension(500, 400));
		panel_1.setAutoscrolls(true);
		panel_1.setMinimumSize(new Dimension(500, 400));
		tabbedPane.addTab("Input", null, panel_1, null);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN,30));
		tabbedPane.setEnabledAt(0, true);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(350, 5, 0, 0);
		panel_1.add(label);
		
		JLabel lblActivityName = new JLabel("Activity Name: ");
		lblActivityName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblActivityName.setBounds(16, 20, 239, 26);
		panel_1.add(lblActivityName);
		
		JLabel lblNewLabel_1 = new JLabel("Activity Duration: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(16, 67, 255, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblActivityDependencies = new JLabel("Activity Dependencies: ");
		lblActivityDependencies.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblActivityDependencies.setBounds(16, 114, 351, 26);
		panel_1.add(lblActivityDependencies);
		
		textField = new JTextField();
		textField.setBounds(325, 21, 186, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(325, 68, 186, 32);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(325, 115, 186, 32);
		panel_1.add(textField_2);
		
		JButton btnEnterActivity = new JButton("Enter Activity");
		btnEnterActivity.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEnterActivity.setBounds(632, 48, 229, 61);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!=null && textField_1.getText()!=null&&textField_2.getText()!=null)
				{
				b.setName(textField.getText());
				b.setDuration(textField_1.getText());
				b.hasDependencies(textField_2.getText());
				}
			}
		});
		panel_1.add(btnEnterActivity);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 162, 851, 417);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Output",null , panel_2, null);
		panel_2.setLayout(null);
		
		textField_4 = new JTextField("List of Output paths");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField_4.setBounds(21, 44, 840, 524);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblOutputPaths = new JLabel("Output Paths");
		lblOutputPaths.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblOutputPaths.setBounds(367, 0, 253, 37);
		panel_2.add(lblOutputPaths);
	}
	
}
