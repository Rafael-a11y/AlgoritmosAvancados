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
		adicionarOuvintes();
	}
	
	private void adicionarOuvintes()
	{
		for(int count = 0; count < janela.getPaineis().size(); count ++)
		{
			janela.getPaineis().get(count).addKeyListener(this);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		System.out.printf("keyPressed: %s\n", KeyEvent.KEY_PRESSED);
		System.out.printf("keyPressed: %s\n", KeyEvent.getKeyText(e.getKeyCode()));
		String codigo = KeyEvent.getKeyText(e.getKeyCode());
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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
