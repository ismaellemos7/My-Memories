package view;

import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.*;

public class Main {

	public static void main(String[] args) {
		String teste1 = "ismael", teste2 = "12345";
		Scanner sc = new Scanner(System.in);
		boolean c = true, login = false;
		int n;
		while(login == false) {
			System.out.print("Nome usuário: ");
			String username = sc.nextLine();
			System.out.print("Senha: ");
			String password = sc.nextLine();
			break;
		}


		while(c) {
			System.out.println("1) Criar nova Lembrança");
			System.out.println("2) Listar Lembranças");
			System.out.println("3) Deletar Lembrança");
			System.out.println("4) Editar Lembrança");
			System.out.println("5) Sair");

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

				System.out.print("Titulo: ");
				sc = new Scanner(System.in);
				String titulo = sc.nextLine();
				System.out.print("Texto: ");
				sc = new Scanner(System.in);
				String texto = sc.nextLine();
				Date da = null;
				try {
					System.out.println("Data");
					String date = sc.next();
					DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
					Date d = data.parse(date);
					da=data.parse(date);
				} catch (Exception ex){
					ex.printStackTrace();
				}
				System.out.println("Local: ");
				sc = new Scanner(System.in);
				String local = sc.nextLine();

				switch(n) {
				case 1:
					Data_Comemorativa data_comemorativa = new Data_Comemorativa();
					data_comemorativa.setTitulo(titulo);
					data_comemorativa.setTexto(texto);
					data_comemorativa.setData(da);
					data_comemorativa.setLocal(local);
					String teste = "" + data_comemorativa.getClass();
					System.out.println(teste);
					if(teste == "class model.Data_Comemorativa") {
						System.out.println("Deu certo");
					}
					break;
				case 2:
					Evento evento = new Evento();
					evento.setTitulo(titulo);
					evento.setTexto(texto);
					evento.setData(da);
					evento.setLocal(local);
					System.out.println("Evento criado");
					break;
				case 3:
					Compartilhada compartilhada = new Compartilhada();
					compartilhada.setTitulo(titulo);
					compartilhada.setTexto(texto);
					compartilhada.setData(da);
					compartilhada.setLocal(local);
					System.out.println("Lembrança compartilhada adicionada");
					break;
				case 4:
					Amorosa amorosa = new Amorosa();
					amorosa.setTitulo(titulo);
					amorosa.setTexto(texto);
					amorosa.setData(da);
					amorosa.setLocal(local);
					break;
				case 5:
					Religiosa religiosa = new Religiosa();
					religiosa.setTitulo(titulo);
					religiosa.setTexto(texto);
					religiosa.setData(da);
					religiosa.setLocal(local);
					System.out.println("Religiosa criada");
					break;
				case 6:
					Familiar familiar = new Familiar();
					familiar.setTitulo(titulo);
					familiar.setTexto(texto);
					familiar.setData(da);
					familiar.setLocal(local);
					System.out.println("Familiar criada");
					break;
				case 7:
					De_Alguem de_alguem = new De_Alguem();
					de_alguem.setTitulo(titulo);
					de_alguem.setTexto(texto);
					de_alguem.setData(da);
					de_alguem.setLocal(local);
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
						Data_Comemorativa data_comemorativa = new Data_Comemorativa();
						System.out.print("Titulo: ");
						sc = new Scanner(System.in);
						String Titulo = sc.nextLine();
						System.out.print("Texto: ");
						sc = new Scanner(System.in);
						String Texto = sc.nextLine();
						try {
							System.out.println("Data");
							String date = sc.next();
							DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
							Date d = data.parse(date);
							System.out.println(d);
							da=data.parse(date);
						} catch (Exception ex){
							ex.printStackTrace();
						}
						System.out.println("Local: ");
						local = sc.nextLine();
						System.out.println("Data Comemorativa Criada");
						break;
					case 2:
						Evento evento = new Evento();
						System.out.print("Titulo: ");
						sc = new Scanner(System.in);
						Titulo = sc.nextLine();
						System.out.print("Texto: ");
						sc = new Scanner(System.in);
						Texto = sc.nextLine();
						try {
							System.out.println("Data");
							String date = sc.next();
							DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
							Date d = data.parse(date);
							System.out.println(d);
							da=data.parse(date);
						} catch (Exception ex){
							ex.printStackTrace();
						}
						System.out.println("Local: ");
						local = sc.nextLine();
						System.out.println("Evento criado");
						break;
					case 3:
						Compartilhada compartilhada = new Compartilhada();
						System.out.print("Titulo: ");
						sc = new Scanner(System.in);
						Titulo = sc.nextLine();
						System.out.print("Texto: ");
						sc = new Scanner(System.in);
						Texto = sc.nextLine();
						try {
							System.out.println("Data");
							String date = sc.next();
							DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
							Date d = data.parse(date);
							System.out.println(d);
							da=data.parse(date);
						} catch (Exception ex){
							ex.printStackTrace();
						}
						System.out.println("Local: ");
						local = sc.nextLine();
						System.out.println("Lembrança compartilhada adicionada");
						break;
					case 4:
						Amorosa amorosa = new Amorosa();
						System.out.print("Titulo: ");
						sc = new Scanner(System.in);
						Titulo = sc.nextLine();
						System.out.print("Texto: ");
						sc = new Scanner(System.in);
						Texto = sc.nextLine();
						try {
							System.out.println("Data");
							String date = sc.next();
							DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
							Date d = data.parse(date);
							System.out.println(d);
							da=data.parse(date);
						} catch (Exception ex){
							ex.printStackTrace();
						}
						System.out.println("Local: ");
						local = sc.nextLine();
						System.out.println("Lembraça Amorosa criada");
						break;
					case 5:
						Religiosa religiosa = new Religiosa();
						System.out.print("Titulo: ");
						sc = new Scanner(System.in);
						Titulo = sc.nextLine();
						System.out.print("Texto: ");
						sc = new Scanner(System.in);
						Texto = sc.nextLine();
						try {
							System.out.println("Data");
							String date = sc.next();
							DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
							Date d = data.parse(date);
							System.out.println(d);
							da=data.parse(date);
						} catch (Exception ex){
							ex.printStackTrace();
						}
						System.out.println("Local: ");
						local = sc.nextLine();
						System.out.println("Religiosa criada");
						break;
					case 6:
						Familiar familiar = new Familiar();
						System.out.print("Titulo: ");
						sc = new Scanner(System.in);
						Titulo = sc.nextLine();
						System.out.print("Texto: ");
						sc = new Scanner(System.in);
						Texto = sc.nextLine();
						try {
							System.out.println("Data");
							String date = sc.next();
							DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
							Date d = data.parse(date);
							System.out.println(d);
							da=data.parse(date);
						} catch (Exception ex){
							ex.printStackTrace();
						}
						System.out.println("Local: ");
						local = sc.nextLine();
						System.out.println("Familiar criada");
						break;
					case 7:
						De_Alguem de_alguem = new De_Alguem();
						System.out.print("Titulo: ");
						sc = new Scanner(System.in);
						Titulo = sc.nextLine();
						System.out.print("Texto: ");
						sc = new Scanner(System.in);
						Texto = sc.nextLine();
						try {
							System.out.println("Data");
							String date = sc.next();
							DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
							Date d = data.parse(date);
							System.out.println(d);
							da=data.parse(date);
						} catch (Exception ex){
							ex.printStackTrace();
						}
						System.out.println("Local: ");
						local = sc.nextLine();
						System.out.println("De alguém");
						break;
					default:
						System.out.println("\nOpção invalida\n");
					}
					break;
				}
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