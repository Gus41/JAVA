package interacao;
import java.util.Scanner;
import entidades.ContaC;

public class Interface {
	
	private ContaC contas[] = new ContaC[100];
	private int criadas = 0;
	public int numero;
	public String str; 
	private int n,i,posicao;
	
	
	public void menu() {
		
		System.out.println("Teste");
		
		Scanner ler = new Scanner(System.in);
		
		
		
		System.out.println("====MENU====");
		System.out.println("1 - Criar nova conta");
		System.out.println("2 - sacar ");
		System.out.println("3 Depositar");
		System.out.println("4 Ver saldo e numero de todas as contas ");
		numero = ler.nextInt();
		ler.nextLine();
		
		while( numero != 0 ) {
			if ( numero == 1 ) {
				
				contas[criadas] = new ContaC();
				
				System.out.println("==Criar Nova Conta===");
				System.out.println("Digite seu nome: ");
				contas[criadas].cl.setNome(ler.nextLine());
				System.out.println("Digite seu cpf: ");
				contas[criadas].cl.setCpf(ler.nextLine());
				System.out.println("Digite o Numero que deseja para a sua cota: ");
				n = ler.nextInt();
				
				for ( i = 0 ; i < criadas ; i ++ ) {
					if ( contas[i].getNumero() == n ) {
						System.out.println("Esse numero já esta em uso, Por favor digite outro: ");
						n = ler.nextInt();
					}else {
						contas[criadas].setNumero(n);
						System.out.println("Conta Criada com sucesso");
						break;
					}
				}
				criadas++;
			}else if( numero == 2 && criadas > 0 ) {
				System.out.println("Digite o numero da sua conta: ");
				n = ler.nextInt();
				
				for ( i = 0 ; i < criadas ; i ++ ) {
					if ( n == contas[i].getNumero()) {
						posicao = i;
						break;
					}
				}
				if ( posicao == i ) {
					System.out.println("Conta encontrada: ");
					System.out.println("Digite o valor a ser depositado: ");
					contas[posicao].depositar(ler.nextDouble());
				} else {
					System.out.println("Conta não encontrada");
				}
				
			}else if (numero == 3 && criadas > 0 ) {
				System.out.println("Digite o numero da sua conta: ");
				n = ler.nextInt();
				
				for ( i = 0 ; i < criadas ; i ++ ) {
					if ( n == contas[i].getNumero()) {
						posicao = i;
						break;
					}
				}
				if ( posicao == i ) {
					System.out.println("Conta encontrada: ");
					System.out.println("Digite o valor a ser Sacado: ");
					contas[posicao].sacar(ler.nextDouble());
				} else {
					System.out.println("Conta não encontrada");
				}
				
			}else if(numero == 4 && criadas > 0 ) {
				System.out.println("=== "+ criadas +" Contas Criadas ===");
				for ( i = 0 ; i < criadas ; i ++ ) {
					System.out.println("Numero: "+contas[i].getNumero() + "Saldo: " + contas[i].getSaldo() + "\n" );
				}
				
			}else {
				System.out.println("Nenhuma conta criada");
			}
			System.out.println("====MENU====");
			System.out.println("1 - Criar nova conta");
			System.out.println("2 - sacar ");
			System.out.println("3 Depositar");
			System.out.println("4 Ver saldo e numero de todas as contas ");
			numero = ler.nextInt();
			ler.nextLine();
		}

		
		ler.close();
		
	}

}
