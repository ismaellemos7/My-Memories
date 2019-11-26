package model_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import model.Contato;
import model_dao.Conexao;

public class ContatoDao {

	public void create(Contato l) {

		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO lembranca (titulo, texto, data, local) VALUES(?, ?, ?, ?)");
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getTexto());
			stmt.setDate(3, new java.sql.Date( l.getData().getTime() ));
			stmt.setString(4, l.getLocal());
			
			stmt.executeUpdate();
			
			JOptionPane.showConfirmDialog(null, "salvo com sucesso!");

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
			
		} finally {
			
			Conexao.closeConnection(con, stmt);
			
		}
	}
	
	public List<Contato> read() {
		
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Contato> contatos = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM mymemories.contato");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Contato c = new Contato();
				
				c.setId(rs.getInt("idContato"));
				c.setNome(rs.getString("Nome"));
				c.setTelefone(rs.getInt("Numero"));
				c.setContato_usuario(rs.getInt("contato_usuario"));
				c.setId_usuario(rs.getInt("id_usuario"));
				contatos.add(c);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			Conexao.closeConnection(con, stmt, rs);
		}
		
		return contatos;
		
		
	}
	
	public java.sql.Date convertUtilDateToSqlDate( String str) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		java.util.Date dataUtil = new java.util.Date(); 
		try { 
			dataUtil = df.parse( str ); 
		} 
		catch (Exception ex) {

		} java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

		return dataSql; 
		} 
}
