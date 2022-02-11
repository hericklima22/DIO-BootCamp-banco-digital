package View;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {
	public Menu() {
			JFrame frame = new JFrame("Banco digital mais seguro do mundo");
			final JLabel label = new JLabel("Teste do banco digital");
			frame.getContentPane().add(label);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
	}

}
