import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame {

	private final JTextField textField; //Utilizado para exibir alterações de fonte
	private final Font plainFont; //Fonte para texto simples
	private final Font boldFont; //Fonte para texto em negrito
	private final Font italicFont; //Fonte para texto em itálico
	private final Font boldItalicFont; //Fonte para texto em negrito e itálico
	private final JRadioButton plainJRadioButton; //Seleciona texto simples
	private final JRadioButton boldJRadioButton; //Seleciona texto em negrito
	private final JRadioButton italicJRadioButton; //Seleciona texto em itálico
	private final JRadioButton boldItalicJRadioButton; //Seleciona texto em negrito e itálico
	private final ButtonGroup radioGroup; //Contém botões de opção
	
	//Construtor RadioButtonFrame adiciona JRadioButtons ao JFrame
	RadioButtonFrame(){
		
		super("Testando botão de opção");
		this.setLayout(new FlowLayout());
		
		textField = new JTextField("Veja o estilo de fonte mudar", 25);
		this.add(textField); //Adiciona textField ao JFrame
		
		//Cria botões de opção
		plainJRadioButton = new JRadioButton("Simples", true);
		boldJRadioButton = new JRadioButton("Negrito", false);
		italicJRadioButton = new JRadioButton("Itálico", false);
		boldItalicJRadioButton = new JRadioButton("Negrito/Itálico", false);
		this.add(plainJRadioButton); //Adiciona o botão de estilo simples ao JFrame
		this.add(boldJRadioButton); //Adiciona o botão de estilo negrito ao JFrame
		this.add(italicJRadioButton); //Adiciona o botão de estilo itálico ao JFrame
		this.add(boldItalicJRadioButton); //Adiciona o botão de estilo negrito e itálico ao JFrame
		
		//Cria relacionamentos lógicos entre JRadioButtons
		radioGroup = new ButtonGroup(); //Cria ButtonGroup
		radioGroup.add(plainJRadioButton); //Adiciona texto simples ao grupo
		radioGroup.add(boldJRadioButton); //Adiciona negrito ao grupo
		radioGroup.add(italicJRadioButton); //Adiciona itálico ao grupo
		radioGroup.add(boldItalicJRadioButton); //Adiciona negrito e itálico ao grupo
		
		//Cria objetos de fonte
		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		textField.setFont(plainFont);
		
		//Registra eventos para JRadioButtons
		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));
	}
	
	//Classe interna private para tratar eventos de botão de opção
	private class RadioButtonHandler implements ItemListener{
		
		private Font font; //Fonte associada com este listener
		
		RadioButtonHandler(Font f){
			
			font = f;
		}
		
		//Trata eventos de botão de opção
		@Override
		public void itemStateChanged(ItemEvent event) {
			
			textField.setFont(font);
		}
	}
} //Fim da classe RadioButtonFrame