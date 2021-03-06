package exercicios.treinadorDeDigitacao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Painel extends JPanel 
{
	private final List<Botao> botoes;
	
	public Painel(LayoutManager layout, String[] arrayDeNomes, String[] arrayDeIdentificadores)
	{
		setLayout(layout);
		botoes = new ArrayList<>();
		criarBotoes(arrayDeNomes, arrayDeIdentificadores);
	}
	
	public Painel(LayoutManager layout, String texto, String id, int pixelsHorizontais)
	{
		botoes = new ArrayList<>();
		Botao botao = new Botao(texto, id);
		botao.setPreferredSize(new Dimension(pixelsHorizontais, 26));
		setLayout(layout);
		botoes.add(botao);
		add(botao);
	}
	
	private void criarBotoes(String[] arrayDeNomes, String[] arrayDeIdentificadores)
	{
		for(int count = 0; count < arrayDeNomes.length; count++)
		{	
			botoes.add(new Botao(arrayDeNomes[count], arrayDeIdentificadores[count]));
			botoes.get(count).setBackground(Color.WHITE);
			add(botoes.get(count));
		}
		
	}
	
	public void alterarTamanhoHorizontalDoBotao(String texto, int pixelsHorizontais)
	{
		for(int count = 0; count < getComponentCount(); count ++)
		{
			if(botoes.get(count).getText().equalsIgnoreCase(texto))
			{
				botoes.get(count).setPreferredSize(new Dimension(pixelsHorizontais, 26));
				return;
			}
		}
	}
	
	public final List<Botao> getBotoes()
	{
		return botoes;
	}
}