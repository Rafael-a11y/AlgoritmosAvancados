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
		System.out.printf("keyPressed: %s\n", KeyEvent.KEY_PRESSED);
		System.out.printf("keyPressed: %s\n", KeyEvent.getKeyText(e.getKeyCode()));
		String codigo = KeyEvent.getKeyText(e.getKeyCode());
		
		for(int count = 0; count < janela.getPaineis().size(); count ++)
			for(int countI = 0; countI < janela.getPaineis().get(count).getBotoes().size(); countI++)
				janela.getPaineis().get(count).getBotoes().get(countI).setBackground(Color.WHITE);
		
		for(int countPaineis = 0; countPaineis < janela.getPaineis().size(); countPaineis++)
		{
			for(int countBotoes = 0; countBotoes < janela.getPaineis().get(countPaineis).getBotoes().size(); countBotoes++)
			{
				if(janela.getPaineis().get(countPaineis).getBotoes().get(countBotoes).getCodigoChave().equalsIgnoreCase(codigo))
				{
					janela.getPaineis().get(countPaineis).getBotoes().get(countBotoes).setBackground(Color.ORANGE);
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
	}
	
}
 