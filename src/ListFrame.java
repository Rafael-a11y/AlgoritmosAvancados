// Figura 12.23: ListFrame.java
// JList que exibe uma lista de corers
import javax.swing.JFrame;	
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class ListFrame extends JFrame
{
	private final JList<String> colorJList; // Lista para exibir cores.
	private static final String[] colorNames = {"Black", "Blue", "Cyan",
			"Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
			"Orange", "Pink", "Red", "White", "Yellow"};
	private static final Color[] colors = {Color.BLACK, Color.BLUE,
			Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
			Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
			Color.RED, Color.WHITE, Color.YELLOW};
	
	// Construtor ListFrame adiciona JScrollPane que contém JList ao JFrame
	ListFrame()
	{
		super("Testando a Lista");
		this.setLayout(new FlowLayout());
		
		colorJList = new JList<String>(ListFrame.colorNames); // lista de colorsNames
		colorJList.setVisibleRowCount(5); // Exibe cinco linhas de uma vez.
		
		// Não permite múltiplas seleções.
		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Adiciona um JScrollPane que contém JList ao frame
		this.add(new JScrollPane(colorJList));
		
		colorJList.addListSelectionListener(
				new ListSelectionListener() // Classe interna anônima
				{
					// Trata eventos de seleção de lista
					@Override
					public void valueChanged(ListSelectionEvent event)
					{
						ListFrame.this.getContentPane().setBackground(
								colors[colorJList.getSelectedIndex()]);
					}
				}
		);
	} // Fim do construtor ListFrame
} // Fim da classe ListFrame