

import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintPanel extends JPanel
{
	// Lista das referências Point
	private final ArrayList<Point> points = new ArrayList<>();
	
	// Configura GUI e registra rotinas de tratamento de evento de mouse
	PaintPanel()
	{
		
		// Trata evento de movimento do mouse do Frame
		PaintPanel.this.addMouseMotionListener(
				new MouseMotionAdapter() //Classe interna anônima
				{
					// Armazena as coordenadas da ação de arrastar e pinta
					@Override
					public void mouseDragged(MouseEvent event)
					{
						PaintPanel.this.points.add(event.getPoint());
						PaintPanel.this.repaint(); // Repinta JFrame
					}
				}
			);
	}
	
	// Desenha ovais em um quadro delimitador de 4 x 4 nas localizações especificadas na janela
	@Override
	public void paintComponent(Graphics g)
	{
		PaintPanel.super.paintComponent(g); // Limpa a área de desenho
		
		// Desenha todos os pontos
		for(Point point : points)
			g.fillOval(point.x, point.y, 4, 4);
	}
} // Fim da classe