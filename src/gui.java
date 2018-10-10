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
import java.awt.Insets;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;

import javax.swing.JTextArea;


public class gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JTextArea textField_3;
	private JTextArea textField_4;
	Path p = new Path();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 127, 529);
		contentPane.add(panel);
		
		JButton btnAbout = new JButton("About");

		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("about clicked");
			}
		});

		panel.add(btnAbout);
		
		JButton button = new JButton("Help");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("help clicked");

			}
		});
		panel.add(button);
		
		JButton btnRestart = new JButton("Restart");

		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("restart clicked");
				p = new Path();
				textField_4.setText("");
			}
		});

		panel.add(btnRestart);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Activity Organizer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(130, 0, 744, 59);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(148, 54, 705, 454);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Input", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(350, 5, 0, 0);
		panel_1.add(label);
		
		JLabel lblActivityName = new JLabel("Activity Name: ");
		lblActivityName.setBounds(0, 21, 172, 26);
		panel_1.add(lblActivityName);
		
		JLabel lblNewLabel_1 = new JLabel("Activity Duration: ");
		lblNewLabel_1.setBounds(0, 68, 172, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblActivityDependencies = new JLabel("Activity Dependencies: ");
		lblActivityDependencies.setBounds(0, 115, 172, 26);
		panel_1.add(lblActivityDependencies);
		
		textField = new JTextField();
		textField.setBounds(194, 26, 186, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 65, 186, 32);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(193, 112, 186, 32);
		panel_1.add(textField_2);
		
		JButton btnEnterActivity = new JButton("Enter Activity");
		btnEnterActivity.setBounds(494, 64, 141, 35);
		panel_1.add(btnEnterActivity);

		btnEnterActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("node created");
				ArrayList<String> depen = new ArrayList<String>();
				if(textField_2.getText().equals(""))
					textField_2.setText(" ");
				for(int i=0; i<textField_2.getText().length();i++)
					depen.add(textField_2.getText().substring(i, i+1));
				Node n = new Node(Integer.parseInt(textField_1.getText()), textField.getText(), depen);
				p.addNode(n);
				PathMaker m = new PathMaker();
				String names="",input=textField_3.getText();
				ArrayList<Node> joe = p.getActivities();
				for(int i=0; i<joe.size();i++)
					names+=joe.get(i).getName();
				
				input+=n.getName()+"\t\t\t"+n.printDependencies()+" \t\t\t"+n.getSize()+"\n";
				textField_3.setText(input);
				textField_4.setText(names);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		
		textField_3 = new JTextArea();
		textField_3.setBounds(10, 166, 669, 248);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText("Activity Name:\t\t\tPredicessor(s):\t\t\tDuration:\n");
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Output", null, panel_2, null);
		
		panel_2.setLayout(null);
		
		textField_4 = new JTextArea("List of Output paths");

		textField_4.setBounds(21, 44, 658, 349);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblOutputPaths = new JLabel("Output Paths");
		lblOutputPaths.setBounds(312, 0, 172, 26);
		panel_2.add(lblOutputPaths);
	}
}
