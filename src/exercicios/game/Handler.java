package exercicios.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextField;

public class Handler implements ActionListener 
{
	private final GameDivinhacao janela;
	private int numeroOculto, numeroUsuario;
	
	public Handler(GameDivinhacao janela)
	{
		this.janela = janela;
		numeroOculto = new Random().nextInt(1000);
		janela.getCampo().addActionListener(this);
		janela.getBotao().addActionListener(this);
	}
	
	public void definirCor()
	{
		numeroUsuario = Integer.parseInt(janela.getCampo().getText());
		int tentativaAnterior = Math.abs(numeroUsuario - numeroOculto);
		System.out.println(numeroOculto);
		
		if(Math.abs(numeroUsuario - numeroOculto) > tentativaAnterior )
		{
			janela.getSuperior().setBackground(Color.RED);
			janela.getInferior().setBackground(Color.RED);
			janela.getLabelDica().setText("Está mais quente");
		}
		else if(Math.abs(numeroUsuario - numeroOculto) <= tentativaAnterior)
		{
			janela.getSuperior().setBackground(Color.BLUE);
			janela.getInferior().setBackground(Color.BLUE);
			janela.getLabelDica().setText("Está mais frio");
		}
		
		adicionarBotao();
		janela.getCampo().setText("");
	}
	
	public void adicionarBotao()
	{
		if(this.numeroOculto == this.numeroUsuario)
		{
			
			janela.getCampo().disable();
			janela.getSuperior().setBackground(Color.GREEN);
			janela.getInferior().setBackground(Color.GREEN);
			janela.getLabelComando().setText("Deseja jogar mais uma vez?");
			janela.getLabelDica().setText("Correto!");
			janela.getInferior().add(janela.getBotao());
			janela.validate();
		}
	}
	
	public void reiniciarGame()
	{
		Color cor = new Color(238, 238, 238);
		janela.getLabelComando().setText(janela.getComando());
		janela.getLabelDica().setText("");
		numeroOculto = new Random().nextInt(1000);
		janela.getInferior().remove(janela.getBotao());
		janela.getCampo().enable();
		this.janela.setBackground(cor);
		janela.validate();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() instanceof JTextField)
			definirCor();
		else
			reiniciarGame();
	}
}
