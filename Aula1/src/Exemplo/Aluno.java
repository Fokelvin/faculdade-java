package Exemplo;

import java.util.*;
import javax.swing.*;

public class Aluno {

	public static List<Integer> listaMatricula = new ArrayList<Integer> ();
	public static List<String> listaNome = new ArrayList<String> ();
	public static List<Double> listaAv1 = new ArrayList<Double> ();
	public static List<Double> listaAv2 = new ArrayList<Double> ();
	public static List<Double> listaAv3 = new ArrayList<Double> ();
	
	public static void main(String[] args) {
		String opcao = "";
		
		while(!opcao.equals("6") ) {
		opcao = entradaDeDadosTexto("Menu de opções \n\n"
					+ "1 - Cadastrar \n"
					+ "2 - Consultar \n"
					+ "3 - Atualizar \n"
					+ "4 - Excluir \n"
					+ "5 - Listar \n"
					+ "6 - Sair \n\n"
					+ "Escolha a sua opção: ",
					true
					);
			
			switch (opcao) {
			case "1": 
				CadastrarAluno();
				break;			
			case "2": 
				ConsultarAluno();
				break;
			case "3": 
				AtualizarAluno();
				break;
			case "4": 
				ExcluirAluno();
				break;	
			case "5": 
				ListarAluno();
				break;		
			}
		}	

	}
	
	public static String entradaDeDadosTexto(
			String texto,
			boolean obrigatorio) {
		JOptionPane tela =  new JOptionPane(); 
		
		String dado = "";
		
		do {
			dado = tela.showInputDialog(texto);
			
			if(dado.trim().isEmpty() && obrigatorio)
				mensagem("Campo de preenchimento obrigatório");
			
		}	while (dado.isEmpty() && obrigatorio);
		
		return dado;

	}	
	
	public static int entradaDeDadosInteiro(
			String valor,
			boolean obrigatorio) {
		JOptionPane tela =  new JOptionPane(); 
		
		int dado = 0;
		
		do {
			dado = Integer.parseInt(tela.showInputDialog(valor));
			
			if(dado <= 0 && obrigatorio)
				mensagem("Campo de preenchimento obrigatório");
			
		}	while (dado <= 0 && obrigatorio);
		
		return dado;

	}
	
	public static double entradaDeDadosDouble(
			String valor,
			boolean obrigatorio) {
		JOptionPane tela =  new JOptionPane(); 
		
		double dado = 0;
		
		do {
			dado = Double.parseDouble(tela.showInputDialog(valor));
			
			if(dado <= 0 && obrigatorio)
				mensagem("Campo de preenchimento obrigatório");
			
		}	while (dado <= 0 && obrigatorio);
		
		return dado;

	}
	
	public static void mensagem (String valor) {
		JOptionPane tela = new JOptionPane();
		
		tela.showMessageDialog(null, valor, "Atenção !", 3);
	}
	
	public static void CadastrarAluno() {
		
		//Ler a matricula do aluno
		
		String entradaMatricula = "";
		
		int option = 0;
        while (option == 0) {
            try {
            	entradaMatricula = entradaDeDadosTexto("Informe a matrícula do aluno", true);
            	option = Integer.parseInt(entradaMatricula);
            }catch(NumberFormatException e){
                mensagem("Informe apenas números");
            }
        }
		
			
		//Verificar se a matricula existe na lista;
		//Se existir, exibir a mensagem: Matrícula já cadastrada!
		
		int indice = listaMatricula.indexOf(entradaMatricula);
		
		if (indice != -1) {
			mensagem("Matrícula já cadastrada!");
			return;
		}	
					
		//Caso contrario, ler os dados restantes;
		//Adicionar os dados nas respectivas listas.
		
		listaMatricula.add(option);
		listaNome.add(entradaDeDadosTexto("Informe seu nome:", true));
		listaAv1.add(entradaDeDadosDouble("Informe a nota da AV1:", false));
		listaAv2.add(entradaDeDadosDouble("Informe a nota da AV2:", false));
		listaAv3.add(entradaDeDadosDouble("Informe a nota da AV3:", false));
			
		mensagem("O aluno foi cadastrado com sucesso!");
			
		}
	
	public static void ExcluirAluno() {
		
		//Ler a matricula do aluno
		
		int entradaMatricula = entradaDeDadosInteiro("Informe a matrícula do aluno", true);
		
		//Verificar se a matricula existe na lista;
		//Se existir, excluir o aluno
		//caso contrario, exibir a mensagem: Matrícula não encotrada!
				
		int indice = listaMatricula.indexOf(entradaMatricula);
		
		if (indice != -1) {
			listaMatricula.remove(indice);
			listaNome.remove(indice);
			listaAv1.remove(indice);
			listaAv2.remove(indice);
			listaAv3.remove(indice);
			
			mensagem("Aluno excluído com sucesso!");
		}	
		else {
			mensagem("Matrícula não encontrada!");
		}
	}
	
	public static void ConsultarAluno() {
		
		//Ler a matricula do aluno
		
				int entradaMatricula = entradaDeDadosInteiro("Informe a matrícula do aluno", true);
				
				//Verificar se a matricula existe na lista;
				//Se existir, excluir o aluno
				//caso contrario, exibir a mensagem: Matrícula não encotrada!
						
				int indice = listaMatricula.indexOf(entradaMatricula);
				
				if (indice != -1) {
					String exibir ="\nAluno: " + listaNome.get(indice) + "\n" +
							 "nota AV1: " + listaAv1.get(indice) + "\n" +
							 "nota AV2: " + listaAv2.get(indice) + "\n" +
							 "nota AV3: " + listaAv3.get(indice);	
				
					mensagem(exibir);
				}	
				else {
					mensagem("Matrícula não encontrada!");
				}
	}
	
	public static void ListarAluno() {
		String exibir = "";
		
		for(int indice = 0; indice < listaMatricula.size(); indice ++) {
			exibir +="\nAluno: " + listaNome.get(indice) + "\n" +
					 "nota AV1: " + listaAv1.get(indice) + "\n" +
					 "nota AV2: " + listaAv2.get(indice) + "\n" +
					 "nota AV3: " + listaAv3.get(indice) + "\n";	
			
		};
		
		mensagem(exibir);
	}
	
	public static void AtualizarAluno() {
		
		//Ler a matricula do aluno
		
		int entradaMatricula = entradaDeDadosInteiro("Informe a matrícula do aluno", true);
		
		//Verificar se a matricula existe na lista;
		//Se existir, exibir a mensagem: Matrícula já cadastrada!
		
		int indice = listaMatricula.indexOf(entradaMatricula);
		
		if (indice == -1) {
			mensagem("Matrícula não encontrada!");
			return;
		}
		
		listaNome.set(indice, entradaDeDadosTexto("Informe seu nome:", true));
		listaAv1.set(indice, entradaDeDadosDouble("Informe a nota da AV1:", false));
		listaAv2.set(indice, entradaDeDadosDouble("Informe a nota da AV2:", false));
		listaAv3.set(indice, entradaDeDadosDouble("Informe a nota da AV3:", false));
		
		
	}
	
}





