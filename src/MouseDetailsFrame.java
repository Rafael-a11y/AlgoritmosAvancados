// Figura 12.31: MouseDetailsFrame.java
// Demosntrando cliques de mouse e distinguindo entre botões do mouse.
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseDetailsFrame extends JFrame
{
	private String details; // String exibida na statusBar.
	private final JLabel statusBar;
	
	// Construtor configura String de barra de título e registra o listener de mouse
	MouseDetailsFrame()
	{
		super("Cliques e botões do mouse");
		
		statusBar = new JLabel("Clique no mouse");
		MouseDetailsFrame.this.add(statusBar, BorderLayout.SOUTH);
		MouseDetailsFrame.this.addMouseListener(new MouseClickHandler()); // Adiciona tratamento de eventos
	}
	
	// Classe interna para tratar eventos de mouse
	private class MouseClickHandler extends MouseAdapter
	{
		// Trata evento de clique de mouse e determina qual botão foi pressionado
		@Override
		public void mouseClicked(MouseEvent event)
		{
			int xPos = event.getX(); // Obtêm a coordenada x do mouse
			int yPos = event.getY(); // Obtêm a coordenada y do mouse
			
			details = String.format("Clicado %d vezes", 
					event.getClickCount());
			
			if(event.isMetaDown()) // Botão direito do mouse
			{
				details += " com botão direito do mouse";
			}
				
			else if(event.isAltDown()) // Botão do meio do mouse
			{
				details += " com botão central do mouse";
			}
				
			else // Botão esquerdo do mouse
			{
				details += " com botão esquerdo do mouse";
			}
				
			MouseDetailsFrame.this.statusBar.setText(details); // Exibe mensagem em statusBar
		}
	}
} // Fim da classe MouseDetailsFrame