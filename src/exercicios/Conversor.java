package exercicios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Conversor extends JFrame
{
	private final JLabel label;
	private final JTextField campo;
	
	public Conversor()
	{
		super("Conversor");
		
		this.label = new JLabel();
		this.campo = new JTextField(5);
		
		this.campo.addActionListener(new Handler());

		this.setLayout(new FlowLayout());
		this.add(new JLabel("Entre com a temperatura em Fahrenheit para converte-la"
				+ " em Celsius: "));
		this.add(campo);
		this.add(label);
		
		initGUI();
	}
	
	private void initGUI()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 100);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private class Handler implements ActionListener
	{
		float fahrenheit;
		float celsius;
		@Override
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				fahrenheit = Float.parseFloat(campo.getText());
				celsius = 5.0F/9.0F * (fahrenheit -32);
				label.setText(String.valueOf(celsius));
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(Conversor.this, e.getMessage(),
						"Erro -> A entrada deve ser numérica", JOptionPane.ERROR_MESSAGE);
				Conversor.this.campo.setText("");
				Conversor.this.label.setText("");
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		new Conversor();
	}
}
