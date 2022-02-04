package exercicios.treinadorDeDigitacao;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class TreinadorDeDigitacao extends JFrame
{
	private final Box caixaVertical = Box.createVerticalBox();
	private final Box caixaHorizontal = Box.createHorizontalBox();
	private final JTextArea areaDeTexto = new JTextArea();
	private final JScrollPane barraDeRolagem = new JScrollPane(areaDeTexto);
	private final JLabel rotuloDeExplicacao = new JLabel("Use o seu teclado para inserir"
			+ " texto no campo de texto acima, cada bot„o pressionado ser· destacado na tela"
			+ ", tendo sua cor mudada para vermelho");
	private final JLabel rotuloDeExplicacao2 = new JLabel("Obs: caso voc  tente usar o mouse"
			+ "para interagir com os botıes, nenhuma funcionalidade ser· ativada.");
	private final JPanel painel1, painel2, painel3, painel4, painel5;
	
	public TreinadorDeDigitacao()
	{
		
	}
}
