package exercicios;

import java.awt.Container;		
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Conversor extends JFrame
{
	private final JLabel labelDecisao, labelComando1, labelComando2,
		labelResultado1, labelResultado2;
	
	private final JTextField campo1, campo2;
	
	private final JRadioButton radio1, radio2;
	
	private final JButton voltar1, voltar2;
	
	private final ButtonGroup grupo;
	private final JPanel painelSuperior1, painelInferior1, painelSuperior2, painelInferior2;
	
	private final FlowLayout layoutInferior1, layoutSuperior1, 
		layoutInferior2, layoutSuperior2;
	
	private final Container container1, container2, container3;
	
	private final Handler handler;
	
	public Conversor()
	{
		super("Conversor");
		
		this.voltar1 = new JButton("Voltar");
		this.voltar2 = new JButton("Voltar");
		
		this.grupo = new ButtonGroup();
		this.radio1 = new JRadioButton("Fahrenheit para Celsius");
		this.radio2 = new JRadioButton("Celsius para Kelvin");
		this.grupo.add(radio1);
		this.grupo.add(radio2);
		
		this.labelComando1 = new JLabel("Entre com a temperatura em Fahrenheit para converte-la"
				+ " em Celsius: ");
		this.labelComando2 = new JLabel("Entre com a temperatura em Celsius para converte-la"
				+ " em Kelvin");
		this.labelDecisao = new JLabel("Escolha umas das opções de conversão de temperatura:"
				+ " Fahrenheit - Celsius     Celsius - Kelvin ");
		
		this.layoutSuperior1 = new FlowLayout(FlowLayout.LEFT);
		this.layoutInferior1 = new FlowLayout(FlowLayout.LEFT);
		
		this.layoutSuperior2 = new FlowLayout(FlowLayout.LEFT);
		this.layoutInferior2 = new FlowLayout(FlowLayout.LEFT);
		
		this.painelSuperior1 = new JPanel();
		this.painelSuperior1.setLayout(layoutSuperior1);
		
		this.painelInferior1 = new JPanel();
		this.painelInferior1.setLayout(layoutInferior1);
		
		this.painelSuperior2 =  new JPanel();
		this.painelSuperior2.setLayout(layoutSuperior2);
		
		this.painelInferior2 = new JPanel();
		this.painelInferior2.setLayout(layoutInferior2);
		
		this.labelResultado1 = new JLabel();
		this.labelResultado2 = new JLabel();
		this.campo1 = new JTextField(6);
		this.campo2 = new JTextField(6);
		this.handler = new Handler();
		
		this.container1 = new Container();
		this.container2 = new Container();
		
		
		this.painelSuperior1.add(voltar1);
		this.painelInferior1.add(labelComando1);
		this.painelInferior1.add(campo1);
		this.painelInferior1.add(labelResultado1);
//		this.container1.setSize(500, 100);
		this.container1.setLayout(new BorderLayout());
		this.container1.add(painelSuperior1, BorderLayout.NORTH);
		this.container1.add(painelInferior1, BorderLayout.CENTER);
		
		this.painelSuperior2.add(voltar2);
		this.painelInferior2.add(labelComando2);
		this.painelInferior2.add(campo2);
		this.painelInferior2.add(labelResultado2);
//		this.container2.setSize(500, 100);
		this.container2.setLayout(new BorderLayout());
		this.container2.add(painelSuperior2, BorderLayout.NORTH);
		this.container2.add(painelInferior2, BorderLayout.CENTER);
		
		this.container3 = this.getContentPane();
		this.container3.setLayout(new FlowLayout());
		this.container3.add(labelDecisao);
		this.container3.add(radio1);
		this.container3.add(radio2);
		
		this.radio1.addItemListener(handler);
		this.radio2.addItemListener(handler);
		this.campo1.addActionListener(handler);
		
		this.campo2.addActionListener(handler);
		this.voltar1.addActionListener(handler);
		this.voltar2.addActionListener(handler);
		
		initGUI();
	}
	
	private void initGUI()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 100);
		// Para Fahrenheit - Celsius 500 100
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private class Handler implements ActionListener, ItemListener
	{
		float fahrenheit, celsius, kelvin;
		boolean isRadio1, isRadio2;
		@Override
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				if(event.getSource() == voltar1 || event.getSource() == voltar2)
				{
					setContentPane(container3);
					validate();
				}
				else if(isRadio1)
				{
					fahrenheit = Float.parseFloat(campo1.getText());
					celsius = 5.0F/9.0F * (fahrenheit -32.0F);
					labelResultado1.setText(String.valueOf(celsius));
				}
				else if(isRadio2)
				{
					//  Kelvin = Celsius + 273,15
					celsius = Float.parseFloat(campo2.getText());
					kelvin = celsius + 273.15F;
					labelResultado2.setText(String.valueOf(kelvin));
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(Conversor.this, e.getMessage(),
						"Erro -> A entrada deve ser numérica", JOptionPane.ERROR_MESSAGE);
				if(isRadio1)
				{
					Conversor.this.campo1.setText("");
					Conversor.this.labelResultado1.setText("");
				}
				else
				{
					Conversor.this.campo2.setText("");
					Conversor.this.labelResultado2.setText("");
				}
			}
			
		}
		@Override
		public void itemStateChanged (ItemEvent event)
		{
			if(radio1.isSelected())
			{
				isRadio1 = true;
				isRadio2 = false;
				Conversor.this.setContentPane(container1);
				validate();
			}
			else if(radio2.isSelected())
			{
				isRadio2 = true;
				isRadio1 = false;
				setContentPane(container2);
				validate();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		new Conversor();
	}
}
