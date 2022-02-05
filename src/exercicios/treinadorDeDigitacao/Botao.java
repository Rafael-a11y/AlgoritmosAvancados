package exercicios.treinadorDeDigitacao;

import javax.swing.JButton;

public class Botao extends JButton 
{
	private String texto;
	
	public Botao()
	{
		
	}
	
	public Botao(String texto)
	{
		this.texto = texto;
		setText(this.texto);
	}
	
	public String getTexto()
	{
		return texto;
	}
	public void setTexto(String newTexto)
	{
		texto = newTexto;
	}
}
