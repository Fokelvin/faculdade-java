package jframe;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GridExemplo extends JFrame{

	private static final long servialVersionUID = 1L;
	private JButton sim, nao, cancelar; 
	private JLabel mensagem;
	
	public GridExemplo() {
		super("Meu Grid v1.0");
		sim = new JButton("Sim");
		nao = new JButton("Nao");
		cancelar = new JButton("Cancelar");
		mensagem = new JLabel("Mensagem: ");
		getContentPane().setLayout(new GridLayout(2,2));
	}
	
	public void init() {
		
		setForeground(Color.red);
		setBackground(new Color(192,192,192));
		setSize(500, 400);
		setLocation(500,400);
		getContentPane().add(mensagem);
		getContentPane().add(sim);
		getContentPane().add(nao);
		getContentPane().add(cancelar);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public static void main (String[] args) {
		new GridExemplo().init();
	}
	
}
