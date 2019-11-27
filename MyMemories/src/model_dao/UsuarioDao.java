package model_dao;

import java.sql.*;
import java.util.ArrayList;
import model.Usuario;
import java.awt.HeadlessException;

public class UsuarioDao {
	public boolean createUser(Usuario usuario) throws Throwable {
		Conexao con = new Conexao();
		Class.forName(con.getDriver());
		Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
		String query = " insert into Usuario (Nome, Email, Senha, Telefone)"
				+ " values (?, ?, ?, ?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString (1, usuario.getNome());
		preparedStmt.setString (2, usuario.getEmail());
		preparedStmt.setString (3, usuario.getSenha());
		preparedStmt.setLong (4, usuario.getTelefone());
		preparedStmt.execute();
		conn.close();
		return true;

	}


	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try {
			Conexao dados_con = new Conexao();
			Class.forName(dados_con.getDriver());
			try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
				Statement stmt = conn.createStatement();
				ResultSet rs;

				rs = stmt.executeQuery("SELECT nome, email FROM Usuario");

				while ( rs.next() ) {
					Usuario user = new Usuario();
					user.setId(rs.getInt("id"));
					user.setNome(rs.getString("nome"));
					user.setEmail(rs.getString("email"));
					user.setTelefone((int) rs.getInt("Telefone"));
					usuarios.add(user);
				}
				conn.close();
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException ("Erro ao carregar os dados: "+ e);
		}
		return usuarios;
	}

	public boolean editarUsuario(Usuario usuario) {
		try{
			Conexao dados_con = new Conexao();
			Class.forName(dados_con.getDriver());
			Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha());
			String query = "update usuario set nome=?, email=?, senha=?, Telefone=? where idUsuario='" + usuario.getId() + "'";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, usuario.getNome());
			preparedStmt.setString(2, usuario.getEmail());
                        preparedStmt.setNString (3, usuario.getSenha());
			preparedStmt.setInt (4, usuario.getTelefone());
			preparedStmt.executeUpdate();
			conn.close();
			return true;
		}catch (HeadlessException | ClassNotFoundException | SQLException e){
			throw new RuntimeException ("Usuário não alterado: "+e);
		}
	}

	
	public boolean deleteUser(Usuario usuario) throws ClassNotFoundException, SQLException {
		Conexao con = new Conexao();
        Class.forName(con.getDriver());
        Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
		String query = " delete from Usuario where id= ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt (1, usuario.getId());
		preparedStmt.executeUpdate();
		return true;
		
	}
	
	
	public Usuario autenticarUsuario(int Telefone, String senha) {
        Usuario usuario = new Usuario();
        try {
            Conexao dados_con = new Conexao();
            Class.forName(dados_con.getDriver());
            try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
                Statement stmt = conn.createStatement();
                ResultSet rs;
                
                rs = stmt.executeQuery("select * from Usuario where Telefone='"+Telefone+"' and senha='"+senha+"'");
                
                if(rs.next()){
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setTelefone(rs.getInt("Telefone"));
                    return usuario;
                }
            }
            
        } catch (ClassNotFoundException | SQLException e) {
        	throw new RuntimeException("Erro ao carregar os dados: " + e);
        }
        return usuario;    
    }
}
