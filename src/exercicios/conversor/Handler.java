package exercicios.conversor;

import java.awt.event.ItemListener;		
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Handler implements ItemListener, ActionListener
{
	private float fahrenheit, celsius, kelvin;
	private Contêiner contêinerPrincipal, contêiner1, contêiner2;
	private Janela janela;
	
	public Handler(Janela janela, Contêiner contêinerPrincipal,
			Contêiner contêiner1, Contêiner contêiner2)
	{
		this.janela = janela;
		this.contêinerPrincipal = contêinerPrincipal;
		this.contêiner1 = contêiner1;
		this.contêiner2 = contêiner2;
		
		this.contêinerPrincipal.getRadio1().addItemListener(this);
		this.contêinerPrincipal.getRadio2().addItemListener(this);
		
		this.contêiner1.getVoltar().addActionListener(this);
		this.contêiner2.getVoltar().addActionListener(this);
		
		this.contêiner1.getCampo().addActionListener(this);
		this.contêiner2.getCampo().addActionListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		if(this.contêinerPrincipal.getRadio1().isSelected())
		{
			this.contêiner1.setItsMe(true);
			this.contêiner2.setItsMe(false);
			this.janela.setContentPane(this.contêiner1);
			this.janela.validate();		
		}
		else if(this.contêinerPrincipal.getRadio2().isSelected())
		{
			this.contêiner2.setItsMe(true);
			this.contêiner1.setItsMe(false);
			this.janela.setContentPane(this.contêiner2);
			this.janela.validate();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			if(event.getSource() == this.contêiner1.getVoltar() ||
					event.getSource() == this.contêiner2.getVoltar())
			{
				this.janela.setContentPane(this.contêinerPrincipal);
				this.janela.invalidate();
			}
			else if(this.contêiner1.getItsMe())
			{
				this.fahrenheit = Float.parseFloat(this.contêiner1.getCampo().getText());
				this.celsius = 5.0F / 9.0F * (this.fahrenheit - 32.0F);
				this.contêiner1.getLabelResultado().setText(String.valueOf(this.celsius));
			}
			else if(this.contêiner2.getItsMe())
			{
				this.celsius = Float.parseFloat(this.contêiner2.getCampo().getText());
				this.kelvin = this.celsius + 273.15F;
				this.contêiner2.getLabelResultado().setText(String.valueOf(this.kelvin));
			}
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this.janela, e.getMessage(), "Erro -> A entrada deve ser numérica", 
					JOptionPane.ERROR_MESSAGE);
			if(this.contêiner1.getItsMe())
			{
				this.contêiner1.getCampo().setText("");
				this.contêiner1.getLabelResultado().setText("");
			}
			else if(this.contêiner2.getItsMe())
			{
				this.contêiner2.getCampo().setText("");
				this.contêiner2.getLabelResultado().setText("");
			}
		}
	}
}
