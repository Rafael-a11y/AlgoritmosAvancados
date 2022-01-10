import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame{

	private final JComboBox<String> imagesJComboBox; //Cont�m nome de �cones;
	private final JLabel label; //Exibe o �cone selecionado
	
	private static final String[] names = 
		{"�cones\\png\\Caf� da manh� gr�tis 16.png", "�cones\\png\\Caneca de caf� 16.png",
				"�cones\\png\\Caneca rosa 16.png", "�cones\\png\\Gr�o de caf� 16.png"};
	private final Icon[] icons = {
			new ImageIcon(this.getClass().getResource(names[0])),
			new ImageIcon(this.getClass().getResource(names[1])),
			new ImageIcon(this.getClass().getResource(names[2])),
			new ImageIcon(this.getClass().getResource(names[3]))};
	
	//Construtor ComboBoxframe adiciona JComboBox ao JFrame
	ComboBoxFrame(){
		
		super("Testando caixa de combina��o");
		this.setLayout(new FlowLayout()); //Configura o layout de frame
		
		imagesJComboBox = new JComboBox<>(names); //Configura JComboBox
		imagesJComboBox.setMaximumRowCount(3); //Exibe tr�s linhas
		
		imagesJComboBox.addItemListener(
				new ItemListener() //Classe interna an�nima 
				{
					//Trata de evento JComboBox
					@Override
					public void itemStateChanged(ItemEvent event) {
						
						//Determina se o item est� selecionado
						if(event.getStateChange() == ItemEvent.SELECTED)
							label.setIcon(
									icons[imagesJComboBox.getSelectedIndex()]);
					}
				} //Fim da classe interna an�nima
			); //Fim da chamada para addItemListener(ItemListener listener)
		
		this.add(imagesJComboBox); //Adiciona imagesJComboBox ao JFrame
		this.label = new JLabel(icons[0]); //Exibe o primeiro �cone
		this.add(label); //Adiciona o label ao JFrame
	}
} //Fim da classe ComboBoxFrame