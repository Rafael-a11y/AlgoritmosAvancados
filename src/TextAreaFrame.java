

import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrame extends JFrame
{
	private final JTextArea textArea1; // Exibe a String demonstrativa
	private final JTextArea textArea2; // Text destacado é copiado aqui
	private final JButton copyJButton; // Começa a copiar o texto
	
	// Construtor sem argumento
	TextAreaFrame()
	{
		super("Dermonstração de TextArea");
		Box box = Box.createHorizontalBox(); // Cria Box
		String demo = "Esta é uma sequência de demonsntração para\n" +
				"ilustrar a cópia de texto\nde uma área de texto para \n" +
				"outra área de texto usando um\nevento externo\n";
		
		this.textArea1 = new JTextArea(demo, 10, 15);
		this.textArea1.setLineWrap(true); // Para que a quebra de linha ocorra 	quando o texto chegar no canto da JtextArea
		box.add(new JScrollPane(textArea1)); // Adiciona o JScrollPane à box
		
		this.copyJButton = new JButton("Copiar >>>"); // Cria botão de cópia
		box.add(copyJButton); // Adiciona botão de cópia à box
		this.copyJButton.addActionListener(
				new ActionListener() // Classe interna anônima 
				{
					// Configura o texto em textArea2 como texto selecionado em textArea1
					@Override
					public void actionPerformed(ActionEvent event)
					{
						textArea2.setText(textArea1.getSelectedText());
					}
				}
			);
		
		this.textArea2 = new JTextArea(10, 15);
		this.textArea2.setLineWrap(true);
		this.textArea2.setEditable(false);
		box.add(new JScrollPane(textArea2)); // Adiciona JScrollPane com textArea2 ao box
		
		this.add(box); // Adiciona box ao JFrame
	}
} // Fim da classe