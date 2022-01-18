

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelFrame extends JFrame 
{
	private final JPanel buttonJPanel; // Painél para armazenar botões
	private final JButton buttons[];
	
	// Construtor sem argumento
	PanelFrame()
	{
		super("Demosntração de Painél");
		this.buttons = new JButton[5];
		this.buttonJPanel = new JPanel();
		this.buttonJPanel.setLayout(new GridLayout(1, buttons.length));
		
		// Cria e adiciona botões
		for(int count = 0; count < buttons.length; count++)
		{
			this.buttons[count] = new JButton("Botão " + (count + 1));
			this.buttonJPanel.add(buttons[count]); // Adiciona o botão ao JFrame
		}
		
		this.add(buttonJPanel, BorderLayout.SOUTH);
	}
} // Fim da classe