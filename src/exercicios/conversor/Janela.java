package exercicios.conversor;

import javax.swing.JFrame;

public class Janela extends JFrame
{
	private final Contêiner contêinerPrincipal, contêiner1, contêiner2;
	private Handler handler;
	private int QuantidadeDeEscolhas = 2;
	
	Janela()
	{
		super("Conversor de temperatura");
		
		this.contêinerPrincipal = new Contêiner("Escolha uma das " + this.QuantidadeDeEscolhas
				+ " opcões abaixo de conversão entre escalas de temperatura",
				"Fahrenheit -> Celsius", "Celsius -> Fahrenheit");
		
		this.contêiner1 = new Contêiner("Entre com o valor da temperatura em Fahrenheit para "
				+ "esta ser convertida para Celsius: ");
		
		this.contêiner2 = new Contêiner("Entre com o valor da temperatura em Celsius para "
				+ "esta ser convertida para escala Kelvin: ");
		
		this.handler = new Handler(this, this.contêinerPrincipal, this.contêiner1, 
				this.contêiner2);
		
		this.handler = new Handler(this, this.contêinerPrincipal, this.contêiner1, this.contêiner2);
		
		this.initGUI();
	}
	
	private void initGUI()
	{
		this.setContentPane(this.contêinerPrincipal);
		this.validate();
		this.setDefaultCloseOperation(Janela.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(700, 150);
		this.setVisible(true);
	}
}
