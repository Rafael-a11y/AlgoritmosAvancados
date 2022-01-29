package exercicios.conversor;

import javax.swing.JFrame;

public class Janela extends JFrame
{
	private final Cont�iner cont�inerPrincipal, cont�iner1, cont�iner2, cont�iner3, cont�iner4, cont�iner5, cont�iner6;
	private Handler handler;
	private int QuantidadeDeEscolhas = 6;
	
	Janela()
	{
		super("Conversor de temperatura");
		
		this.cont�inerPrincipal = new Cont�iner("Escolha uma das " + this.QuantidadeDeEscolhas
				+ " opc�es abaixo de convers�o entre escalas de temperatura",
				"Fahrenheit -> Celsius", "Celsius -> Kelvin", "Celsius -> Fahrenheit", "Kelvin -> Celsius",
				"Fahrenheit -> Kelvin", "Kelvin -> Fahrenheit");
		
		this.cont�iner1 = new Cont�iner("Entre com o valor da temperatura em Fahrenheit para "
				+ "esta ser convertida para Celsius: ");
		
		this.cont�iner2 = new Cont�iner("Entre com o valor da temperatura em Celsius para "
				+ "esta ser convertida para escala Kelvin: ");
		
		this.cont�iner3 = new Cont�iner("Entre com o valor da temperatura em Celsius para "
				+ "esta ser convertida para Fahrenheit: ");
		
		this.cont�iner4 = new Cont�iner("Entre com o valor da temperatura em Kelvin para "
				+ "esta ser convertida para Celsius: ");
		
		this.cont�iner5 = new Cont�iner("Entre com o valor da temperatura em Fahrenheit para "
				+ "esta ser convertida para Kelvin: ");
		
		this.cont�iner6 = new Cont�iner("Entre com o valor da temperatura em Kelvin para "
				+ "esta ser convertida para Fahrenheit: ");
		
		this.handler = new Handler(this, this.cont�inerPrincipal, this.cont�iner1, 
				this.cont�iner2, this.cont�iner3, this.cont�iner4, this.cont�iner5, 
				this.cont�iner6);
		
		this.handler = new Handler(this, this.cont�inerPrincipal, this.cont�iner1, this.cont�iner2, 
				this.cont�iner3, this.cont�iner4, this.cont�iner5, this.cont�iner6);
		
		this.initGUI();
	}
	
	private void initGUI()
	{
		this.setContentPane(this.cont�inerPrincipal);
		this.validate();
		this.setDefaultCloseOperation(Janela.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(700, 150);
		this.setVisible(true);
	}
}
