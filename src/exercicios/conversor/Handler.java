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
	private Cont�iner cont�inerPrincipal, cont�iner1, cont�iner2;
	private Janela janela;
	
	public Handler(Janela janela, Cont�iner cont�inerPrincipal,
			Cont�iner cont�iner1, Cont�iner cont�iner2)
	{
		this.janela = janela;
		this.cont�inerPrincipal = cont�inerPrincipal;
		this.cont�iner1 = cont�iner1;
		this.cont�iner2 = cont�iner2;
		
		this.cont�inerPrincipal.getRadio1().addItemListener(this);
		this.cont�inerPrincipal.getRadio2().addItemListener(this);
		
		this.cont�iner1.getVoltar().addActionListener(this);
		this.cont�iner2.getVoltar().addActionListener(this);
		
		this.cont�iner1.getCampo().addActionListener(this);
		this.cont�iner2.getCampo().addActionListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		if(this.cont�inerPrincipal.getRadio1().isSelected())
		{
			this.cont�iner1.setItsMe(true);
			this.cont�iner2.setItsMe(false);
			this.janela.setContentPane(this.cont�iner1);
			this.janela.validate();		
		}
		else if(this.cont�inerPrincipal.getRadio2().isSelected())
		{
			this.cont�iner2.setItsMe(true);
			this.cont�iner1.setItsMe(false);
			this.janela.setContentPane(this.cont�iner2);
			this.janela.validate();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			if(event.getSource() == this.cont�iner1.getVoltar() ||
					event.getSource() == this.cont�iner2.getVoltar())
			{
				this.janela.setContentPane(this.cont�inerPrincipal);
				this.janela.invalidate();
			}
			else if(this.cont�iner1.getItsMe())
			{
				this.fahrenheit = Float.parseFloat(this.cont�iner1.getCampo().getText());
				this.celsius = 5.0F / 9.0F * (this.fahrenheit - 32.0F);
				this.cont�iner1.getLabelResultado().setText(String.valueOf(this.celsius));
			}
			else if(this.cont�iner2.getItsMe())
			{
				this.celsius = Float.parseFloat(this.cont�iner2.getCampo().getText());
				this.kelvin = this.celsius + 273.15F;
				this.cont�iner2.getLabelResultado().setText(String.valueOf(this.kelvin));
			}
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this.janela, e.getMessage(), "Erro -> A entrada deve ser num�rica", 
					JOptionPane.ERROR_MESSAGE);
			if(this.cont�iner1.getItsMe())
			{
				this.cont�iner1.getCampo().setText("");
				this.cont�iner1.getLabelResultado().setText("");
			}
			else if(this.cont�iner2.getItsMe())
			{
				this.cont�iner2.getCampo().setText("");
				this.cont�iner2.getLabelResultado().setText("");
			}
		}
	}
}
