package exercicios;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlignFrame extends JFrame
{
	private JCheckBox box1, box2;
	private JLabel labelX, labelY;
	private JTextField textFieldX, textFieldY;
	private JButton buttonOk, buttonCancel, buttonHelp;
	private JPanel  panelBorder, panelBorder2, panelBorder3, panelBorder4;
	
	AlignFrame()
	{
		super("Alinhamento");
		
		this.setLayout(new FlowLayout());
		
		this.box1 = new JCheckBox("1ª checkBox");
		this.box2 = new JCheckBox("2ª checkBox");
		
		this.labelX = new JLabel("Label X");
		this.labelY = new JLabel("Label Y");
		
		this.textFieldX = new JTextField("8", 5);
		this.textFieldY = new JTextField("8", 5);
		
		this.buttonOk = new JButton("Ok");	
		this.buttonCancel = new JButton("Cancel");
		this.buttonHelp = new JButton("Help");
		
		this.panelBorder = new JPanel();
		this.panelBorder2 = new JPanel();
		this.panelBorder3 = new JPanel();
		this.panelBorder4 = new JPanel();
		
		this.panelBorder.setLayout(new BorderLayout());
		this.panelBorder2.setLayout(new BorderLayout());
		this.panelBorder3.setLayout(new BorderLayout());
		this.panelBorder4.setLayout(new BorderLayout());
		
		this.panelBorder.add(box1, BorderLayout.BEFORE_FIRST_LINE);
		this.panelBorder.add(box2, BorderLayout.BEFORE_LINE_BEGINS);
		this.add(panelBorder);
		
		this.panelBorder2.add(labelX, BorderLayout.BEFORE_FIRST_LINE);
		this.panelBorder2.add(labelY, BorderLayout.BEFORE_LINE_BEGINS);
		this.add(panelBorder2);
		
		this.panelBorder3.add(textFieldX, BorderLayout.BEFORE_FIRST_LINE);
		this.panelBorder3.add(textFieldY, BorderLayout.BEFORE_LINE_BEGINS);
		this.add(panelBorder3);
		
		this.panelBorder4.add(buttonOk, BorderLayout.BEFORE_FIRST_LINE);
		this.panelBorder4.add(buttonCancel, BorderLayout.BEFORE_LINE_BEGINS);
		this.panelBorder4.add(buttonHelp, BorderLayout.AFTER_LAST_LINE);
		this.add(panelBorder4);
		
		this.initGUI();
	}
	
	 void initGUI()
	{
		this.setDefaultCloseOperation(AlignFrame.EXIT_ON_CLOSE);
		this.setSize(380, 150);
//		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	 
	 
	 public static void main(String[] args) {
		
		 new AlignFrame();
	}
}