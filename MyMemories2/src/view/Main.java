package view;

import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.*;
import model_dao.*;

public class Main {

    public static void main(String[] args) throws Throwable {
        
        UsuarioDao usuarioDao = new UsuarioDao();
        LembrancaDao lembrancaDao = new LembrancaDao();
        ContatoDao contatoDao = new ContatoDao();
        Scanner sc = new Scanner(System.in);
        boolean c = true, login = false;
        Usuario usuario = null;
        int n, n2, n3;
        while (login == false) {
            System.out.println("1) Realizar Login"); // check
            System.out.println("2) Cadastrar Usuario"); // check
            System.out.println("3) Encerrar Programa"); // check
            System.out.print("\nDigite uma op��o: ");
            n2 = sc.nextInt();
            System.out.print("\n\n");
            switch (n2) {
                case 1:
                    System.out.print("N�mero de telefone: ");
                    sc = new Scanner(System.in);
                    int telefone = sc.nextInt();
                    System.out.print("Senha: ");
                    sc = new Scanner(System.in);
                    String password = sc.nextLine();
                    usuario = usuarioDao.autenticarUsuario(telefone, password);
                    if (usuario == null) {
                        System.out.println("Voc� inserio um n�mero ou senha invalido");
                    } else {
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
                    if (usuarioDao.createUser(user) == true) {
                        System.out.println("Novo usuario criado com sucesso");
                    } else {
                        System.out.println("Deu ruim!");
                    }
                    break;
                case 3:
                    c = false;
                    login = true;
                    System.out.println("O programa foi encerrado -_-");
                default:
                    System.out.println("Op��o inv�lida");
            }
            if (login == true) {
                while (c) {
                    System.out.println("1) Criar nova Lembrança"); // check
                    System.out.println("2) Listar Lembranças"); // check
                    System.out.println("3) Deletar Lembrança"); // check
                    System.out.println("4) Editar Lembrança"); // check
                    System.out.println("5) Criar novo contato"); // check
                    System.out.println("6) Editar contato"); // check
                    System.out.println("7) Deletar contato"); // check
                    System.out.println("8) Listar contatos"); // check
                    System.out.println("9) Editar dados da conta"); // check
                    System.out.println("10) Deletar sua conta"); // check
                    System.out.println("11) Compartilhar Lembran�a"); //
                    System.out.println("12) Lembretes"); //
                    System.out.println("13) Sair"); // check

                    System.out.print("\nDigite uma opção: ");
                    n = sc.nextInt();
                    System.out.print("\n\n");

                    switch (n) {
                        case 1:
                            System.out.println("========== Criar nova lembrança ==========");
                            System.out.println("\tTipo de Lembran�a");
                            System.out.println("1) Data Comemorativa");
                            System.out.println("2) Evento");
                            System.out.println("3) Com Amigos");
                            System.out.println("4) Amorosa");
                            System.out.println("5) Religiosa");
                            System.out.println("6) Familiar");
                            System.out.println("7) Pessoal");
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
                                //Date d = data.parse(date);
                                da = data.parse(date);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            System.out.println("Local: ");
                            sc = new Scanner(System.in);
                            String local = sc.nextLine();
                            Tipo_Lembranca tipo = new Tipo_Lembranca();

                            switch (n) {
                                case 1:
                                    Data_Comemorativa data_comemorativa = new Data_Comemorativa();
                                    data_comemorativa.setTitulo(titulo);
                                    data_comemorativa.setTexto(texto);
                                    data_comemorativa.setData(da);
                                    data_comemorativa.setLocal(local);
                                    tipo.setId(2);
                                    tipo.setNome("Data_Comemorativa");
                                    lembrancaDao.criarLembranca(usuario, data_comemorativa, tipo);
                                    break;
                                case 2:
                                    Evento evento = new Evento();
                                    evento.setTitulo(titulo);
                                    evento.setTexto(texto);
                                    evento.setData(da);
                                    evento.setLocal(local);
                                    tipo.setId(3);
                                    tipo.setNome("Evento");
                                    lembrancaDao.criarLembranca(usuario, evento, tipo);
                                    break;
                                case 3:
                                    Compartilhada compartilhada = new Compartilhada();
                                    compartilhada.setTitulo(titulo);
                                    compartilhada.setTexto(texto);
                                    compartilhada.setData(da);
                                    compartilhada.setLocal(local);
                                    tipo.setId(4);
                                    tipo.setNome("Compartilhada");
                                    lembrancaDao.criarLembranca(usuario, compartilhada, tipo);
                                    break;
                                case 4:
                                    Amorosa amorosa = new Amorosa();
                                    amorosa.setTitulo(titulo);
                                    amorosa.setTexto(texto);
                                    amorosa.setData(da);
                                    amorosa.setLocal(local);
                                    tipo.setId(6);
                                    tipo.setNome("Amorosa");
                                    lembrancaDao.criarLembranca(usuario, amorosa, tipo);
                                    break;
                                case 5:
                                    Religiosa religiosa = new Religiosa();
                                    religiosa.setTitulo(titulo);
                                    religiosa.setTexto(texto);
                                    religiosa.setData(da);
                                    religiosa.setLocal(local);
                                    tipo.setId(7);
                                    tipo.setNome("Religiosa");
                                    lembrancaDao.criarLembranca(usuario, religiosa, tipo);
                                    break;
                                case 6:
                                    Familiar familiar = new Familiar();
                                    familiar.setTitulo(titulo);
                                    familiar.setTexto(texto);
                                    familiar.setData(da);
                                    familiar.setLocal(local);
                                    tipo.setId(1);
                                    tipo.setNome("Familiar");
                                    lembrancaDao.criarLembranca(usuario, familiar, tipo);
                                    break;
                                case 7:
                                    Pessoal pessoal = new Pessoal();
                                    pessoal.setTitulo(titulo);
                                    pessoal.setTexto(texto);
                                    pessoal.setData(da);
                                    pessoal.setLocal(local);
                                    tipo.setId(5);
                                    tipo.setNome("Pessoal");
                                    lembrancaDao.criarLembranca(usuario, pessoal, tipo);
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

                            switch (n) {
                                case 1:
                                    System.out.print("Digite o ano que você quer listar as lembranças: ");
                                    sc = new Scanner(System.in);
                                    String ano = sc.next();
                                    System.out.println("Listando por ano...");
                                    for (Lembranca l : lembrancaDao.listarLembrancasPorAno(usuario, ano)) {
                                        System.out.println(l.getTitulo());
                                    }
                                    break;
                                case 2:
                                    System.out.print("Digite o mes que você quer listar as lembranças: ");
                                    sc = new Scanner(System.in);
                                    String mes = sc.next();
                                    System.out.println("Listando por mes...");
                                    for (Lembranca l : lembrancaDao.listarLembrancasPorMes(usuario, mes)) {
                                        System.out.println(l.getTitulo());
                                    }
                                    break;
                                case 3:
                                    System.out.print("Digite o dia que você quer listar as lembranças: ");
                                    sc = new Scanner(System.in);
                                    String dia = sc.next();
                                    System.out.println("Listando por dia...");
                                    for (Lembranca l : lembrancaDao.listarLembrancasPorDia(usuario, dia)) {
                                        System.out.println(l.getTitulo());
                                    }
                                    break;
                                case 4:
                                    System.out.println("\tTipo de Lembrança");
                                    System.out.println("1) Data Comemorativa");
                                    System.out.println("2) Evento");
                                    System.out.println("3) Com Amigos");
                                    System.out.println("4) Amorosa");
                                    System.out.println("5) Religiosa");
                                    System.out.println("6) Familiar");
                                    System.out.println("7) Pessoal");
                                    sc = new Scanner(System.in);
                                    System.out.print("\nDigite uma opção: ");
                                    n = sc.nextInt();
                                    System.out.print("\n\n");

                                    switch (n) {
                                        case 1:
                                            System.out.println("Data Comemorativa");
                                            Tipo_Lembranca tipoL = new Tipo_Lembranca();
                                            tipoL.setId(2);
                                            tipoL.setNome("Data_Comemorativa");
                                            for (Lembranca l : lembrancaDao.listarLembrancas(tipoL, usuario)) {
                                                System.out.println(l.getTitulo());
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Evento");
                                            tipoL = new Tipo_Lembranca();
                                            tipoL.setId(3);
                                            tipoL.setNome("Evento");
                                            for (Lembranca l : lembrancaDao.listarLembrancas(tipoL, usuario)) {
                                                System.out.println(l.getTitulo());
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Com Amigos");
                                            tipoL = new Tipo_Lembranca();
                                            tipoL.setId(4);
                                            tipoL.setNome("Com Amigos");
                                            for (Lembranca l : lembrancaDao.listarLembrancas(tipoL, usuario)) {
                                                System.out.println(l.getTitulo());
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Amorosa");
                                            tipoL = new Tipo_Lembranca();
                                            tipoL.setId(6);
                                            tipoL.setNome("Amorosa");
                                            for (Lembranca l : lembrancaDao.listarLembrancas(tipoL, usuario)) {
                                                System.out.println(l.getTitulo());
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Religiosa");
                                            tipoL = new Tipo_Lembranca();
                                            tipoL.setId(7);
                                            tipoL.setNome("Religiosa");
                                            for (Lembranca l : lembrancaDao.listarLembrancas(tipoL, usuario)) {
                                                System.out.println(l.getTitulo());
                                            }
                                            break;
                                        case 6:
                                            System.out.println("Familiar");
                                            tipoL = new Tipo_Lembranca();
                                            tipoL.setId(1);
                                            tipoL.setNome("Familiar");
                                            for (Lembranca l : lembrancaDao.listarLembrancas(tipoL, usuario)) {
                                                System.out.println(l.getTitulo());
                                            }
                                            break;
                                        case 7:
                                            System.out.println("Pessoal");
                                            tipoL = new Tipo_Lembranca();
                                            tipoL.setId(5);
                                            tipoL.setNome("Pessoal");
                                            for (Lembranca l : lembrancaDao.listarLembrancas(tipoL, usuario)) {
                                                System.out.println(l.getTitulo());
                                            }
                                            break;
                                        default:
                                            System.out.println("\nOpção invalida\n");
                                    }
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("========== Deletar Lembrança ==========");
                            for (Lembranca l : lembrancaDao.listarTodasLembrancas(usuario)) {
                                System.out.println(l.getTitulo());
                            }
                            System.out.print("Ditige o titulo da lembrança que você que deletar: ");
                            sc = new Scanner(System.in);
                            String t = sc.nextLine();
                            lembrancaDao.deleteLembranca(t, usuario);
                            break;

                        case 4:
                            System.out.println("========== Editar Lembranças ==========");
                            for (Lembranca l : lembrancaDao.listarTodasLembrancas(usuario)) {
                                System.out.println(l.getTitulo());
                            }
                            System.out.print("Ditige o titulo da lembrança que você que editar: ");
                            sc = new Scanner(System.in);
                            String tit = sc.nextLine();
                            Lembranca lembranca = lembrancaDao.getLembranca(usuario, tit);
                            System.out.print("Você deseja alterar o titulo da lembrança digite S para sim e N para não: ");
                            sc = new Scanner(System.in);
                            String r = sc.next();
                            if (r.charAt(0) == 83) {
                                System.out.print("Titulo: ");
                                sc = new Scanner(System.in);
                                titulo = sc.nextLine();
                                lembranca.setTitulo(titulo);
                            }
                            System.out.print("Você deseja alterar o Texto da lembrança digite S para sim e N para não: ");
                            sc = new Scanner(System.in);
                            String rtex = sc.next();
                            if (rtex.charAt(0) == 83) {
                                System.out.print("Texto: ");
                                sc = new Scanner(System.in);
                                texto = sc.nextLine();
                                lembranca.setTexto(texto);
                            }

                            System.out.print("Você deseja alterar o data da lembrança digite S para sim e N para não: ");
                            sc = new Scanner(System.in);
                            String rd = sc.next();
                            if (rd.charAt(0) == 83) {
                                da = null;
                                try {
                                    System.out.println("Data");
                                    String date = sc.next();
                                    DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                                    //Date d = data.parse(date);
                                    da = data.parse(date);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                lembranca.setData(da);
                            }

                            System.out.print("Você deseja alterar o local da lembrança digite S para sim e N para não: ");
                            sc = new Scanner(System.in);
                            String rl = sc.next();
                            if (rl.charAt(0) == 83) {
                                System.out.println("Local: ");
                                sc = new Scanner(System.in);
                                local = sc.nextLine();
                                lembranca.setLocal(local);
                            }
                            if (rl.charAt(0) == 83 || rd.charAt(0) == 83 || rtex.charAt(0) == 83 || r.charAt(0) == 83) {
                                lembrancaDao.editarLembranca(lembranca, tit);
                                System.out.println("Lembrança editada com sucesso");
                            }
                            else{
                                System.out.println("Não houve alterações");
                            }
                            break;

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
                            contato.setId_usuario(usuario.getId());
                            contato.setContato_usuario(null);
                            contatoDao.criarContato(contato);
                            break;
                        case 6:
                            System.out.print("Digine o nome do contato que você que editar: ");
                            sc = new Scanner(System.in);
                            String nomeContato = sc.nextLine();
                            contato = contatoDao.getContato(usuario, nomeContato);
                            System.out.print("Se você deseja alterar o nome do contato digite S para sim e N para não: ");
                            sc = new Scanner(System.in);
                            String rno = sc.next();
                            if (rno.charAt(0) == 83) {
                                System.out.print("Digite o novo nome do contato: ");
                                sc = new Scanner(System.in);
                                nome = sc.nextLine();
                                contato.setNome(nome);
                            }
                            System.out.print("Se você deseja alterar o telefone do contato digite S para sim e N para não: ");
                            sc = new Scanner(System.in);
                            String rte = sc.next();
                            if (rte.charAt(0) == 83) {
                                System.out.print("Digite o novo telefone: ");
                                sc = new Scanner(System.in);
                                telefone = sc.nextInt();
                                contato.setTelefone(telefone);
                            }
                            if (rno.charAt(0) == 83 || rte.charAt(0) == 83) {
                                contatoDao.editarContoto(contato);
                                System.out.println("Contato alterado com sucesso");
                            } else {
                                System.out.println("Não forão feitas Alterações");
                            }
                            break;
                        case 7:
                            contato = new Contato();
                            System.out.print("Digite o Nome do contato que você quer deletar: ");
                            sc = new Scanner(System.in);
                            nome = sc.nextLine();
                            contato = contatoDao.getContato(usuario, nome);
                            contatoDao.deletarContato(contato);
                            System.out.println("Contato deletado com Sucesso");
                            break;
                        case 8:
                            System.out.println("Listando contatos");
                            for (Contato co : contatoDao.listarContatos(usuario)) {
                                System.out.println(co.getNome());
                            }
                            break;
                        case 9:
                            System.out.println("Edite os dados da sua conta");
                            System.out.print("Você deseja alterar seu nome digite S pra sim e N para não: ");
                            sc = new Scanner(System.in);
                            String rn = sc.next().toUpperCase();
                            if (rn.charAt(0) == 83) {
                                System.out.print("Inserir nome ");
                                sc = new Scanner(System.in);
                                nome = sc.nextLine();
                                usuario.setNome(nome);
                            }

                            System.out.print("Você deseja alterar seu telefone digite S pra sim e N para não: ");
                            sc = new Scanner(System.in);
                            String rt = sc.next().toUpperCase();
                            if (rt.charAt(0) == 83) {
                                System.out.print("Inserir telefone ");
                                sc = new Scanner(System.in);
                                telefone = sc.nextInt();
                                usuario.setTelefone(telefone);
                            }
                            System.out.print("Você deseja alterar seu email digite S pra sim e N para não: ");
                            sc = new Scanner(System.in);
                            String re = sc.next().toUpperCase();
                            if (re.charAt(0) == 83) {
                                System.out.print("Inserir email ");
                                sc = new Scanner(System.in);
                                String email = sc.nextLine();
                                usuario.setEmail(email);
                            }

                            System.out.print("Você deseja alterar sua senha digite S pra sim e N para não: ");
                            sc = new Scanner(System.in);
                            String rs = sc.next().toUpperCase();

                            if (rs.charAt(0) == 83) {
                                System.out.print("Inserir senha ");
                                sc = new Scanner(System.in);
                                String senha = sc.nextLine();
                                usuario.setSenha(senha);
                            }
                            if (rn.charAt(0) == 83 || rt.charAt(0) == 83 || re.charAt(0) == 83 || rs.charAt(0) == 83) {
                                usuarioDao.editarUsuario(usuario);
                            } else {
                                System.out.println("Não houve alterações");
                            }
                            break;
                        case 10:
                            System.out.println("Tem certeza que quer fazer isso? (S ou N)");
                            String resposta = sc.next().toUpperCase();
                            if (resposta.charAt(0) == 83) {
                                usuarioDao.deleteUser(usuario);
                                c = false;
                                login = false;
                                System.out.println("Você deletou sua conta!");
                            } else {
                                System.out.println("Sua conta não foi deletada");
                            }
                            break;
                        case 11:
                        	System.out.println("Listando suas lembran�as:");
                        	int cont = 0;
                        	for (Lembranca l : lembrancaDao.listarTodasLembrancas(usuario)) {
                        		cont++;
                                System.out.println(cont + " " + l.getTitulo());
                            }
                        	System.out.println("Escolha uma lembran�a:");
                        	sc = new Scanner(System.in);
                        	n3 = sc.nextInt();
                        
                        case 12:
                        	System.out.println("Escolha um dia: ");
                        	sc = new Scanner(System.in);
                        	String dia = sc.next();
                            System.out.println("Escolha um m�s: ");
                            sc = new Scanner(System.in);
                            String mes = sc.next();
                            System.out.println("Lembretes da data " + dia+"/"+mes+":");
                            for (Lembranca l : lembrancaDao.listarLembretes(usuario, dia, mes)) {
                                System.out.println(l.getTitulo()+" "+l.getData());
                            }
                            break;
                        	
                        case 13:
                            c = false;
                            login = false;
                            System.out.println("Voc� realizou logout -_-");
                            break;
                        default:
                            System.out.println("\nOp��o invalida\n");
                    }

                }

            }
        }
    }
}
