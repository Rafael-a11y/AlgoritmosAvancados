package exercicios.treinadorDeDigitacao;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.util.List;
import java.util.ArrayList;

public class Caixa extends Box
{
	
	private final List<Painel> paineis;
	
	public Caixa()
	{
		super(BoxLayout.Y_AXIS);
		paineis = new ArrayList<>();
	}
	
	
}
