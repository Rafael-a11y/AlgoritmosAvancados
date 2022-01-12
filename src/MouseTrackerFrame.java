// Figura 12.28: MouseTrackerFrame.java
// Tratamento de evento de mouse
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame
{
	private final JPanel mousePanel; // Pain�l em que os eventos de mouse ocorrem
	private final JLabel statusBar; // Exibe informa��es do evento.
	
	// Construtor MouseTrackerFrame configura a GUI e
	// registra rotinas de tratamento de evento de mouse
	MouseTrackerFrame()
	{
		super("Demonstrando eventos de mouse");
		
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		MouseTrackerFrame.this.add(mousePanel, BorderLayout.CENTER); // Adiciona JPanel ao JFrame.
		
		statusBar = new JLabel("Pain�l externo do mouse");
		MouseTrackerFrame.this.add(statusBar, BorderLayout.SOUTH); // Adiciona r�tulo ao JFrame
		
		// Cria e registra listener para mouse e eventos de movimento de mouse
		MouseHandler handler = new MouseHandler();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	}
	
	private class MouseHandler implements MouseListener,
		MouseMotionListener
		{
			// Rotinas de tratamento de evento MouseListener
			// Trata evento quando o mouse � liberado imediatamente depois de ter sido pressionado.
			@Override
			public void mouseClicked(MouseEvent event)
			{
				statusBar.setText(String.format("Clicado em [%d, %d]",
						event.getX(), event.getY()));
			}
			
			// Trata evento quando mouse � pressionado
			@Override
			public void mousePressed(MouseEvent event)
			{
				statusBar.setText(String.format("Pressionado em [%d, %d]", 
						event.getX(), event.getY()));
			}
			
			// Trata o evento quando o mouse � liberado.
			@Override
			public void mouseReleased(MouseEvent event)
			{
				statusBar.setText(String.format("Liberado em [%d, %d]", 
						event.getX(), event.getY()));
			}
			
			// Trata evento quando o mouse entra na �rea
			@Override
			public void mouseEntered(MouseEvent event)
			{
				statusBar.setText(String.format("Mouse entrou em [%d, %d]",
						event.getX(), event.getY()));
				mousePanel.setBackground(Color.GREEN);
				System.out.println(String.format("Mouse entrou em [%d, %d]", event.getX(),
						event.getY()));
			}
			
			// Trata evento quando o mouse sai da �rea
			@Override
			public void mouseExited(MouseEvent event)
			{
				statusBar.setText("Mouse fora do pain�l.");
				mousePanel.setBackground(Color.WHITE);
			}
			
			// Rotinas de tratamento de evento MouseMotionListener
			// Trata o evento quando o usu�rio arrasta o mouse com o bot�o pressionado
			@Override
			public void mouseDragged(MouseEvent event)
			{
				statusBar.setText(String.format("Arrastado em [%d, %d]", 
						event.getX(), event.getY()));
			}
			
			// Trata evento quando o usu�rio move o mouse.
			@Override
			public void mouseMoved(MouseEvent event)
			{
				statusBar.setText(String.format("Movido em [%d, %d]", 
						event.getX(), event.getY()));
			}
		} // Fim da classe interna MouseHandler
} // Fim da classe MouseTrackerFrame