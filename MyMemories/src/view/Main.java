package view;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean c = true;
		int n;
		
		while(c) {
			System.out.println("1) Criar nova Lembrança");
			System.out.println("2) Listar Lembranças");
			System.out.println("3) Deletar Lembrança");
			System.out.println("4) Editar Lembrança");
			System.out.println("5) Sair");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("\nDigite uma opção: ");
			n = sc.nextInt();
			System.out.print("\n\n");
			
			switch(n) {
			case 1:
				System.out.println("========== Criar nova lembrança ==========");
				System.out.println("\tTipo de Lembrança");
				System.out.println("1) Data Comemorativa");
				System.out.println("2) Evento");
				System.out.println("3) Com Amigos");
				System.out.println("4) Amorosa");
				System.out.println("5) Religiosa");
				System.out.println("6) Familiar");
				System.out.println("7) De alguém");
				sc = new Scanner(System.in);
				System.out.print("\nDigite uma opção: ");
				n = sc.nextInt();
				System.out.print("\n\n");
				switch(n) {
				case 1:
					System.out.println("Data Comemorativa");
					break;
				case 2:
					System.out.println("Evento");
					break;
				case 3:
					System.out.println("Com Amigos");
					break;
				case 4:
					System.out.println("Amorosa");
					break;
				case 5:
					System.out.println("Religiosa");
					break;
				case 6:
					System.out.println("Familiar");
					break;
				case 7:
					System.out.println("De alguém");
					break;
				default:
					System.out.println("\nOpção invalida\n");
				}
				break;
			case 2:
				System.out.println("========== Listar lembranças ==========");
				System.out.println("1) por ano");
				System.out.println("2) por mês");
				System.out.println("3) Por dia");
				System.out.println("4) por tipo");
				sc = new Scanner(System.in);
				System.out.print("\nDigite uma opção: ");
				n = sc.nextInt();
				System.out.print("\n\n");
				
				switch(n) {
				case 1:
					System.out.println("Listando por ano...");
					break;
				case 2:
					System.out.println("Listando por mês...");
					break;
				case 3:
					System.out.println("Listando por dia...");
					break;
				case 4:
					System.out.println("\tTipo de Lembrança");
					System.out.println("1) Data Comemorativa");
					System.out.println("2) Evento");
					System.out.println("3) Com Amigos");
					System.out.println("4) Amorosa");
					System.out.println("5) Religiosa");
					System.out.println("6) Familiar");
					System.out.println("7) De alguém");
					sc = new Scanner(System.in);
					System.out.print("\nDigite uma opção: ");
					n = sc.nextInt();
					System.out.print("\n\n");
					
					switch(n) {
					case 1:
						System.out.println("Data Comemorativa");
						break;
					case 2:
						System.out.println("Evento");
						break;
					case 3:
						System.out.println("Com Amigos");
						break;
					case 4:
						System.out.println("Amorosa");
						break;
					case 5:
						System.out.println("Religiosa");
						break;
					case 6:
						System.out.println("Familiar");
						break;
					case 7:
						System.out.println("De alguém");
						break;
					default:
						System.out.println("\nOpção invalida\n");
					}
					break;
				}
				break;
			case 3:
				System.out.println("========== Deletar Lembrança ==========");
				System.out.println("Escolha o tipo da Lembrança que você quer deletar:");
				System.out.println("1) Data Comemorativa");
				System.out.println("2) Evento");
				System.out.println("3) Com Amigos");
				System.out.println("4) Amorosa");
				System.out.println("5) Religiosa");
				System.out.println("6) Familiar");
				System.out.println("7) De alguém");
				sc = new Scanner(System.in);
				System.out.print("\nDigite uma opção: ");
				n = sc.nextInt();
				System.out.print("\n\n");
				switch(n) {
				case 1:
					System.out.println("Data Comemorativa");
					break;
				case 2:
					System.out.println("Evento");
					break;
				case 3:
					System.out.println("Com Amigos");
					break;
				case 4:
					System.out.println("Amorosa");
					break;
				case 5:
					System.out.println("Religiosa");
					break;
				case 6:
					System.out.println("Familiar");
					break;
				case 7:
					System.out.println("De alguém");
					break;
				default:
					System.out.println("\nOpção invalida\n");
				}
				break;
				
			case 4:
				System.out.println("========== Editar Lembranças ==========");
				System.out.println("Escolha o tipo da Lembrança que você quer editar:");
				System.out.println("1) Data Comemorativa");
				System.out.println("2) Evento");
				System.out.println("3) Com Amigos");
				System.out.println("4) Amorosa");
				System.out.println("5) Religiosa");
				System.out.println("6) Familiar");
				System.out.println("7) De alguém");
				sc = new Scanner(System.in);
				System.out.print("\nDigite uma opção: ");
				n = sc.nextInt();
				System.out.print("\n\n");
				switch(n) {
				case 1:
					System.out.println("Data Comemorativa");
					break;
				case 2:
					System.out.println("Evento");
					break;
				case 3:
					System.out.println("Com Amigos");
					break;
				case 4:
					System.out.println("Amorosa");
					break;
				case 5:
					System.out.println("Religiosa");
					break;
				case 6:
					System.out.println("Familiar");
					break;
				case 7:
					System.out.println("De alguém");
					break;
				default:
					System.out.println("\nOpção invalida\n");
				}
				break;
			case 5:
				c = false;
				break;
			default:
				System.out.println("\nOpção invalida\n");
			}
		}
		System.out.println("Programa encerrado -_-");

	}

}
