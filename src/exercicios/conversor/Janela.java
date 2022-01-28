package exercicios.conversor;

import javax.swing.JFrame;

public class Janela extends JFrame
{
	private final Cont�iner cont�inerPrincipal, cont�iner1, cont�iner2;
	private Handler handler;
	private int QuantidadeDeEscolhas = 2;
	
	Janela()
	{
		super("Conversor de temperatura");
		
		this.cont�inerPrincipal = new Cont�iner("Escolha uma das " + this.QuantidadeDeEscolhas
				+ " opc�es abaixo de convers�o entre escalas de temperatura",
				"Fahrenheit -> Celsius", "Celsius -> Fahrenheit");
		
		this.cont�iner1 = new Cont�iner("Entre com o valor da temperatura em Fahrenheit para "
				+ "esta ser convertida para Celsius: ");
		
		this.cont�iner2 = new Cont�iner("Entre com o valor da temperatura em Celsius para "
				+ "esta ser convertida para escala Kelvin: ");
		
		this.handler = new Handler(this, this.cont�inerPrincipal, this.cont�iner1, 
				this.cont�iner2);
		
		this.handler = new Handler(this, this.cont�inerPrincipal, this.cont�iner1, this.cont�iner2);
		
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
