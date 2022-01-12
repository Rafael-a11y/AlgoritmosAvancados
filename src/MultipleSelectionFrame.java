// Figura 12.25: MultipleSelectionFrame.java
// JList que permite várias seleções
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame
{
	private final JList<String> colorJList; // Lista para armazenar nomes de cores
	private final JList<String> copyJList; // Lista para armazenar nomes copiados
	private JButton copyJButton; // Botão para copiar nomes selecionados.
	private static final String[] colorNames = {"Black", "Blue", "Cyan",
			"Dark Gray", "Gray", "Green", "Light Gray", "Magenta","Orange",
			"Pink", "Red", "White", "Yellow"};
	
	// Construtor MultipleSelectionFrame
	MultipleSelectionFrame()
	{
		super("Várias listas de seleção");
		this.setLayout(new FlowLayout());
		
		colorJList = new JList<>(MultipleSelectionFrame.colorNames); // Lista dos nomes de cores
		colorJList.setVisibleRowCount(5); // Mostra cinco linhas
		colorJList.setSelectionMode(
				ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		MultipleSelectionFrame.this.add(new JScrollPane(colorJList)); //Adiciona lista com ScrollPane.
		
		copyJButton = new JButton("Copiar >>>");
		copyJButton.addActionListener(
				new ActionListener() // Classe interna anônima .
				{
					// Trata de vento de botão
					@Override
					public void actionPerformed(ActionEvent event)
					{
						// Coloca valores selecionados na copyJList
						copyJList.setListData(
								colorJList.getSelectedValuesList().toArray(
										new String[0])); // O array String de eparâmetro serve para
					}									 // Para retornar o array de String, pois o 
				}										 // método sem parâmetro retorna um array
			);											 // de Object.
		
		MultipleSelectionFrame.this.add(copyJButton); //Adiciona o botão de cópia ao JFrame
		
		copyJList = new JList<>(); // Lista para armazenar nomes copiados
		copyJList.setVisibleRowCount(5); // Mostra cinco linhas
		copyJList.setFixedCellWidth(100); // Configura a largura
		copyJList.setFixedCellHeight(15); // Configura a altura
		copyJList.setSelectionMode(
	
				ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		MultipleSelectionFrame.this.add(new JScrollPane(copyJList)); // Adiciona lista com JScrollPane
	}
}// Fim da classe MultipleSelectionFrame