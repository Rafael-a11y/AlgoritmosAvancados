package exercicios;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Calculator extends JFrame 
{
	private String[] simbolos = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-",
			"0", ".", "=", "+"};
	private JTextField campoTexto;
	private JPanel painel;

	Calculator()
	{
		super("Calculadora");
		
		this.campoTexto = new JTextField();
		this.campoTexto.setPreferredSize(new Dimension(0, 40));
		this.painel = new JPanel();
		this.painel.setLayout(new GridLayout(4, 4, 10, 10));
		this.setLayout(new BorderLayout(0, 30));
		
		for(int count = 0; count < simbolos.length; count++)
		{
			this.painel.add(new JButton(simbolos[count]));
		}
		
		this.add(campoTexto, BorderLayout.NORTH);
		this.add(painel, BorderLayout.CENTER);
		initGUI();
	}
	
	private void initGUI()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(250, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Calculator();
	}
}