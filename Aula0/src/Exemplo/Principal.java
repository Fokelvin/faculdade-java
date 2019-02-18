	package Exemplo;


import javax.swing.JOptionPane;

public class Principal {

	static final int QTEREGISTROS = 10;
	
	static String matricula[] = new String[QTEREGISTROS];
	static String nome[] = new String[QTEREGISTROS];
	static String av1[] = new String[QTEREGISTROS];
	static String av2[] = new String[QTEREGISTROS];
	static String av3[] = new String[QTEREGISTROS];
	
	
	public static void main(String[] args) {
		String opcao = "";
		
		while(!opcao.equals("6") ) {
			opcao = entradaDeDadosTexto( "Menu de opões \n\n"
					+ "1 - Criar \n"
					+ "2 - Consultar \n"
					+ "3 - Atualizar \n"
					+ "4 - Excluir \n"
					+ "5 - Listar \n"
					+ "6 - Sair \n\n"
					+ "opcao sua opção");
			
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
				DeletarAluno();
				break;
			case "5":
				ListaAlunos();
				break;	
			}
		}
	}
	
	public static String entradaDeDadosTexto(String texto) {
		JOptionPane tela =  new JOptionPane(); 
		String dado = tela.showInputDialog(texto);
		return dado;
	}
	
	public static void mensagem (String valor) {
		JOptionPane tela = new JOptionPane();
		
		tela.showMessageDialog(null, valor);
	}
	public static int obterPrimeiraPosicaoDisponivel() {
		for(int posicao = 0; posicao < QTEREGISTROS; posicao++){
			if(matricula[posicao] == null){
				return posicao;
			}
		}
		return -1;
	}
	
	public static void ConsultarAluno() {
		
		String consultaMatricula = entradaDeDadosTexto("Digite a matrícula do aluno que deseja buscar:");
		String exibir = "";
		boolean check = false;
		for (int posicao = 0; posicao < QTEREGISTROS; posicao++) {
			if(matricula[posicao]!=null && matricula[posicao].equals(consultaMatricula)){
				exibir +="Aluno encontrado, matrícula :" + 
						 matricula[posicao] + "\n"+
						" Nome: "+ nome[posicao] + "\n"+
						" Nota da Av1:"+ av1[posicao] + "\n"+ 
						" Nota da Av2:"+ av2[posicao] + "\n"+
						" Nota da Av3:"+ av3[posicao]+ "\n";
				check = true;
			}
		}
		if(check == false){
		mensagem("Não há alunos com esses dados");
	}
}
	
	public static void CadastrarAluno() {
		
		int posicao = obterPrimeiraPosicaoDisponivel();
		if(posicao == -1) {
			mensagem("Não há espaço disponível na base de dados");
		}else {
			
			boolean retorno = verifica();
			if(retorno)
			matricula[posicao] = entradaDeDadosTexto("Informe a matrícula");
			nome[posicao] = entradaDeDadosTexto("Informe seu nome");
			av1[posicao] = entradaDeDadosTexto("Informe a nota da AV1");
			av2[posicao] = entradaDeDadosTexto("Informe a nota da AV2");
			av3[posicao] = entradaDeDadosTexto("Informe a nota da AV3");

			mensagem("Aluno cadastrado com sucesso!");
		}	
	}
	
	public static void ListaAlunos(){
		boolean achou = false;
		String alunos = "";
		for (int posicao = 0; posicao < QTEREGISTROS; posicao ++) {
			if(matricula[posicao]!=null) {
				alunos += "Aluno encontrado, matrícula :" + 
						matricula[posicao] + "\n"+
						" Nome: "+ nome[posicao] + "\n"+
						" Nota da Av1:"+ av1[posicao] + "\n"+ 
						" Nota da Av2:"+ av2[posicao] + "\n"+
						" Nota da Av3:"+ av3[posicao]+ "\n";
				achou = true;
			}
		}
		if(achou == false) {
			mensagem("Nenhum aluno foi encontrado");
		}else{
		mensagem(alunos);
		}
	}
	
	public static void AtualizarAluno() {
		String consultaMatricula = entradaDeDadosTexto("Informe a matrícula a ser alterada: ");
		boolean check = false;
		for (int posicao = 0; posicao < QTEREGISTROS; posicao++) {
			if(matricula[posicao]!=null && matricula[posicao].equals(consultaMatricula)) {
				
				nome[posicao] = entradaDeDadosTexto("Informe seu nome");
				av1[posicao] = entradaDeDadosTexto("Informe a nota da AV1");
				av2[posicao] = entradaDeDadosTexto("Informe a nota da AV2");
				av3[posicao] = entradaDeDadosTexto("Informe a nota da AV3");
				
				check = true;
				break;
			}
		}
		if(check == false){
			mensagem("Não há alunos com esses dados");
		}	
	}
	
	public static void DeletarAluno() {
		String consultaMatricula = entradaDeDadosTexto("Informe a matrícula a ser alterada: ");
		boolean check = false;
		for (int posicao = 0; posicao < QTEREGISTROS; posicao++) {
			if(matricula[posicao]!=null && matricula[posicao].equals(consultaMatricula)) {
				
				matricula[posicao] = null;
				nome[posicao] = null;
				av1[posicao] = null;
				av2[posicao] = null;
				av3[posicao] = null;
				
				check = true;
				break;
			}
		}
		if(check == false){
			mensagem("Não há alunos com esses dados");
		}
	}
}
