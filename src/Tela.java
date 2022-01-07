import javax.swing.JFrame;

public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;

	Tela(){
		super("Tela de teste");
		this.setSize(300, 300);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		
		new Tela();
	}
}
