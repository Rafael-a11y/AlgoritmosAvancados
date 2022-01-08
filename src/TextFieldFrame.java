import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame{

	private final JTextField textField1; //Campo de texto com tamanho configurado
	private final JTextField textField2; //Campo de texto com texto
	private final JTextField textField3; //Campo de tetxo com texto e tamanho
	private final JPasswordField passwordField; //Campo de senha com texto
	
	//Construtor TextFieldFrame adiciona JTextField's a JFrame
	TextFieldFrame(){
		
		super("Testando JTextField's e JPasswordField's");
		this.setLayout(new FlowLayout());
		
		//Cria campo de texto com 10 colunas
		textField1 = new JTextField(10);
		this.add(textField1); //Adiciona textField1 ao JFrame
		
		//Cria campo de texto com texto padrão
		textField2 = new JTextField("Entre com texto aqui");
		this.add(textField2); //Adiciona textField2 ao JFrame
		
		//Cria campo de texto com texto padrão e 21 colunas
		textField3 = new JTextField("Campo de texto não editável", 21);
		textField3.setEditable(false); //Desativa a edição
		this.add(textField3); //Adiciona textField3 ao JFrame
		
		//Cria campo de senha com texto padrão
		passwordField = new JPasswordField("Texto oculto");
		this.add(passwordField); //Adiciona o passwordField ao JFrame
		
		//Rotinas de tratamento de evento registradoras
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
	}
	
	//Classe interna private para tratamento de evento
	private class TextFieldHandler implements ActionListener{
		//Processa eventos de campo de texto
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String string = "";
			
			//Usuário pressionou ENTER no JTextField textField1
			if(event.getSource() == textField1)
			string = String.format("textField1: %s", textField1.getText());
			
			//Usuário pressionou ENTER no JTextField textField2
			else if(event.getSource() == textField2)
				string = String.format("textField2: %s", event.getActionCommand());
			
			//Usuário apertou ENTER no JTextField textField3
			else if(event.getSource() == textField3)
				string = String.format("textField3: %s", event.getActionCommand());
			
			//Usuário apertou ENTER no JPasswordField passwordField
			else if(event.getSource() == passwordField)
				string = String.format("passwordField: %s", event.getActionCommand());
				
			//Exibe o conteúdo de JTextField
			JOptionPane.showMessageDialog(null, string);
		}
	} //Fim da classe TextFieldHandler interna private
} //Fim da classe TextFieldFrame