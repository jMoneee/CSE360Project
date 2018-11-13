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

import java.util.ArrayList;

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

import javax.swing.JTextArea;


public class gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JTextArea textField_3;
	private JTextArea textField_4;
	Path p = new Path();
	ArrayList <String> dependencyList = new ArrayList<String>();
	ArrayList<Node> joe;
    String output;
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
					
		String about= "The purpose of the program is to analyse an inputed set of nodes of a network diagram and determine all the paths as well as information about said paths. \r\n" + 
				"\r\n" + 
				"This project was created by the following people:\n" + 
				"\n" + 
				"Joseph Larsen\n" + 
				"Adam Rubic\n" + 
				"Kaisser Kelcho\n" + 
				"Lukas Cronin\n" + 
				"";
					
					JOptionPane pane = new JOptionPane(about);
					JDialog window = pane.createDialog("About ");
					window.setSize(600,300);
					window.show();
			}
		});

		panel.add(btnAbout);
		
		JButton button = new JButton("Help");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					String helpBut ="The input tab contains 3 text input fields for inputting activites, one for an activity’s name, duration and dependencies. \n"
							+ "The text from these fields is taken from these fields once the ‘Enter Activity’ button is pressed and used to create the activities in the list. "
							+ "\nAs activities are entered they will appear in the field below it, which is a list of all entered activities. "
							+ "\nThe path list will be displayed on the Output tab and is updated every time a new node is entered." + 
							"\n" + 
							"The Output tab will only have one field which will display the list of paths and all needed information about the paths. The output tab will be update every time a new node is added.\r\n" + 
							"";
					
					JOptionPane pane = new JOptionPane(helpBut);
					JDialog window = pane.createDialog("Help");
					window.setSize(1000,300);
					window.show();
				}

			
		});
		panel.add(button);
		JButton btnRestart = new JButton("Restart");

		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("restart clicked");
				p = new Path();
				textField_4.setText("");
				textField_3.setText("Activity Name:\t\t\tPredicessor(s):\t\t\tDuration:\n");
			}
		});


		panel.add(btnRestart);
		
		JButton btnProcess = new JButton("Process");

		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PathMaker pathM = new PathMaker();
				if(pathM.findFirst(joe)==9999) {
					String errorCycle= "Error, Cycle detected reseting inputs";
					JOptionPane pane = new JOptionPane(errorCycle);
					JDialog window = pane.createDialog("Error");
					window.setSize(600,300);
					window.show();
					
					p = new Path();
					textField_4.setText("");
					textField_3.setText("Activity Name:\t\t\tPredicessor(s):\t\t\tDuration:\n");
					
				}
				if(pathM.findFirst(joe)==8888) {
					String errorExtraFirst= "Error, unconnected node detected reseting inputs";
					JOptionPane pane = new JOptionPane(errorExtraFirst);
					JDialog window = pane.createDialog("Error");
					window.setSize(600,300);
					window.show();
					
					p = new Path();
					textField_4.setText("");
					textField_3.setText("Activity Name:\t\t\tPredicessor(s):\t\t\tDuration:\n");
					
				}
                ArrayList<Path> pathList;
                pathList = pathM.MakePaths(joe);
                textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
                output ="Output Path(s): \n";
                pathList = pathM.pathSort(pathList);
                //System.out.println("path size"+pathList.size());
                for(int i=0; i<pathList.size();i++)
                {
                	for(int j=0; j<pathList.get(i).getActivities().size();j++)
                	{
                		output+=pathList.get(i).getActivities().get(j).getName();
                	}
                	output+=" "+pathList.get(i).getDuration();
                	output+="\n";
                }
                textField_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
                textField_4.setText(output);
			}
		});
		
		panel.add(btnProcess);
		
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
				if(!textField_1.getText().matches(".*\\d+.*")) {
					String errorInt= "Error, non-integer detected for node duration. Reseting inputs";
					JOptionPane pane = new JOptionPane(errorInt);
					JDialog window = pane.createDialog("Error");
					window.setSize(600,300);
					window.show();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
				else {
				System.out.println("node created");
				ArrayList<String> depen = new ArrayList<String>();
				if(textField_2.getText().equals(""))
				{
					
				}
				else
				{
				for(int i=0; i<textField_2.getText().length();i++)
					depen.add(textField_2.getText().substring(i, i+1));
				}
				
				Node n = new Node(Integer.parseInt(textField_1.getText()), textField.getText(), depen);
				System.out.println("depends" +n.hasDependencies());
				p.addNode(n);
				PathMaker m = new PathMaker();
				String names="",input=textField_3.getText();
				joe = p.getActivities();
				for(int i=0; i<joe.size();i++)
					names+=joe.get(i).getName();

                         	
				
                	

               
               
             //  System.out.println(m.findFirst(joe));
              // System.out.println(m.findDependencies(m.findFirst(joe),joe));
                Path temp;
               /* for (int i = 1; i < pathList.size(); i++) {
                    for(int j = i ; j > 0 ; j--){
                        if(pathList.get(j).getDuration() < pathList.get(j-1).getDuration()){
                            temp = pathList.get(j);
                            pathList.set(j, pathList.get(j-1));

                            pathList.set(j-1, temp);
                        }
                    }
                }*/
				
				
				input+=n.getName()+"\t\t\t"+n.printDependencies()+" \t\t\t"+n.getSize()+"\n";
				textField_3.setText(input);
				//textField_4.setText(names);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				}
			}
		});
		
		textField_3 = new JTextArea();
		textField_3.setBounds(10, 166, 669, 302);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		
		textField_3.setText("Activity Name:\t\t\tPredicessor(s):\t\t\tDuration:\n");
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Output", null, panel_2, null);
		
		panel_2.setLayout(null);

		textField_4 = new JTextArea("");
	    textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setBounds(21, 44, 286, 303);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		JLabel lblOutputPaths = new JLabel("Path List");
		lblOutputPaths.setBounds(21, 0, 172, 26);
		panel_2.add(lblOutputPaths);
		
		JButton btnCreateReport = new JButton("Create Report");
		btnCreateReport.setBounds(21, 358, 187, 35);
		panel_2.add(btnCreateReport);
		btnCreateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateReport report= new CreateReport();
				report.setVisible(true);
			}
		});
		
		JTextArea textArea = new JTextArea("");
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textArea.setColumns(10);
		textArea.setBounds(354, 44, 307, 303);
		panel_2.add(textArea);
		
		JLabel label_1 = new JLabel("Critical Path");
		label_1.setBounds(359, 0, 172, 26);
		panel_2.add(label_1);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(499, 0, 141, 35);
		panel_2.add(btnGenerate);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();			//closes window
			}
		});
		
		JButton btnChangeNodeDuration = new JButton("Change Node Duration");
		btnChangeNodeDuration.setBounds(354, 358, 196, 35);
		panel_2.add(btnChangeNodeDuration);
		btnChangeNodeDuration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeNodeDuration chgn= new ChangeNodeDuration();
				chgn.setVisible(true);
				dispose();			//closes window
			}
		});
	}
}
