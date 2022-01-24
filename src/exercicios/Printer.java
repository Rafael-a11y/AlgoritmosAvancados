package exercicios;

import javax.swing.JFrame;	
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JPanel;

public class Printer extends JFrame
{
	private final JButton ok, cancel, setup, help;
	private final JTextArea area, area2, area3;
	private final ButtonGroup grupo;
	private final JRadioButton selection, all, applet;
	private final JCheckBox image, text, code, print;
	private final JComboBox<String> comboBox;
	private final JLabel myPrinter, printQuality;
	private final JPanel painelArea, painelCheck, painelArea2, painelRadio, 
		painelArea3, painelButton, painelGrid;
	private final Box box;
	
	public Printer() 
	{
		super("Printer");
		
		ok = new JButton("Ok");
		cancel = new JButton("Cancel");
		setup = new JButton("Setup");
		help = new JButton("Help");
		
		area = new JTextArea(3, 5);
		area2 = new JTextArea(3, 5);
		area3 = new JTextArea(3, 5);
		
		grupo = new ButtonGroup();
		
		selection = new JRadioButton("Selection");
		all = new JRadioButton("All");
		applet = new JRadioButton("Applet");
		
		image = new JCheckBox("Image");
		text = new JCheckBox("Text");
		code = new JCheckBox("Code");
		print = new JCheckBox("Print to File");
		
		comboBox = new JComboBox<String>(new String[] {"High"}) ;
		myPrinter = new JLabel("Printer: MyPrinter");
		printQuality = new JLabel("Print Quality:");
		
		box = Box.createHorizontalBox();
		painelArea = new JPanel(new FlowLayout());
		painelCheck = new JPanel(new FlowLayout());
		painelArea2 = new JPanel(new FlowLayout());
		painelRadio = new JPanel(new FlowLayout());
		painelArea3 = new JPanel(new FlowLayout());
		painelButton = new JPanel(new FlowLayout());
		painelGrid = new JPanel(new GridLayout(1, 6));
		
		ok.setPreferredSize(new Dimension(72, 25));
		cancel.setPreferredSize(new Dimension(72, 25));
		setup.setPreferredSize(new Dimension(72, 25));
		help.setPreferredSize(new Dimension(72, 25));
		
		area.setLineWrap(true);
		area2.setLineWrap(true);
		area3.setLineWrap(true);
		
//		grupo.add(selection);
//		grupo.add(all);
//		grupo.add(applet);
		
		painelArea.add(myPrinter);
		painelArea.add(new JScrollPane(area));
		painelArea.add(printQuality);
		
		painelCheck.add(image);
		painelCheck.add(text);
		painelCheck.add(code);
		
		painelArea2.add(new JScrollPane(area2));
		painelArea2.add(comboBox);
		
		painelRadio.add(selection);
		painelRadio.add(all);
		painelRadio.add(applet);
		
		painelArea3.add(new JScrollPane(area3));
		painelArea3.add(print);
		
		painelButton.add(ok);
		painelButton.add(cancel);
		painelButton.add(setup);
		painelButton.add(help);
		
		painelGrid.add(painelArea);
		painelGrid.add(painelCheck);
		painelGrid.add(painelArea2);
		painelGrid.add(painelRadio);
		painelGrid.add(painelArea3);
		painelGrid.add(painelButton);
		
		this.add(painelGrid);
		
		initGUI();
		
		}
	
	private void initGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 170);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Printer();
	}
}
