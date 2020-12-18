import java.util.Scanner;

public class Main{
	static Scanner entrada = new Scanner(System.in);//declaração "global" do objeto entrada de tipo Scanner(classe)
	
	public static void main(String[] args){
		int escolha, count = 0;
		Pessoa bruno[] = new Pessoa[6]; //declarando um array de objetos do tipo Pessoa;

		
		 
		String escolhaPalavra;
		
		while(true) {

			System.out.println("O que deseja fazer ?\n 0 = Registrar\n 1 = Printar");
			escolha = entrada.nextInt();
			
			while(escolha != 0 && escolha != 1) {//checando a veracidade da entrada
				System.out.print("Entrada inválida, digite outra: ");
				escolha = entrada.nextInt();
			}
			
			if(escolha == 0) { // registrar
				if(count == 6) {
					System.out.println("Número máximo de pessoas registradas.");
				}
				else {
					bruno[count] = new Pessoa();//incializa o objeto bruno[count]
					bruno[count] = registrarPessoa();
					count++;
				}
			}
			else if(escolha == 1){//printar
				if(count == 0) {
					System.out.println("Não há ninguém registrado.");
				}
				else if(count > 0) {
					System.out.println("Quem deseja printar?");
				
					for(int i = 0; i < count; i++) {
						System.out.printf("[%d] -> %s\n", i, bruno[i].nome);
					}
					escolha = entrada.nextInt();
				
					while(escolha < 0 || escolha >= count) {//checando a veracidade dos intupts
						System.out.println("Entrada inválida, digite outra: ");
						escolha = entrada.nextInt();
					}
				
					printarPessoa(bruno[escolha]);
				}
			}
			System.out.println("\nDeseja voltar ao inicio?");
			escolhaPalavra = entrada.next();
			
			if(talvez(escolhaPalavra) == 0) {
				System.out.println("Encerrando o programa...");
				break;
			}
		}
	}
	
	static void printarPessoa(Pessoa dados) {//metodo printa os dados de um objeto de tipo Pessoa
		System.out.printf("Nome: %s\n", dados.nome);
		System.out.printf("Idade: %d\n", dados.idade);
	}

	static Pessoa registrarPessoa() {//registra/retorna os dados de um objeto de tipo pessoa
		Pessoa nova = new Pessoa(); 
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Digite o nome da pessoa: ");
		nova.nome = input.nextLine();
		
		System.out.printf("Digite a idade de %s: ", nova.nome);
		nova.idade = input.nextInt();
		
		return nova;
	}
	
	static int talvez(String escolha) {//retorna um valor baseado no que foi digitado, 1 para sim e 0 para não, o 2 é por pura sintaxe, não é pra cair lá nem fodendo
		Scanner input = new Scanner(System.in);
		
		while(escolha.equalsIgnoreCase("não") == false && escolha.equalsIgnoreCase("sim") == false) {
			System.out.println("Entrada inválida, digite novamente: ");
			escolha = input.next();
		}
		
		if(escolha.equalsIgnoreCase("não")) {
			return 0;
		}
		else if(escolha.equalsIgnoreCase("sim")){
			return 1;
		}
		else {
			return 2;
		}
	}
}
