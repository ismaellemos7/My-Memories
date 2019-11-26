package model_dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Contato;
import model.Usuario;


public class ContatoDao {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public boolean criarContato(Contato contato, Usuario usuario) throws Throwable {
		Usuario user = new Usuario();
		Conexao con = new Conexao();
		Class.forName(con.getDriver());
		Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
		Statement stmt = conn.createStatement();
		ResultSet rs;

		rs = stmt.executeQuery("SELECT id FROM Usuario WHERE Telefone='" + contato.getTelefone() + "'");
		if(rs.next()){
			user.setId(rs.getInt("id"));
        }
		
		String query = " insert into Contato (nome, Numero, contato_usuario, id_usuario)"
				+ " values (?, ?, ?, ?)";
		
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString (1, contato.getNome());
		preparedStmt.setInt (2, contato.getTelefone());
		preparedStmt.setInt (3, user.getId());
		preparedStmt.setInt (4, usuario.getId());
		preparedStmt.execute();
		conn.close();
		return true;

	}
	
	public void listarContatos2() {
		try {
			String query = "SELECT * FROM mymemories.contato;";
			this.rs = stmt.executeQuery(query);
			this.stmt = this.conn.createStatement();
			
			while(rs.next()) {
				System.out.println("ID: " + rs.getString("idContato") + " Nome: "+ rs.getString("nome") + " Telefone: " + rs.getString("numero"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Contato> listarContatos(Usuario usuario) {
		ArrayList<Contato> contatos = new ArrayList<>();
		try {
			Conexao dados_con = new Conexao();
			Class.forName(dados_con.getDriver());
			try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
				Statement stmt = conn.createStatement();
				ResultSet rs;

				rs = stmt.executeQuery("SELECT * FROM Contato Where id_usuario='" + 3 +"'");

				while ( rs.next() ) {
					Contato contato = new Contato();
					contato.setId(rs.getInt("idContato"));
					contato.setNome(rs.getString("nome"));
					contato.setTelefone((int) rs.getInt("Numero"));
					contato.setContato_usuario(rs.getInt("contato_usuario"));
					contato.setId_usuario(rs.getInt("id_usuario"));
					if(contato.getContato_usuario()!=null) contato.setAtivo(true);
					contatos.add(contato);
				}
				conn.close();
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException ("Erro ao carregar os dados: "+ e);
		}
		return contatos;
	}
	
	public boolean deletarContato(Contato contato) throws ClassNotFoundException, SQLException {
		Conexao con = new Conexao();
        Class.forName(con.getDriver());
        Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
		String query = " delete from Contato where telefone= ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt (1, contato.getTelefone());
		preparedStmt.executeUpdate();
		return true;
	}
	
	public boolean editarContoto(Contato contato) {
		try{

			Conexao dados_con = new Conexao();
			Class.forName(dados_con.getDriver());
			Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha());
			String query = "update Contato set Nome=?, Numero=? where id='" + contato.getId() + "'";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, contato.getNome());
			preparedStmt.setInt (2, contato.getTelefone());
			preparedStmt.executeUpdate();
			conn.close();
			return true;
		}catch (HeadlessException | ClassNotFoundException | SQLException e){
			throw new RuntimeException ("Contato não alterado: "+e);
		}
	}
	
	public ArrayList<Contato> listarContatosUsuarios(Usuario usuario) throws ClassNotFoundException, SQLException {
		ArrayList<Contato> contatos = new ArrayList<>();
		Conexao con = new Conexao();
        Class.forName(con.getDriver());
        Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
        Statement stmt = conn.createStatement();
		ResultSet rs;
		rs = stmt.executeQuery("SELECT * FROM Contato Where id_usuario='" + usuario.getId() + "' AND contato_usuario <> null ");
		while ( rs.next() ) {
			Contato contato = new Contato();
			contato.setId(rs.getInt("id"));
			contato.setNome(rs.getString("nome"));
			contato.setTelefone((int) rs.getInt("Numero"));
			contato.setContato_usuario(rs.getInt("contato_usuario"));
			contato.setId_usuario(rs.getInt("id_usuario"));
			if(contato.getContato_usuario()!=null) contato.setAtivo(true);
			contatos.add(contato);
		}
		conn.close();
		return contatos;
	}
	
	
	
}
