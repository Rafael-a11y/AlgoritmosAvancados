

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
	private final JTextArea textArea2; // Text destacado � copiado aqui
	private final JButton copyJButton; // Come�a a copiar o texto
	
	// Construtor sem argumento
	TextAreaFrame()
	{
		super("Dermonstra��o de TextArea");
		Box box = Box.createHorizontalBox(); // Cria Box
		String demo = "Esta � uma sequ�ncia de demonsntra��o para\n" +
				"ilustrar a c�pia de texto\nde uma �rea de texto para \n" +
				"outra �rea de texto usando um\nevento externo\n";
		
		this.textArea1 = new JTextArea(demo, 10, 15);
		this.textArea1.setLineWrap(true); // Para que a quebra de linha ocorra 	quando o texto chegar no canto da JtextArea
		box.add(new JScrollPane(textArea1)); // Adiciona o JScrollPane � box
		
		this.copyJButton = new JButton("Copiar >>>"); // Cria bot�o de c�pia
		box.add(copyJButton); // Adiciona bot�o de c�pia � box
		this.copyJButton.addActionListener(
				new ActionListener() // Classe interna an�nima 
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