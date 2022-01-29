package exercicios.conversor;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Handler implements ItemListener, ActionListener
{
	private float fahrenheit, celsius, kelvin;
	private Cont�iner cont�inerPrincipal, cont�iner1, cont�iner2, cont�iner3, cont�iner4, cont�iner5, cont�iner6;
	private Janela janela;
	private boolean voltar;
	private List<Cont�iner> lista;
	
	public Handler(Janela janela, Cont�iner cont�inerPrincipal,
			Cont�iner cont�iner1, Cont�iner cont�iner2, Cont�iner cont�iner3, Cont�iner cont�iner4, Cont�iner cont�iner5,
			Cont�iner cont�iner6)
	{
		
		this.janela = janela;
		this.cont�inerPrincipal = cont�inerPrincipal;
		this.cont�iner1 = cont�iner1;
		this.cont�iner2 = cont�iner2;
		this.cont�iner3 = cont�iner3;
		this.cont�iner4 = cont�iner4;
		this.cont�iner5 = cont�iner5;
		this.cont�iner6 = cont�iner6;
		
		lista = new ArrayList<>();
		lista.add(this.cont�iner1);
		lista.add(this.cont�iner2);
		lista.add(this.cont�iner3);
		lista.add(this.cont�iner4);
		lista.add(this.cont�iner5);
		lista.add(this.cont�iner6);
		
		this.cont�inerPrincipal.getRadio1().addItemListener(this);
		this.cont�inerPrincipal.getRadio2().addItemListener(this);
		this.cont�inerPrincipal.getRadio3().addItemListener(this);
		this.cont�inerPrincipal.getRadio4().addItemListener(this);
		this.cont�inerPrincipal.getRadio5().addItemListener(this);
		this.cont�inerPrincipal.getRadio6().addItemListener(this);
		
		this.cont�iner1.getVoltar().addActionListener(this);
		this.cont�iner2.getVoltar().addActionListener(this);
		this.cont�iner3.getVoltar().addActionListener(this);
		this.cont�iner4.getVoltar().addActionListener(this);
		this.cont�iner5.getVoltar().addActionListener(this);
		this.cont�iner6.getVoltar().addActionListener(this);
		
		this.cont�iner1.getCampo().addActionListener(this);
		this.cont�iner2.getCampo().addActionListener(this);
		this.cont�iner3.getCampo().addActionListener(this);
		this.cont�iner4.getCampo().addActionListener(this);
		this.cont�iner5.getCampo().addActionListener(this);
		this.cont�iner6.getCampo().addActionListener(this);
	}
	
	private void falseParaTodos(Cont�iner escolhido)
	{	
		for(int count = 0; count < lista.size(); count++)
		{
			if(lista.get(count).equals(escolhido))
				lista.get(count).setItsMe(true);
			else
				lista.get(count).setItsMe(false);
		}
	}
	
	private Cont�iner obterCont�inerParaProcessamento()
	{
		for(int count = 0; count < lista.size(); count++)
		{
			if(this.lista.get(count).getItsMe())
			{
				return this.lista.get(count);
			}
		}
		return null;
	}
	
	private void converterFahrenheitParaCelsius()
	{
		this.fahrenheit = Float.parseFloat(this.cont�iner1.getCampo().getText());
		this.celsius = 5.0F / 9.0F * (this.fahrenheit - 32.0F);
		this.cont�iner1.getLabelResultado().setText(String.valueOf(this.celsius) + " �C");
	}
	
	private void converterCelsiusParaKelvin()
	{
		this.celsius = Float.parseFloat(this.cont�iner2.getCampo().getText());
		this.kelvin = this.celsius + 273.15F;
		this.cont�iner2.getLabelResultado().setText(String.valueOf(this.kelvin) + " K");
	}
	
	private void converterCelsiusParaFahrenheit()
	{
		// (C *  9/5) + 32
		this.celsius = Float.parseFloat(this.cont�iner3.getCampo().getText());
		this.fahrenheit = (celsius * 9.0F/5.0F) + 32.0F;
		this.cont�iner3.getLabelResultado().setText(String.valueOf(this.fahrenheit) + " �F");
	}
	
	private void converterKelvinParaCelsius()
	{
		// K - 273.15
		this.kelvin = Float.parseFloat(this.cont�iner4.getCampo().getText());
		this.celsius = this.kelvin - 273.15F;
		this.cont�iner4.getLabelResultado().setText(String.valueOf(this.celsius) + " �C");
	}
	
	private void converterFahrenheitParaKelvin()
	{
		// (F - 32) * 5/9 + 273.15
		this.fahrenheit = Float.parseFloat(this.cont�iner5.getCampo().getText());
		this.kelvin = (fahrenheit - 32.0F) * 5.0F/9.0F + 273.15F;
		this.cont�iner5.getLabelResultado().setText(String.valueOf(this.kelvin) + " K");
	}
	
	private void converterKelvinParaFahrenheit()
	{
		// (K - 273.15) * 9/5 + 32
		this.kelvin = Float.parseFloat(this.cont�iner6.getCampo().getText());
		this.fahrenheit = (this.kelvin - 273.15F) * 9.0F/5.0F + 32.0F;
		this.cont�iner6.getLabelResultado().setText(String.valueOf(this.fahrenheit) + " �F");
	}
	
	private boolean obterBooleano(ActionEvent evento)
	{
		for(int count = 0; count < lista.size(); count++)
		{
			if(lista.get(count).getVoltar().equals(evento.getSource()))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		if(this.cont�inerPrincipal.getRadio1().isSelected())
		{
			this.falseParaTodos(this.cont�iner1);
			this.janela.setContentPane(this.cont�iner1);
			this.janela.validate();		
		}
		else if(this.cont�inerPrincipal.getRadio2().isSelected())
		{
			this.falseParaTodos(this.cont�iner2);
			this.janela.setContentPane(this.cont�iner2);
			this.janela.validate();
		}
		else if(this.cont�inerPrincipal.getRadio3().isSelected())
		{
			this.falseParaTodos(this.cont�iner3);
			this.janela.setContentPane(this.cont�iner3);
			this.janela.validate();
		}
		else if(this.cont�inerPrincipal.getRadio4().isSelected())
		{
			this.falseParaTodos(this.cont�iner4);
			this.janela.setContentPane(this.cont�iner4);
			this.janela.validate();
		}
		else if(this.cont�inerPrincipal.getRadio5().isSelected())
		{
			this.falseParaTodos(this.cont�iner5);
			this.janela.setContentPane(this.cont�iner5);
			this.janela.validate();
		}
		else if(this.cont�inerPrincipal.getRadio6().isSelected())
		{
			this.falseParaTodos(this.cont�iner6);
			this.janela.setContentPane(this.cont�iner6);
			this.janela.validate();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent event)
	{
		this.voltar = this.obterBooleano(event);
		Cont�iner temporario = this.obterCont�inerParaProcessamento();
		try
		{
			if(voltar)
			{
				this.janela.setContentPane(this.cont�inerPrincipal);
				this.janela.validate();
				this.cont�inerPrincipal.getGrupo().clearSelection();
			}
			else if(temporario == this.cont�iner1)
				this.converterFahrenheitParaCelsius();
			else if(temporario == this.cont�iner2)
				this.converterCelsiusParaKelvin();
			else if(temporario == this.cont�iner3)
				this.converterCelsiusParaFahrenheit();
			else if(temporario == this.cont�iner4)
				this.converterKelvinParaCelsius();
			else if(temporario == this.cont�iner5)
				this.converterFahrenheitParaKelvin();
			else
				this.converterKelvinParaFahrenheit();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this.janela, e.getMessage(), "Erro -> A entrada deve ser num�rica", 
					JOptionPane.ERROR_MESSAGE);
			if(temporario == this.cont�iner1)
			{
				this.cont�iner1.getCampo().setText("");
				this.cont�iner1.getLabelResultado().setText("");
			}
			else if(temporario == this.cont�iner2)
			{
				this.cont�iner2.getCampo().setText("");
				this.cont�iner2.getLabelResultado().setText("");
			}
			else if(temporario == this.cont�iner3)
			{
				this.cont�iner3.getCampo().setText("");
				this.cont�iner3.getLabelResultado().setText("");
			}
			else if(temporario == this.cont�iner4)
			{
				this.cont�iner4.getCampo().setText("");
				this.cont�iner4.getLabelResultado().setText("");
			}
			else if(temporario == this.cont�iner5)
			{
				this.cont�iner5.getCampo().setText("");
				this.cont�iner5.getLabelResultado().setText("");
			}
			else
			{
				this.cont�iner6.getCampo().setText("");
				this.cont�iner6.getLabelResultado().setText("");
			}
		}
	}
}
 