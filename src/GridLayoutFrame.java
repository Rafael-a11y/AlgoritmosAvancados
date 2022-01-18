

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GridLayoutFrame extends JFrame implements ActionListener
{
	private final JButton buttons[]; // Arranjo de bot�es
	private static final String[] names = {
			"Um", "Dois", "Tr�s", "Quatro", "Cinco", "Seis"};
	private boolean toggle = true; // Alterna entre dois layouts;
	private final Container container; // Container do frame
	private final GridLayout gridLayout1; // Primeiro GridLayout;
	private final GridLayout gridLayout2; // Segundo GridLayout
	
	// Construtor sem argumento
	GridLayoutFrame()
	{
		super("Demonstra��o de GridLayout");
		this.gridLayout1 = new GridLayout(2, 3, 5, 5); // 2 linhas 3 colunas, lacunas de 5 por 5
		this.gridLayout2 = new GridLayout(3, 2); // 3 linhas e 2 colunas, sem v�o entre as c�lulas
		this.container = this.getContentPane();
		this.setLayout(gridLayout1);
		this.buttons = new JButton[names.length];
		
		for(int count = 0; count < names.length; count++)
		{
			this.buttons[count] = new JButton(names[count]);
			this.buttons[count].addActionListener(this); // Ouvinte registrado
			this.add(buttons[count]); // Adiicona o bot�o ao JFrame
		}
	}
	
	// Trata eventos de bot�o alternando entre layouts
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(toggle) // Define layout com base nos bot�es de alterna��o
			this.container.setLayout(gridLayout2);
		else
			this.container.setLayout(gridLayout1);
		
		this.toggle = !toggle;
		this.container.validate(); // Refaz o layout do container
	}
} // Fim da classe