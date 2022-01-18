

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelFrame extends JFrame 
{
	private final JPanel buttonJPanel; // Pain�l para armazenar bot�es
	private final JButton buttons[];
	
	// Construtor sem argumento
	PanelFrame()
	{
		super("Demosntra��o de Pain�l");
		this.buttons = new JButton[5];
		this.buttonJPanel = new JPanel();
		this.buttonJPanel.setLayout(new GridLayout(1, buttons.length));
		
		// Cria e adiciona bot�es
		for(int count = 0; count < buttons.length; count++)
		{
			this.buttons[count] = new JButton("Bot�o " + (count + 1));
			this.buttonJPanel.add(buttons[count]); // Adiciona o bot�o ao JFrame
		}
		
		this.add(buttonJPanel, BorderLayout.SOUTH);
	}
} // Fim da classe