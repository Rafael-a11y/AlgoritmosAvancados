package exercicios.conversor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Contêiner extends Container
{
	private final JButton voltar;
	private final JRadioButton radio1, radio2, radio3, radio4, radio5, radio6;
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
		this.radio3 = null;
		this.radio4 = null;
		this.radio5 = null;
		this.radio6 = null;
	}
	
	Contêiner(String decisao, String opcao1, String opcao2, String opcao3, String opcao4, String opcao5, String opcao6)
	{
		this.grupo = new ButtonGroup();
		this.radio1 = new JRadioButton(opcao1);
		this.radio2 = new JRadioButton(opcao2);
		this.radio3 = new JRadioButton(opcao3);
		this.radio4 = new JRadioButton(opcao4);
		this.radio5 = new JRadioButton(opcao5);
		this.radio6 = new JRadioButton(opcao6);
		this.grupo.add(radio1);
		this.grupo.add(radio2);
		this.grupo.add(radio3);
		this.grupo.add(radio4);
		this.grupo.add(radio5);
		this.grupo.add(radio6);
		
		this.labelComando = new JLabel(decisao);
		this.painelSuperior = new JPanel();
		this.painelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.painelInferior = new JPanel();
		this.painelInferior.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.setLayout(new BorderLayout());
		
		this.painelSuperior.add(labelComando);
		this.painelInferior.add(radio1);
		this.painelInferior.add(radio2);
		this.painelInferior.add(radio3);
		this.painelInferior.add(radio4);
		this.painelInferior.add(radio5);
		this.painelInferior.add(radio6);
		this.add(painelSuperior, BorderLayout.NORTH);
		this.add(painelInferior, BorderLayout.CENTER);
		
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
	
	public final JRadioButton getRadio1()
	{
		return this.radio1;
	}
	
	public final JRadioButton getRadio2()
	{
		return this.radio2;
	}
	
	public final JRadioButton getRadio3() {
		return radio3;
	}

	public final JRadioButton getRadio4() {
		return radio4;
	}

	public final JRadioButton getRadio5() {
		return radio5;
	}

	public final JRadioButton getRadio6() {
		return radio6;
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
	
	public final ButtonGroup getGrupo()
	{
		return this.grupo;
	}
}