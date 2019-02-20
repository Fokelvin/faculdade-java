package jframe;

import java.awt.Color;
import javax.swing.JFrame;


public class MeuFrame extends JFrame{

		private static final long serialVersionUID = 1L;
		
		public MeuFrame() {
			super("Minha Janela  vl.0");
		}
		
		public void init() {
			setForeground(Color.GREEN);
			setBackground(new Color(192, 192, 192));
			setSize(500, 400);
			setLocation(500,400);
			setVisible(true);
		}

		public  static void main (String [] args) {
			MeuFrame mf = new MeuFrame();
			mf.init();
		}
}
