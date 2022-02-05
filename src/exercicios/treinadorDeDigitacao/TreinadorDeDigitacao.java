package exercicios.treinadorDeDigitacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TreinadorDeDigitacao extends JFrame
{
	private final Box caixaVertical;
	private final Box caixaHorizontal;
	private final JTextArea areaDeTexto;
	private final JScrollPane barraDeRolagem;
	private final JLabel rotuloDeExplicacao;
	private final JLabel rotuloDeExplicacao2;
	private final Painel painel1, painel2, painel3, painel4, painel5;
	private final JPanel panel;
	
	public TreinadorDeDigitacao()
	{
		super("Treinador de Digitação");
		caixaVertical = Box.createVerticalBox();
		caixaHorizontal = Box.createHorizontalBox();
		areaDeTexto = new JTextArea(10, 10);
		barraDeRolagem = new JScrollPane(areaDeTexto);
		rotuloDeExplicacao = new JLabel(" Cada botão pressionado será destacado na tela"
				+ ", tendo sua cor mudada para vermelho.");
		rotuloDeExplicacao2 = new JLabel(" Obs: caso você tente usar o mouse"
				+ " para interagir com os botões, nenhuma funcionalidade será ativada.");
		painel1 = new Painel(new FlowLayout(), new String[] {"~", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "0", "-", "+", "Backspace"});
		painel2 = new Painel(new FlowLayout(), new String[] {"Tab", "Q", "W", "E", "R", "T",
				"Y", "U", "I", "O", "P", "[", "]", "/"});
		painel3 = new Painel(new FlowLayout(), new String[] {"Caps Lock", "A", "S", "D", "F",
				"G","H", "J", "K", "L", ":", "=", "Enter"});
		painel4 = new Painel(new FlowLayout(), new String[] {"Shift", "Z", "X", "C", "V", "B",
				"N", "M", ",", ".", "?", "Up"});
		painel5 = new Painel(new FlowLayout(), new String[] {"Space", "Left", "Down", "Right"});
		panel = new JPanel(new GridLayout(2, 1));
		organizarComponentes();
		iniciarGUI();
	}
	
	private void organizarComponentes()
	{
		panel.add(rotuloDeExplicacao);
		panel.add(rotuloDeExplicacao2);
		caixaVertical.add(panel);
		caixaVertical.setOpaque(true);
		caixaVertical.add(barraDeRolagem);
		caixaVertical.add(painel1);
		caixaVertical.add(painel2);
		caixaVertical.add(painel3);
		caixaVertical.add(painel4);
		caixaVertical.add(painel5);
		this.add(caixaVertical, BorderLayout.CENTER);
	}
	
	private void iniciarGUI()
	{
		setDefaultCloseOperation(TreinadorDeDigitacao.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(720, 380);
		setVisible(true);
	}
}
