package exercicios.treinadorDeDigitacao;

import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Manipulador implements KeyListener
{
	
	private final TreinadorDeDigitacao janela;
	
	public Manipulador(TreinadorDeDigitacao janela)
	{
		this.janela = janela;
		this.janela.getAreaDeTexto().addKeyListener(this);
	}
	

	@Override
	public void keyPressed(KeyEvent e) 
	{
		System.out.printf("keyPressed -> KEY_PRESSED: %s\n", KeyEvent.KEY_PRESSED);
		System.out.printf("keyPressed -> keycode: %s\n", KeyEvent.getKeyText(e.getKeyCode()));
		System.out.println("keyPressed -> keyChar: " + e.getKeyChar() );
		if(KeyEvent.getKeyText(e.getKeyCode()) == "Dead Tilde")
		{
			e.setKeyChar('~');
		}
		
		for(int countPaineis = 0; countPaineis < janela.getPaineis().size(); countPaineis++)
		{
			for(int countBotoes = 0; countBotoes < janela.getPaineis().get(countPaineis)
					.getBotoes().size(); countBotoes++)
			{
				if(janela.getPaineis().get(countPaineis).getBotoes().get(countBotoes)
						.getText().equalsIgnoreCase(KeyEvent.getKeyText(e.getKeyCode()))
						|| janela.getPaineis().get(countPaineis).getBotoes().get(countBotoes)
						.getText().equalsIgnoreCase(String.valueOf(e.getKeyChar())))
				{
					janela.getPaineis().get(countPaineis).getBotoes().get(countBotoes)
					.setBackground(Color.ORANGE);
					return;
				}
				
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased");
		System.out.println("-----------------------------------------------");
		for(int countPaineis = 0; countPaineis < janela.getPaineis().size(); countPaineis++)
		{
			for(int countBotoes = 0; countBotoes < janela.getPaineis().get(countPaineis)
					.getBotoes().size(); countBotoes++)
			{
				if(janela.getPaineis().get(countPaineis).getBotoes().get(countBotoes)
						.getText().equalsIgnoreCase(KeyEvent.getKeyText(e.getKeyCode())) 
						|| janela.getPaineis().get(countPaineis).getBotoes().get(countBotoes)
						.getText().equalsIgnoreCase(String.valueOf(e.getKeyChar())))
				{
					janela.getPaineis().get(countPaineis).getBotoes().get(countBotoes)
					.setBackground(Color.WHITE);
					return;
				}
			}
	
		}
	}
}
 