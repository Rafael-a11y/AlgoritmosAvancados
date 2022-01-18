

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BorderLayoutFrame extends JFrame implements ActionListener 
{
	private final JButton buttons[]; // Arranjo de botões para ocultar partes
	private  static final String[] names = {"Esconda-se ao norte", "Esconda-se ao Sul",
			"Esconda-se ao Leste", "Esconda-se ao Oeste", "Esconda-se ao Centro"};
	private final BorderLayout layout;
	
	// Configura GUI e tratamento de evento
	BorderLayoutFrame()
	{
		super("Demosntração de BorderLayout");
		
		this.layout = new BorderLayout(5, 5); // Espaço de 5 pixels
		this.setLayout(this.layout);
		this.buttons = new JButton[names.length];
		
		// Cria JButtons e registra ouvintes para ele
		for(int count = 0; count < names.length; count++)
		{
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
		}
		
		this.add(buttons[0], BorderLayout.NORTH);
		this.add(buttons[1], BorderLayout.SOUTH);
		this.add(buttons[2], BorderLayout.EAST);
		this.add(buttons[3], BorderLayout.WEST);
		this.add(buttons[4], BorderLayout.CENTER);
	}
	
	// Trata os eventos de botão
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Verifica a origiem do evento e o painel de conteúdo do layout de acordo
		for(JButton button : buttons)
		{
			if(event.getSource() == button)
				button.setVisible(false); // Oculta o botão que foi clicado
			else
				button.setVisible(true); // Mostra os outros botões
		}
		
		this.layout.layoutContainer(this.getContentPane()); // Define o layout do painel
	}
} // Fim da classe