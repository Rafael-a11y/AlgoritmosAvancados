import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame {

	private final JTextField textField; //Utilizado para exibir altera��es de fonte
	private final Font plainFont; //Fonte para texto simples
	private final Font boldFont; //Fonte para texto em negrito
	private final Font italicFont; //Fonte para texto em it�lico
	private final Font boldItalicFont; //Fonte para texto em negrito e it�lico
	private final JRadioButton plainJRadioButton; //Seleciona texto simples
	private final JRadioButton boldJRadioButton; //Seleciona texto em negrito
	private final JRadioButton italicJRadioButton; //Seleciona texto em it�lico
	private final JRadioButton boldItalicJRadioButton; //Seleciona texto em negrito e it�lico
	private final ButtonGroup radioGroup; //Cont�m bot�es de op��o
	
	//Construtor RadioButtonFrame adiciona JRadioButtons ao JFrame
	RadioButtonFrame(){
		
		super("Testando bot�o de op��o");
		this.setLayout(new FlowLayout());
		
		textField = new JTextField("Veja o estilo de fonte mudar", 25);
		this.add(textField); //Adiciona textField ao JFrame
		
		//Cria bot�es de op��o
		plainJRadioButton = new JRadioButton("Simples", true);
		boldJRadioButton = new JRadioButton("Negrito", false);
		italicJRadioButton = new JRadioButton("It�lico", false);
		boldItalicJRadioButton = new JRadioButton("Negrito/It�lico", false);
		this.add(plainJRadioButton); //Adiciona o bot�o de estilo simples ao JFrame
		this.add(boldJRadioButton); //Adiciona o bot�o de estilo negrito ao JFrame
		this.add(italicJRadioButton); //Adiciona o bot�o de estilo it�lico ao JFrame
		this.add(boldItalicJRadioButton); //Adiciona o bot�o de estilo negrito e it�lico ao JFrame
		
		//Cria relacionamentos l�gicos entre JRadioButtons
		radioGroup = new ButtonGroup(); //Cria ButtonGroup
		radioGroup.add(plainJRadioButton); //Adiciona texto simples ao grupo
		radioGroup.add(boldJRadioButton); //Adiciona negrito ao grupo
		radioGroup.add(italicJRadioButton); //Adiciona it�lico ao grupo
		radioGroup.add(boldItalicJRadioButton); //Adiciona negrito e it�lico ao grupo
		
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
	
	//Classe interna private para tratar eventos de bot�o de op��o
	private class RadioButtonHandler implements ItemListener{
		
		private Font font; //Fonte associada com este listener
		
		RadioButtonHandler(Font f){
			
			font = f;
		}
		
		//Trata eventos de bot�o de op��o
		@Override
		public void itemStateChanged(ItemEvent event) {
			
			textField.setFont(font);
		}
	}
} //Fim da classe RadioButtonFrame