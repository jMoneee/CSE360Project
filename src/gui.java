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
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
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
    ArrayList<Path> pathList;
    PathMaker pathM = new PathMaker();
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


				/*if(pathM.findUnconnected(joe)==1) {


					String errorExtraFirst= "Error, unconnected node detected reseting inputs";
					JOptionPane pane = new JOptionPane(errorExtraFirst);
					JDialog window = pane.createDialog("Error");
					window.setSize(600,300);
					window.show();
					
					p = new Path();
					textField_4.setText("");
					textField_3.setText("Activity Name:\t\t\tPredicessor(s):\t\t\tDuration:\n");
					
				}*/
                
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
		

		JButton btnCreateNetworkPath = new JButton("Create Network Path");
		btnCreateNetworkPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCreateNetworkPath.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCreateNetworkPath.setBounds(276, 472, 364, 96);
		panel_1.add(btnCreateNetworkPath);

		
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
		
		JButton btnCreateReport = new JButton("Create Report: ");								//Create Report Button that creates the txt file 
		btnCreateReport.setBounds(21, 358, 187, 35);
		panel_2.add(btnCreateReport);
		JLabel reportLb= new JLabel("<html> Report Name:</html>");
		JTextField reportTf= new JTextField();
		JButton reportBtn= new JButton("Create Report");
		btnCreateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JPanel pane = new JPanel();
				pane.setLayout(new GridLayout(4,1));
				pane.add(reportLb);
				pane.add(reportTf);
				pane.add(reportBtn);
				
				JFrame window = new JFrame("Create Report");
				window.setSize(1000,300);
				window.getContentPane().add(pane);
				window.show();
				
				reportBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String reportName= reportTf.getText()+".txt";
						Calendar c = Calendar.getInstance();
						ArrayList<Path> pathList;
						Path path=new Path();
						joe=p.getActivities();
						PathMaker m = new PathMaker();
						
						
						try {
							
							PrintWriter file=new PrintWriter(reportName);
							file.println(reportName);
							file.println(c.getTime());
							file.println("");
							file.println("All Activities");
							for(int i=0;i<joe.size();i++)
							{
								file.println(joe.get(i).getName()+" ");
							}
							
							file.println();
							
							file.println("All Paths and Total Duration:");
							for(int i=0;i<m.numOfPaths;i++)
							{
								file.print(m.MakePaths(joe));
							}
							file.println();
							file.print("Total Duration: "+p.getDuration());
							
							file.close();
						} catch(IOException e) {
							e.printStackTrace();
						}
				
						
						window.dispose();					//closes changeNode jFrame
					}
				});
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
					//put crit path stuff here
				String outputCrit = "";
				ArrayList<Path> critPaths = pathM.findCriticalPaths(pathList);
				for(int i=0; i<critPaths.size();i++)
                {
                	for(int j=0; j<critPaths.get(i).getActivities().size();j++)
                	{
                		outputCrit+=critPaths.get(i).getActivities().get(j).getName();
                	}
                	outputCrit+=" "+critPaths.get(i).getDuration();
                	outputCrit+="\n";
                }
				textArea.setText(outputCrit);
				
			}
		});
		
		JButton btnChangeNodeDuration = new JButton("Change Node Duration");
		btnChangeNodeDuration.setBounds(354, 358, 196, 35);
		panel_2.add(btnChangeNodeDuration);
		
		JLabel toChange = new JLabel("<html> Node To Change:</html>");
		JTextField toChangeTf= new JTextField();
		JLabel newDur= new JLabel("<html> New Duration:</html>");
		JTextField newDurTf= new JTextField();
		JButton newDurBtn= new JButton("Enter");
		
		btnChangeNodeDuration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JPanel pane = new JPanel();
				pane.setLayout(new GridLayout(4,1));
				pane.add(toChange);
				pane.add(toChangeTf);
				pane.add(newDur);
				pane.add(newDurTf);
				pane.add(newDurBtn);
				
				JFrame window = new JFrame("Change Node Duration");
				window.setSize(1000,300);
				window.getContentPane().add(pane);
				window.show();
				newDurBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						window.dispose();					//closes changeNode jFrame
					}
				});
			}
		});
		newDurBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//put duration change here
				
			}
		});
	}
}
