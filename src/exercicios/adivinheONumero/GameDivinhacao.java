package exercicios.adivinheONumero;

import java.awt.BorderLayout;	
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameDivinhacao extends JFrame 
{
	private final JLabel labelComando, labelDica;
	private final JTextField campo;
	private final Handler manipulador;
	private final JButton botao;
	private final JPanel superior, inferior;
	private int numTentativa = 1;
	private String comando = "Eu tenho um número entre 1 e 1000, você consegue "
			+ "adivinhar? Entre com a tua " + numTentativa + "ª tentativa";
	
	public GameDivinhacao() 
	{
		super("Game de adivinhação");
		this.labelComando = new JLabel(comando);
		this.labelDica = new JLabel("");
		this.campo = new JTextField(4);
		this.botao = new JButton("Reiniciar");
		this.superior = new JPanel();
		this.inferior = new JPanel();
		this.manipulador = new Handler(this);
		
		organizarComponentes();
		iniciarGUI();
		
		
	}
	
	private void organizarComponentes()
	{
		this.setLayout(new BorderLayout());
		this.superior.setLayout(new FlowLayout());
		this.inferior.setLayout(new FlowLayout());
		this.superior.add(this.labelComando);
		this.add(superior, BorderLayout.NORTH);
		this.inferior.add(campo);
		this.inferior.add(labelDica);
		this.add(inferior);
	}
	
	private void iniciarGUI()
	{
		setDefaultCloseOperation(GameDivinhacao.EXIT_ON_CLOSE);
		setSize(600, 100);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public JLabel getLabelComando()
	{
		return this.labelComando;
	}
	
	public JLabel getLabelDica()
	{
		return this.labelDica;
	}
	
	public JTextField getCampo()
	{
		return this.campo;
	}
	
	public Handler getHandler()
	{
		return this.manipulador;
	}
	
	public JButton getBotao()
	{
		return this.botao;
	}
	
	public JPanel getSuperior()
	{
		return this.superior;
	}
	
	public JPanel getInferior()
	{
		return this.inferior;
	}
	
	public int getNumTentativa()
	{
		return this.numTentativa;
	}
	
	public void setNumTentativa(int incremento)
	{
		this.numTentativa = incremento;
	}
	
	public String getComando()
	{
		return comando;
	}
	
	public void setComando(String novoComando)
	{
		comando = novoComando;
	}
}
