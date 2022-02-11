package exercicios.treinadorDeDigitacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class TreinadorDeDigitacao extends JFrame
{
	private final Box caixaVertical;
	private final Box caixaHorizontal;
	private final JTextArea areaDeTexto;
	private final JScrollPane barraDeRolagem;
	private final JLabel rotuloDeExplicacao;
	private final JLabel rotuloDeExplicacao2;
	private final Painel painel1, painel2, painel3, painel4, painel5, painel6;
	private final JPanel panel;
	private final List<Painel> paineis;
	private final Manipulador manipulador;
	
	public TreinadorDeDigitacao()
	{
		super("Treinador de Digitação");
		paineis = new ArrayList<>();
		caixaVertical = Box.createVerticalBox();
		caixaHorizontal = Box.createHorizontalBox();
		areaDeTexto = new JTextArea(10, 10);
		barraDeRolagem = new JScrollPane(areaDeTexto);
		rotuloDeExplicacao = new JLabel(" Cada botão pressionado será destacado na tela"
				+ ", tendo sua cor mudada para laranja.");
		rotuloDeExplicacao2 = new JLabel(" Obs: caso você tente usar o mouse"
				+ " para interagir com os botões, nenhuma funcionalidade será ativada.");
		painel1 = new Painel(new FlowLayout(FlowLayout.LEFT), new String[] {"\'", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "0", "-", "=", "Backspace"}, new String[] {"Quote", "1", "2", "3", "4", "5", "6", "7", "8",
						"9", "0", "Minus", "Equals", "Backspace"});
		painel2 = new Painel(new FlowLayout(FlowLayout.LEFT), new String[] {"Tab", "Q", "W", "E", "R", "T",
				"Y", "U", "I", "O", "P", "[", "]", "\\"}, new String[] {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O",
						"P", "Open Bracket", "Close Bracket", "Back Slash"});
		painel3 = new Painel(new FlowLayout(FlowLayout.LEFT), new String[] {"Caps Lock", "A", "S", "D", "F",
				"G","H", "J", "K", "L", "Ç", "~", "Enter"},new String[] {"Caps Lock", "A", "S", "D", "F", "G", "H", "J",
						"K", "L", "Unknown keyCode: 0x0", "Dead Tilde", "Enter"});
		painel4 = new Painel(new FlowLayout(FlowLayout.LEFT), new String[] {"Shift", "Z", "X", "C", "V", "B",
				"N", "M", ",", ".", ";", "^"}, new String[] {"Shift", "Z", "X", "C", "V","B", "N", "M", "Comma", "Period",
			"Semicolon", "Up"});
		painel5 = new Painel(new FlowLayout(FlowLayout.RIGHT, 62, 0), new String[] {"Space"}, new String[] {"Space"});
		painel6 = new Painel(new FlowLayout(FlowLayout.RIGHT), new String[] {"<", "Down", ">"}, new String[] {"Left", "Down",
				"Right"});
		painel5.alterarTamanhoHorizontalDoBotao("Space", 245);
		painel5.add(painel6);
		panel = new JPanel(new GridLayout(2, 1));
		manipulador = new Manipulador(this);
		adicionarPaineisALista();
		organizarComponentes();
		iniciarGUI();
	}
	
	private void adicionarPaineisALista()
	{
		paineis.add(painel1);
		paineis.add(painel2);
		paineis.add(painel3);
		paineis.add(painel4);
		paineis.add(painel5);
		paineis.add(painel6);
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
		setSize(710, 350);
		setBackground(Color.WHITE);
		
		setVisible(true);
	}

	public final Painel getPainel1() {
		return painel1;
	}

	public final Painel getPainel2() {
		return painel2;
	}

	public final Painel getPainel3() {
		return painel3;
	}

	public final Painel getPainel4() {
		return painel4;
	}

	public final Painel getPainel5() {
		return painel5;
	}

	public final Painel getPainel6() {
		return painel6;
	}
	
	
	public final List<Painel> getPaineis()
	{
		return paineis;
	}
	
	public JTextArea getAreaDeTexto()
	{
		return areaDeTexto;
	}
	
}
