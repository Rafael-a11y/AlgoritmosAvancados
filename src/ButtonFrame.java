import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame{

	private final JButton playnJButton; //Bot�o apenas com texto
	private final JButton fancyJButton; //Bot�o com �cones
	
	//ButtonFrame adiciona JButtons ao JFrame
	ButtonFrame(){
		
		super("Testando bot�es");
		this.setLayout(new FlowLayout());
		
		playnJButton = new JButton("Bot�o simples"); //Bot�o com texto
		this.add(playnJButton); //Adiciona playnJButton ao JFrame
		
		Icon bug1 = new ImageIcon(ButtonFrame.this.getClass().getResource("\\�cones\\png\\coffee16.png"));
		Icon bug2 = new ImageIcon(ButtonFrame.this.getClass().getResource("\\�cones\\png\\java_icon16.png"));
		fancyJButton = new JButton("Bot�o extravagante", bug1); //Configura imagem
		fancyJButton.setRolloverIcon(bug2); //Configura imagem de Rollover
		this.add(fancyJButton); //Adiciona fancyJButton ao JFrame
		
		//Cria novo ButtonHandler de tratamento para tratamento de evento de bot�o
		ButtonHandler handler = new ButtonHandler();
		fancyJButton.addActionListener(handler);
		playnJButton.addActionListener(handler);
	}
	
	//Classe interna para tratamento de evento do bot�o
	private class ButtonHandler implements ActionListener{

		//Trata evento de bot�o
		@Override
		public void actionPerformed(ActionEvent event) {
			
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
					"Voc� pressionou: %s", event.getActionCommand()));
		}
	}
} //Fim da classe ButtonFrame