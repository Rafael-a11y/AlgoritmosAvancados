package exercicios;

import java.awt.BorderLayout;	
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ColorSelect extends JFrame 
{
	// Arranjo de String contendo nomes de cores conhecidas
	private final String[] names = {"RED", "BLUE", "YELLOW", "GREEN", "BLACK", "WHITE", "ORANGE"};
	// Arranjo de cores.
	private final Color[] cores = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.BLACK,
			Color.WHITE, Color.ORANGE};
	private final JComboBox<String> comboBox;
	private final JRadioButton background, foreground;
	private final ButtonGroup grupo;
	private final JButton ok, cancel;
	private final JPanel painel, painel2;
	private final Handler handler;
	
	ColorSelect()
	{
		super("Seleção de cor");
		// Iniciando os atributos.
		this.handler = new Handler(); // Objeto ouvinte de evento de item e de ação
		this.comboBox = new JComboBox<>(names); 
		this.background = new JRadioButton("Background");
		this.foreground = new JRadioButton("Foreground");
		this.grupo = new ButtonGroup();
		this.ok = new JButton("Ok");
		this.cancel = new JButton("Cancel");
		this.painel = new JPanel(new FlowLayout());
		this.painel2 = new JPanel(new FlowLayout());
		// Registrando o handler como ouvinte dos componentes.
		this.comboBox.addItemListener(handler);
		this.background.addItemListener(handler);
		this.foreground.addItemListener(handler);
		this.ok.addActionListener(handler);
		this.cancel.addActionListener(handler);
		// Máximo de linhas que comboBox exibirá inicialmente
		this.comboBox.setMaximumRowCount(3);
		this.grupo.add(background);
		this.grupo.add(foreground); //ButtonGroup adicionando os JRadioButton's para criar a relaçao de exclusão mútua.
		this.painel.add(background);
		this.painel.add(foreground);
		this.painel2.add(ok);
		this.painel2.add(cancel);
		
		this.add(comboBox, BorderLayout.NORTH);
		this.add(painel, BorderLayout.CENTER);
		this.add(painel2, BorderLayout.SOUTH);
		
		initGUI();
	}
	
	public void initGUI()
	{
		this.setDefaultCloseOperation(ColorSelect.EXIT_ON_CLOSE);
		this.setSize(300, 130);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	// Classe interna Handler que implmenta interfaces para poder tratar eventos de ação e de item
	private class Handler implements ItemListener, ActionListener
	{
		private Color cor;
		private boolean backgroundMarcado;
		private boolean foregroundMarcado;
		private ItemEvent e;
		
		@Override
		public void itemStateChanged(ItemEvent event)
		{	// Verifica se algum item está selecionado na comboBox, e usa seu índice para achar a cor correspodente no vetor
			// de cores. a cor é setada no atributo cor.
			if(event.getStateChange() == ItemEvent.SELECTED)
			{
				cor = cores[comboBox.getSelectedIndex()];
			}
			if(background.isSelected()) 
			{
				backgroundMarcado = true;
				foregroundMarcado = false;
			}
			else if(foreground.isSelected())
			{
				foregroundMarcado = true;
				backgroundMarcado = false;
			}		
			e = event; // Atributo e recebe o evento de item.
		}
		
		@Override
		public void actionPerformed(ActionEvent event)
		{
			// Verifica o JButton pressionado e qual JRadioButton está selecionado através das variáveis booleanas definidas
			// anteriormente de acordo com o JRadioButton selecionado. Caso nenhuma das duas condições seja satisfeita,
			// as cores de todos os componentes são definidos com a cor padrão novamente através do método padrao().
			if(event.getActionCommand().equals("Ok") && backgroundMarcado == true)
			{
				alterarCorDoFundo();
			}
			else if(event.getActionCommand().equals("Ok") && foregroundMarcado == true)
			{
				alterarCorDosComponentes();
			}
			else 
			{
				padrao();
			}
		}
		private void alterarCorDoFundo()
		{
			painel.setBackground(cor);
			painel2.setBackground(cor);
		}
		private void alterarCorDosComponentes()
		{
			background.setBackground(cor);
			foreground.setBackground(cor);
			ok.setBackground(cor);
			cancel.setBackground(cor);
		}
		private void padrao()
		{
			cor = new Color(238,238,238);
			painel.setBackground(cor);
			painel2.setBackground(cor);
			background.setBackground(cor);
			foreground.setBackground(cor);
			ok.setBackground(cor);
			cancel.setBackground(cor);
			itemStateChanged(e); // Mesmo que não tenha acontecido uma interação com os componentes, a recursividade
			// acontece para que os dados definidos anterior ao pressionar do botão Cancel sejam recuperados.
		}
		
	}
	
	public static void main(String[] args) 
	{
		new ColorSelect();
	}
}