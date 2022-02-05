package exercicios.treinadorDeDigitacao;

import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;
import java.awt.LayoutManager;

public class Painel extends JPanel 
{
	private final List<Botao> botoes;
	
	public Painel(LayoutManager layout, String[] arrayDeNomes)
	{
		setLayout(layout);
		botoes = new ArrayList<>();
		criarBotoes(arrayDeNomes);
	}
	
	private void criarBotoes(String[] arrayNomes)
	{
		for(int count = 0; count < arrayNomes.length; count++)
		{
			botoes.add(new Botao(arrayNomes[count]));
			add(botoes.get(count));
		}
	}
	
	public List<Botao> getBotoes()
	{
		return botoes;
	}
}