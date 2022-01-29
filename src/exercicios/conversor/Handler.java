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
	private Contêiner contêinerPrincipal, contêiner1, contêiner2, contêiner3, contêiner4, contêiner5, contêiner6;
	private Janela janela;
	private boolean voltar;
	private List<Contêiner> lista;
	
	public Handler(Janela janela, Contêiner contêinerPrincipal,
			Contêiner contêiner1, Contêiner contêiner2, Contêiner contêiner3, Contêiner contêiner4, Contêiner contêiner5,
			Contêiner contêiner6)
	{
		
		this.janela = janela;
		this.contêinerPrincipal = contêinerPrincipal;
		this.contêiner1 = contêiner1;
		this.contêiner2 = contêiner2;
		this.contêiner3 = contêiner3;
		this.contêiner4 = contêiner4;
		this.contêiner5 = contêiner5;
		this.contêiner6 = contêiner6;
		
		lista = new ArrayList<>();
		lista.add(this.contêiner1);
		lista.add(this.contêiner2);
		lista.add(this.contêiner3);
		lista.add(this.contêiner4);
		lista.add(this.contêiner5);
		lista.add(this.contêiner6);
		
		this.contêinerPrincipal.getRadio1().addItemListener(this);
		this.contêinerPrincipal.getRadio2().addItemListener(this);
		this.contêinerPrincipal.getRadio3().addItemListener(this);
		this.contêinerPrincipal.getRadio4().addItemListener(this);
		this.contêinerPrincipal.getRadio5().addItemListener(this);
		this.contêinerPrincipal.getRadio6().addItemListener(this);
		
		this.contêiner1.getVoltar().addActionListener(this);
		this.contêiner2.getVoltar().addActionListener(this);
		this.contêiner3.getVoltar().addActionListener(this);
		this.contêiner4.getVoltar().addActionListener(this);
		this.contêiner5.getVoltar().addActionListener(this);
		this.contêiner6.getVoltar().addActionListener(this);
		
		this.contêiner1.getCampo().addActionListener(this);
		this.contêiner2.getCampo().addActionListener(this);
		this.contêiner3.getCampo().addActionListener(this);
		this.contêiner4.getCampo().addActionListener(this);
		this.contêiner5.getCampo().addActionListener(this);
		this.contêiner6.getCampo().addActionListener(this);
	}
	
	private void falseParaTodos(Contêiner escolhido)
	{	
		for(int count = 0; count < lista.size(); count++)
		{
			if(lista.get(count).equals(escolhido))
				lista.get(count).setItsMe(true);
			else
				lista.get(count).setItsMe(false);
		}
	}
	
	private Contêiner obterContêinerParaProcessamento()
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
		this.fahrenheit = Float.parseFloat(this.contêiner1.getCampo().getText());
		this.celsius = 5.0F / 9.0F * (this.fahrenheit - 32.0F);
		this.contêiner1.getLabelResultado().setText(String.valueOf(this.celsius) + " ºC");
	}
	
	private void converterCelsiusParaKelvin()
	{
		this.celsius = Float.parseFloat(this.contêiner2.getCampo().getText());
		this.kelvin = this.celsius + 273.15F;
		this.contêiner2.getLabelResultado().setText(String.valueOf(this.kelvin) + " K");
	}
	
	private void converterCelsiusParaFahrenheit()
	{
		// (C *  9/5) + 32
		this.celsius = Float.parseFloat(this.contêiner3.getCampo().getText());
		this.fahrenheit = (celsius * 9.0F/5.0F) + 32.0F;
		this.contêiner3.getLabelResultado().setText(String.valueOf(this.fahrenheit) + " ºF");
	}
	
	private void converterKelvinParaCelsius()
	{
		// K - 273.15
		this.kelvin = Float.parseFloat(this.contêiner4.getCampo().getText());
		this.celsius = this.kelvin - 273.15F;
		this.contêiner4.getLabelResultado().setText(String.valueOf(this.celsius) + " ºC");
	}
	
	private void converterFahrenheitParaKelvin()
	{
		// (F - 32) * 5/9 + 273.15
		this.fahrenheit = Float.parseFloat(this.contêiner5.getCampo().getText());
		this.kelvin = (fahrenheit - 32.0F) * 5.0F/9.0F + 273.15F;
		this.contêiner5.getLabelResultado().setText(String.valueOf(this.kelvin) + " K");
	}
	
	private void converterKelvinParaFahrenheit()
	{
		// (K - 273.15) * 9/5 + 32
		this.kelvin = Float.parseFloat(this.contêiner6.getCampo().getText());
		this.fahrenheit = (this.kelvin - 273.15F) * 9.0F/5.0F + 32.0F;
		this.contêiner6.getLabelResultado().setText(String.valueOf(this.fahrenheit) + " ºF");
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
		if(this.contêinerPrincipal.getRadio1().isSelected())
		{
			this.falseParaTodos(this.contêiner1);
			this.janela.setContentPane(this.contêiner1);
			this.janela.validate();		
		}
		else if(this.contêinerPrincipal.getRadio2().isSelected())
		{
			this.falseParaTodos(this.contêiner2);
			this.janela.setContentPane(this.contêiner2);
			this.janela.validate();
		}
		else if(this.contêinerPrincipal.getRadio3().isSelected())
		{
			this.falseParaTodos(this.contêiner3);
			this.janela.setContentPane(this.contêiner3);
			this.janela.validate();
		}
		else if(this.contêinerPrincipal.getRadio4().isSelected())
		{
			this.falseParaTodos(this.contêiner4);
			this.janela.setContentPane(this.contêiner4);
			this.janela.validate();
		}
		else if(this.contêinerPrincipal.getRadio5().isSelected())
		{
			this.falseParaTodos(this.contêiner5);
			this.janela.setContentPane(this.contêiner5);
			this.janela.validate();
		}
		else if(this.contêinerPrincipal.getRadio6().isSelected())
		{
			this.falseParaTodos(this.contêiner6);
			this.janela.setContentPane(this.contêiner6);
			this.janela.validate();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent event)
	{
		this.voltar = this.obterBooleano(event);
		Contêiner temporario = this.obterContêinerParaProcessamento();
		try
		{
			if(voltar)
			{
				this.janela.setContentPane(this.contêinerPrincipal);
				this.janela.validate();
				this.contêinerPrincipal.getGrupo().clearSelection();
			}
			else if(temporario == this.contêiner1)
				this.converterFahrenheitParaCelsius();
			else if(temporario == this.contêiner2)
				this.converterCelsiusParaKelvin();
			else if(temporario == this.contêiner3)
				this.converterCelsiusParaFahrenheit();
			else if(temporario == this.contêiner4)
				this.converterKelvinParaCelsius();
			else if(temporario == this.contêiner5)
				this.converterFahrenheitParaKelvin();
			else
				this.converterKelvinParaFahrenheit();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this.janela, e.getMessage(), "Erro -> A entrada deve ser numérica", 
					JOptionPane.ERROR_MESSAGE);
			if(temporario == this.contêiner1)
			{
				this.contêiner1.getCampo().setText("");
				this.contêiner1.getLabelResultado().setText("");
			}
			else if(temporario == this.contêiner2)
			{
				this.contêiner2.getCampo().setText("");
				this.contêiner2.getLabelResultado().setText("");
			}
			else if(temporario == this.contêiner3)
			{
				this.contêiner3.getCampo().setText("");
				this.contêiner3.getLabelResultado().setText("");
			}
			else if(temporario == this.contêiner4)
			{
				this.contêiner4.getCampo().setText("");
				this.contêiner4.getLabelResultado().setText("");
			}
			else if(temporario == this.contêiner5)
			{
				this.contêiner5.getCampo().setText("");
				this.contêiner5.getLabelResultado().setText("");
			}
			else
			{
				this.contêiner6.getCampo().setText("");
				this.contêiner6.getLabelResultado().setText("");
			}
		}
	}
}
 