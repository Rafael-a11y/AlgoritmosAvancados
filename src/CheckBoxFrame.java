import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame{

	private final JTextField textField; //Exibe o texto na alteração de fontes
	private final JCheckBox boldJCheckBox; //Para marcar/desmarcar estilo negrito
	private final JCheckBox italicJCheckBox; //Para marcar/desmarcar estilo itálico
	
	//Construtor CheckBoxFrame
	CheckBoxFrame(){
		
		super("Testando caixa de seleção");
		this.setLayout(new FlowLayout());
		
		//Configura JTextField e sua fonte
		textField = new JTextField("Veja a mudança de estilo de fonte", 20);
		textField.setFont(new Font("serif", Font.PLAIN, 14));
		this.add(textField); //Adiciona o textField ao JFrame
		
		boldJCheckBox = new JCheckBox("Negrito");
		italicJCheckBox = new JCheckBox("Itálico");
		this.add(boldJCheckBox); //Adiciona boldJCheckBox ao JFrame
		this.add(italicJCheckBox); //Adiciona italicJCheckBox ao JFrame;
		
		//Listeners registradores para JCheckBoxes
		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener(handler);
		italicJCheckBox.addItemListener(handler);
	}
	
	//Classe interna private para tratamento de evento ItemListener
	private class CheckBoxHandler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent event) {
			
			Font font = null; //Armazena a nova fonte
			
			//Determina quais CheckBoxes estão marcadas e cria Font
			if(boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
				font = new Font("serif", Font.BOLD + Font.ITALIC, 14);
			else if(boldJCheckBox.isSelected())
				font = new Font("serif", Font.BOLD, 14);
			else if(italicJCheckBox.isSelected())
				font = new Font("serif", Font.ITALIC, 14);
			else
				font = new Font("serif", Font.PLAIN, 14);
			
			textField.setFont(font);
		}
	}
} //Fim da clase CheckBoxFrame