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
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite uma opção: ");
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
				System.out.print("Digite uma opção: ");
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
					System.out.println("Opção invalida");
				}
				break;
			case 2:
				System.out.println("========== Listar lembranças ==========");
				break;
			case 3:
				System.out.println("========== Deletar Lembrança ==========");
				break;
			case 4:
				System.out.println("========== Editar Lembranças ==========");
				break;
			default:
				System.out.println("Opção invalida");
			}
			
			
			/*
			Editar Lembrança
			Compartilhar Lembrança
			listar contato
			excluir contato
			editar contato
			Notificação de ativação de conta de contato
			*/
		}

	}

}
