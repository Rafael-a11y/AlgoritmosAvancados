package exercicios;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;

public class Contêiner extends Container
{
	private final JButton voltar;
	private final JRadioButton radio1, radio2;
	private final ButtonGroup grupo;
	private final JTextField campo;
	private final JPanel painelSuperior, painelInferior;
	private final JLabel labelComando, labelResultado;
	private boolean itsMe;
	
	Contêiner(String comando)
	{
		this.voltar = new JButton("VOLTAR");
		this.campo = new JTextField(6);
		
		this.painelSuperior = new JPanel();
		this.painelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.painelInferior = new JPanel();
		this.painelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.labelComando = new JLabel(comando);
		this.labelResultado = new JLabel();
		this.itsMe = false;
		
		this.setLayout(new BorderLayout());
		
		this.painelSuperior.add(voltar);
		this.painelInferior.add(labelComando);
		this.painelInferior.add(campo);
		this.painelInferior.add(labelResultado);
		
		this.add(painelSuperior, BorderLayout.NORTH);
		this.add(painelInferior, BorderLayout.SOUTH);
		
		this.grupo = null;
		this.radio1 = null;
		this.radio2 = null;
	}
	
	Contêiner(String decisao, String opcao1, String opcao2)
	{
		this.grupo = new ButtonGroup();
		this.radio1 = new JRadioButton(opcao1);
		this.radio2 = new JRadioButton(opcao2);
		
		this.grupo.add(radio1);
		this.grupo.add(radio2);
		
		this.labelComando = new JLabel(decisao);
		this.painelSuperior = new JPanel();
		this.painelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.painelInferior = new JPanel();
		this.painelInferior.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.setLayout(new BorderLayout());
		
		this.painelSuperior.add(labelComando);
		this.painelInferior.add(radio1);
		this.painelInferior.add(radio2);
		this.add(painelSuperior, BorderLayout.NORTH);
		this.add(painelInferior, BorderLayout.SOUTH);
		
		this.itsMe = false;
		
		this.labelResultado = null;
		this.campo = null;
		this.voltar = null;
		
		
	}
	
	public boolean getItsMe()
	{
		return this.itsMe;
	}
	
	public void setItsMe(boolean novoValor)
	{
		this.itsMe = novoValor;
	}

	public final JButton getVoltar() {
		return voltar;
	}

	public final JTextField getCampo() {
		return campo;
	}

	public final JPanel getPainelSuperior() {
		return painelSuperior;
	}

	public final JPanel getPainelInferior() {
		return painelInferior;
	}

	public final JLabel getLabelComando() {
		return labelComando;
	}

	public final JLabel getLabelResultado() {
		return labelResultado;
	}
}