package view;

import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.*;
import model_dao.*;

public class Main {

	public static void main(String[] args) throws Throwable {
		String teste1 = "ismael", teste2 = "12345";
		UsuarioDao usuarioDao = new UsuarioDao();
		LembrancaDao lembrancaDao = new LembrancaDao();
		ContatoDao contatoDao = new ContatoDao();
		Scanner sc = new Scanner(System.in);
		boolean c = true, login = false;
		Usuario usuario = null;
		int n, n2;
		/*while(login == false) {
			System.out.println("1) Realizar Login");
			System.out.println("2) Cadastrar Usuario");
			System.out.println("3) Encerrar Programa");
			System.out.print("\nDigite uma opção: ");
			n2 = sc.nextInt();
			System.out.print("\n\n");
			switch(n2) {
			case 1:
				System.out.print("Número de telefone: ");
				sc = new Scanner(System.in);
				int telefone = sc.nextInt();
				System.out.print("Senha: ");
				sc = new Scanner(System.in);
				String password = sc.nextLine();
				usuario = usuarioDao.autenticarUsuario(telefone, password);
				if(usuario == null) {
					System.out.println("Você inserio um número ou senha invalido");
				}
				else {
					login = true;
				}
				break;
			case 2:
				Usuario user = new Usuario();
				System.out.print("Inserir nome ");
				sc = new Scanner(System.in);
				String nome = sc.nextLine();
				user.setNome(nome);
				System.out.print("Inserir telefone ");
				sc = new Scanner(System.in);
				telefone = sc.nextInt();
				user.setTelefone(telefone);
				System.out.print("Inserir email ");
				sc = new Scanner(System.in);
				String email = sc.nextLine();
				user.setEmail(email);
				System.out.print("Inserir senha ");
				sc = new Scanner(System.in);
				String senha = sc.nextLine();
				user.setSenha(senha);
				if(usuarioDao.createUser(user)==true) System.out.println("Novo usuario criado com sucesso");
				else System.out.println("Deu ruim!");
				break;
			case 3:
				c = false;
				login = true;
			default:
				System.out.println("Opção invalida");
			}
		}*/


		while(c) {
			System.out.println("1) Criar nova Lembrança");
			System.out.println("2) Listar Lembranças");
			System.out.println("3) Deletar Lembrança");
			System.out.println("4) Editar Lembrança");
			System.out.println("5) Criar novo contato");
			System.out.println("6) Editar contato");
			System.out.println("7) Deletar contato");
			System.out.println("8) Listar contatos");
			System.out.println("9) Editar dados da conta");
			System.out.println("10) Deletar sua conta");
			System.out.println("11) Sair");

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
				Tipo_Lembranca tipo = new Tipo_Lembranca();

				switch(n) {
				case 1:
					Data_Comemorativa data_comemorativa = new Data_Comemorativa();
					data_comemorativa.setTitulo(titulo);
					data_comemorativa.setTexto(texto);
					data_comemorativa.setData(da);
					data_comemorativa.setLocal(local);
					tipo.setId(2);
					tipo.setNome("Data_Comemorativa");
					lembrancaDao.create(data_comemorativa);
					break;
				case 2:
					Evento evento = new Evento();
					evento.setTitulo(titulo);
					evento.setTexto(texto);
					evento.setData(da);
					evento.setLocal(local);
					tipo.setId(3);
					tipo.setNome("Evento");
					//lembrancaDao.criarLembranca(usuario, evento, tipo);
					break;
				case 3:
					Compartilhada compartilhada = new Compartilhada();
					compartilhada.setTitulo(titulo);
					compartilhada.setTexto(texto);
					compartilhada.setData(da);
					compartilhada.setLocal(local);
					tipo.setId(4);
					tipo.setNome("Compartilhada");
					//lembrancaDao.criarLembranca(usuario, compartilhada, tipo);
					break;
				case 4:
					Amorosa amorosa = new Amorosa();
					amorosa.setTitulo(titulo);
					amorosa.setTexto(texto);
					amorosa.setData(da);
					amorosa.setLocal(local);
					tipo.setId(6);
					tipo.setNome("Amorosa");
					//lembrancaDao.criarLembranca(usuario, amorosa, tipo);
					break;
				case 5:
					Religiosa religiosa = new Religiosa();
					religiosa.setTitulo(titulo);
					religiosa.setTexto(texto);
					religiosa.setData(da);
					religiosa.setLocal(local);
					tipo.setId(7);
					tipo.setNome("Religiosa");
					//lembrancaDao.criarLembranca(usuario, religiosa, tipo);
					break;
				case 6:
					Familiar familiar = new Familiar();
					familiar.setTitulo(titulo);
					familiar.setTexto(texto);
					familiar.setData(da);
					familiar.setLocal(local);
					tipo.setId(1);
					tipo.setNome("Familiar");
					//lembrancaDao.criarLembranca(usuario, familiar, tipo);
					break;
				case 7:
					De_Alguem de_alguem = new De_Alguem();
					de_alguem.setTitulo(titulo);
					de_alguem.setTexto(texto);
					de_alguem.setData(da);
					de_alguem.setLocal(local);
					tipo.setId(5);
					tipo.setNome("Pessoal");
					//lembrancaDao.criarLembranca(usuario, de_alguem, tipo);
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
					for(Lembranca lb: lembrancaDao.read()) {
						System.out.println(lb.getData());
					}
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
				Contato contato = new Contato();
				System.out.print("Digite o nome do contato que você quer inserir");
				sc = new Scanner(System.in);
				String nome = sc.nextLine();
				contato.setNome(nome);
				System.out.print("Digite o telefone");
				sc = new Scanner(System.in);
				int telefone = sc.nextInt();
				contato.setTelefone(telefone);
				contato.setId_usuario(11);
				contatoDao.create(contato);
				
			case 6:
				contato = new Contato();
				System.out.print("Digite o novo nome do contato");
				sc = new Scanner(System.in);
				nome = sc.nextLine();
				contato.setNome(nome);
				System.out.print("Digite o novo telefone");
				sc = new Scanner(System.in);
				telefone = sc.nextInt();
				contato.setTelefone(telefone);
				//contatoDao.editarContoto(contato);
			case 7:	
				contato = new Contato();
				System.out.print("Digite o novo telefone");
				sc = new Scanner(System.in);
				telefone = sc.nextInt();
				contato.setTelefone(telefone);
				//contatoDao.deletarContato(contato);
				
			case 8:
				System.out.println("Listando contatos");
				contatoDao.read();
				for(Contato co: contatoDao.read()) {
					System.out.println(co.getNome() + " " + co.getTelefone());
				}
				
			case 9:
				System.out.println("Edite os dados da sua conta");
				Usuario user = new Usuario();
				System.out.print("Inserir nome ");
				sc = new Scanner(System.in);
				nome = sc.nextLine();
				user.setNome(nome);
				System.out.print("Inserir telefone ");
				sc = new Scanner(System.in);
				telefone = sc.nextInt();
				user.setTelefone(telefone);
				System.out.print("Inserir email ");
				sc = new Scanner(System.in);
				String email = sc.nextLine();
				user.setEmail(email);
				System.out.print("Inserir senha ");
				sc = new Scanner(System.in);
				String senha = sc.nextLine();
				user.setSenha(senha);
				usuarioDao.editarUsuario(usuario);
				
			case 10:
				System.out.println("Tem certeza que quer fazer isso? (S ou N)");
				String resposta = sc.next();
				if(resposta == "S") {
					usuarioDao.deleteUser(usuario);
				}
			case 11:
				c = false;
				break;
			default:
				System.out.println("\nOpção invalida\n");
			}

		}
		System.out.println("Programa encerrado -_-");
	}
}