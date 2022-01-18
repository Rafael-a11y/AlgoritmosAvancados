

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener
{
	private String line1 = ""; // Primeira linha da área de texto
	private String line2 = ""; // Segunda linha da área de texto
	private String line3 = ""; // Terceira linha da área de texto.
	private JTextArea textArea; // Área de texto para exibir a saída
	
	// Construtor KeyDemoFrame
	KeyDemoFrame()
	{
		super("Demonstrando evento de digitação");
		
		this.textArea = new JTextArea(10, 15); // Configura JTextArea
		this.textArea.setText("Pressione qualquer tecla do teclado");
		this.textArea.setEnabled(false);
		this.textArea.setDisabledTextColor(Color.BLACK);
		KeyDemoFrame.this.add(textArea); // Adiciona a área de texto ao JFrame
		
		this.addKeyListener(this); // Permite que o frame processe os eventos do teclado
	}
	
	// Trata pressionamento de qualquer tecla
	@Override
	public void keyPressed(KeyEvent event)
	{
		line1 = String.format("Tecla pressionada: %s",
				KeyEvent.getKeyText(event.getKeyCode())); // Mostra a tecla pressionada
		this.setLines2and3(event); // Configura a saída das linhas dois e três
	}
	
	// Trata liberação de qualquer tecla
	@Override
	public void keyReleased(KeyEvent event)
	{
		line1 = String.format("Tecla liberada: %s", 
				KeyEvent.getKeyText(event.getKeyCode())); // Mostra a tecla liberada
		setLines2and3(event); // Configura as saídas das linhas 2 e 3
	}
	
	// Trata pressionamento de uma tecla QUE NÃO SEJA DE AÇÃO
	@Override
	public void keyTyped(KeyEvent event)
	{
		line1 = String.format("Tecla digitada (não é de ação): %s", event.getKeyChar());
		setLines2and3(event); // Configura as saídas das linhas 2 e 3
	}
	
	 // Configura as saídas das linhas 2 e 3
	private void setLines2and3(KeyEvent event)
	{
		line2 = String.format("Esta tecla %s tecla de ação",
				event.isActionKey() ? "é uma" : "não é uma");
		
		String temp = KeyEvent.getKeyModifiersText(event.getModifiers());
		
		line3 = String.format("Tecla modificadoras pressionadas: %s",
				(temp.equals("") ? "nenhuma" : temp)); // modificadores de saída
		
		textArea.setText(String.format("%s\n%s\n%s\n", 
				line1, line2, line3)); //Gera saída de 3 linhas de texto
	}
} // Fim da classe KeyDemoFrame