package model_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Lembranca;
import model.Usuario;

public class LembracaDao {
	public boolean criarLembranca(Usuario usuario, Lembranca lembranca) throws Throwable {
		Conexao con = new Conexao();
		Class.forName(con.getDriver());
		Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
		String query = " insert into Lembranca (Titulo, Texto, Data, Local, Dono_lembranca)"
				+ " values (?, ?, ?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString (1, usuario.getNome());
		preparedStmt.setString (2, usuario.getEmail());
		preparedStmt.setString (3, usuario.getSenha());
		if(usuario.getTelefone() != 0) preparedStmt.setLong (4, usuario.getTelefone());
		preparedStmt.execute();
		conn.close();
		return true;

	}
}
