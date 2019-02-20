package jframe;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowExemplo extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton sim, nao, cancelar; 
	private JButton mensagem;
	
	public FlowExemplo() {
		super("FlowExemplo v1.0");
		sim  = new JButton("sim");
		nao = new JButton("nao");
		cancelar = new JButton("cancelar");
		mensagem = new JButton ("mensagem: ");
		getContentPane().setLayout(new FlowLayout());
		}
	public void init() {
		setForeground(Color.black);
		setBackground(new Color(192, 192, 192));
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
		new FlowExemplo().init();
	}
	
	}
