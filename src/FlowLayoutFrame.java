

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class FlowLayoutFrame extends JFrame
{
	private final JButton leftJButton; // Bot�o para configurar alinhamento a esquerda
	private final JButton centerJButton; // Bot�o para configurar alinhamento centralizado
	private final JButton rightJButton; // Bot�o para configurar alinhamento a direita.
	private final FlowLayout layout; // Objeto de layout
	private final Container container; // Container para configurar layout.
	
	// Configura GUI e registra listeners de bot�o
	FlowLayoutFrame()
	{
		super("Demo de FlowLayout");
		
		this.layout = new FlowLayout();
		this.container = getContentPane(); // Obt�m cont�iner para layout
		this.setLayout(layout);
		
		// Configura leftJButton
		this.leftJButton = new JButton("Esquerda");
		this.add(leftJButton); // Adiciona leftJButton ao JFrame
		this.leftJButton.addActionListener(
				new ActionListener() // Classe interna an�nima
				{
					// Processa o evento de leftJButton
					@Override
					public void actionPerformed(ActionEvent event)
					{
						FlowLayoutFrame.this.layout.setAlignment(FlowLayout.LEFT);
						
						// Realinha os componentes anexados
						FlowLayoutFrame.this.layout.layoutContainer(container);
					}
				}
			);
		
		// Configura centerJButton e configura o listener
		this.centerJButton = new JButton("Centro");
		this.add(centerJButton); // Adiciona o bot�o center ao JFrame
		this.centerJButton.addActionListener(
				new ActionListener() // Classe interna an�nima
				{
					// Processa evento centerJButton
					@Override
					public void actionPerformed(ActionEvent event)
					{
						FlowLayoutFrame.this.layout.setAlignment(FlowLayout.CENTER);
						
						// Realinha os componentes anexados
						FlowLayoutFrame.this.layout.layoutContainer(container);
					}
				}
			);
		
		// Configura rightJButton e registra o listener
		this.rightJButton = new JButton("Direita");
		this.add(rightJButton); // Adiciona o bot�o right ao JFrame
		this.rightJButton.addActionListener(
				new ActionListener() // Classe interna an�nima
				{
					// Processa evento rightJButton
					@Override
					public void actionPerformed(ActionEvent event)
					{
						FlowLayoutFrame.this.layout.setAlignment(FlowLayout.RIGHT);
						
						// Realinha os componentes anexados
						FlowLayoutFrame.this.layout.layoutContainer(container);
					}
				}
			);
	} // Fim do construtor
} // Fim da classe