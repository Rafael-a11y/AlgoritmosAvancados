

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Painter 
{
	public static void main(String[] args) 
	{
		// Cria o JFrame
		JFrame aplicacao = new JFrame("Um simples programa de pintura");
		
		PaintPanel paintPanel = new PaintPanel();
		aplicacao.add(paintPanel, BorderLayout.CENTER);
		
		// Cria um rótulo e o coloca em SOUTH em BorderLayout
		aplicacao.add(new JLabel("Arraste o mouse para desenhar"),
				BorderLayout.SOUTH);
		
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicacao.setSize(400, 200);
		aplicacao.setVisible(true);
	}
} // Fim da classe Painter.