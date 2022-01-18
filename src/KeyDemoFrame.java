

import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener
{
	private String line1 = ""; // Primeira linha da �rea de texto
	private String line2 = ""; // Segunda linha da �rea de texto
	private String line3 = ""; // Terceira linha da �rea de texto.
	private JTextArea textArea; // �rea de texto para exibir a sa�da
	
	// Construtor KeyDemoFrame
	KeyDemoFrame()
	{
		super("Demonstrando evento de digita��o");
		
		this.textArea = new JTextArea(10, 15); // Configura JTextArea
		this.textArea.setText("Pressione qualquer tecla do teclado");
		this.textArea.setEnabled(false);
		this.textArea.setDisabledTextColor(Color.BLACK);
		KeyDemoFrame.this.add(textArea); // Adiciona a �rea de texto ao JFrame
		
		this.addKeyListener(this); // Permite que o frame processe os eventos do teclado
	}
	
	// Trata pressionamento de qualquer tecla
	@Override
	public void keyPressed(KeyEvent event)
	{
		line1 = String.format("Tecla pressionada: %s",
				KeyEvent.getKeyText(event.getKeyCode())); // Mostra a tecla pressionada
		this.setLines2and3(event); // Configura a sa�da das linhas dois e tr�s
	}
	
	// Trata libera��o de qualquer tecla
	@Override
	public void keyReleased(KeyEvent event)
	{
		line1 = String.format("Tecla liberada: %s", 
				KeyEvent.getKeyText(event.getKeyCode())); // Mostra a tecla liberada
		setLines2and3(event); // Configura as sa�das das linhas 2 e 3
	}
	
	// Trata pressionamento de uma tecla QUE N�O SEJA DE A��O
	@Override
	public void keyTyped(KeyEvent event)
	{
		line1 = String.format("Tecla digitada (n�o � de a��o): %s", event.getKeyChar());
		setLines2and3(event); // Configura as sa�das das linhas 2 e 3
	}
	
	 // Configura as sa�das das linhas 2 e 3
	private void setLines2and3(KeyEvent event)
	{
		line2 = String.format("Esta tecla %s tecla de a��o",
				event.isActionKey() ? "� uma" : "n�o � uma");
		
		String temp = KeyEvent.getKeyModifiersText(event.getModifiers());
		
		line3 = String.format("Tecla modificadoras pressionadas: %s",
				(temp.equals("") ? "nenhuma" : temp)); // modificadores de sa�da
		
		textArea.setText(String.format("%s\n%s\n%s\n", 
				line1, line2, line3)); //Gera sa�da de 3 linhas de texto
	}
} // Fim da classe KeyDemoFrame