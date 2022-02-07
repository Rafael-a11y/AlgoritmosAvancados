package exercicios.treinadorDeDigitacao;

import javax.swing.JButton;

public class Botao extends JButton 
{
	private String codigoChave;
	private char codigoChar;
	public Botao()
	{
		
	}
	
	public Botao(String texto, String chaveString, char chaveCaracter )
	{
		setText(texto);
		codigoChave = chaveString;
		codigoChar = chaveCaracter;
	}
	
	
	public Botao(String texto, String chaveString)
	{
		setText(texto);
		codigoChave = chaveString;
	}
	
	public String getCodigoChave() 
	{
		return codigoChave;
	}
	
	public void setCodigoChave(String chaveString)
	{
		codigoChave = chaveString;
	}
	
	public char getCodigoChar()
	{
		return codigoChar;
	}
	
	public void setCodigoChar(char chaveCaracter)
	{
		codigoChar = chaveCaracter;
	}
}
