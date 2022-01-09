import java.awt.FlowLayout; //Especifica como os componentes s�o organizados
import javax.swing.JFrame; //Fornece recursos b�sicos de janela
import javax.swing.JLabel; //Exibe texto e imagens
import javax.swing.SwingConstants; //Constantes comuns utilizadas com swing
import javax.swing.Icon; //Interface utilizada para manipular imagens
import javax.swing.ImageIcon; // Carrega imagens

public class LabelFrame extends JFrame{

	private final JLabel label1; //Etiqueta apenas com texto
	private final JLabel label2; //Etiqueta constru�da com texto e �cone
	private final JLabel label3; //Etiqueta com texto e �cone adicionados 
	
	//Construtor LabelFrame, adiciona as etiquetas ao JFrame
	LabelFrame() {
		super("Testando os JLabel's");
		this.setLayout(new FlowLayout()); //Configura o layout de frame.
		
		//Construtor JLabel com um argumento de string
		label1 = new JLabel("Etiqueta com texto");
		label1.setToolTipText("Isto � a etiqueta1");
		this.add(label1); //Adiciona o label1 ao JFrame
		
		//Construtor JLabel com string, Icon e argumentos de alinhamento
		Icon bug = new ImageIcon(getClass().getResource("�cones\\png\\bug1.png"));
		label2 = new JLabel("Etiqueta com texto e imagem", bug, SwingConstants.LEFT);
		label2.setToolTipText("Isto � a etiqueta2");
		this.add(label2); //Adiciona o label2 ao JFrame
		
		//Construtor JLabel sem argumentos
		label3 = new JLabel();
		label3.setText("Etiqueta com imagem e texto na parte inferior");
		label3.setIcon(bug); //Adiciona o �cone ao JLabel
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("Isto � a etiqueta3");
		this.add(label3);
	}
} //Fim da classe LabelFrame
