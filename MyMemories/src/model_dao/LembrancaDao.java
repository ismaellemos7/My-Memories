package model_dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Contato;

import model.Lembranca;
import model.Usuario;
import model.Tipo_Lembranca;

public class LembrancaDao {
	public boolean criarLembranca(Usuario usuario, Lembranca lembranca, Tipo_Lembranca tipo) throws Throwable {
		Conexao con = new Conexao();
		Class.forName(con.getDriver());
		Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
		String query = " insert into Lembranca (Titulo, Texto, Data, Local, Dono_lembranca, Tipo_de_lembranca)"
				+ " values (?, ?, ?, ?, ?, ? )";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString (1, lembranca.getTitulo());
		preparedStmt.setString (2, lembranca.getTexto());
		preparedStmt.setDate (3, new java.sql.Date(lembranca.getData().getTime()));
		preparedStmt.setString (4, lembranca.getLocal());
		preparedStmt.setInt (5, 6);
		preparedStmt.setInt (6, tipo.getId());
		preparedStmt.execute();
		conn.close();
		return true;
	}
        
        
	
	public boolean deleteLembranca(Lembranca lembranca) throws ClassNotFoundException, SQLException {
		Conexao con = new Conexao();
        Class.forName(con.getDriver());
        Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
		String query = " delete from Lembranca where id= ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt (1, lembranca.getIdLembranca());
		preparedStmt.executeUpdate();
		return true;	
	}
	
        public ArrayList<Lembranca> listarLembrancas(Tipo_Lembranca tipo) {
		ArrayList<Lembranca> lembrancas = new ArrayList<>();
		try {
			Conexao dados_con = new Conexao();
			Class.forName(dados_con.getDriver());
			try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
				Statement stmt = conn.createStatement();
				ResultSet rs;

				rs = stmt.executeQuery("SELECT * FROM Lembranca Where dono_lembranca='" + 6 +"'");

				while ( rs.next() ) {
					Lembranca lembranca = new Lembranca();
					lembranca.setIdLembranca(rs.getInt("idLembranca"));
					lembranca.setTitulo(rs.getString("Titulo"));
                                        lembranca.setTexto(rs.getString("Texto"));
					lembranca.setData(rs.getDate("Data"));
					lembranca.setLocal(rs.getString("Local"));
					//if(lembranca.getContato_usuario()!=null) contato.setAtivo(true);
					lembrancas.add(lembranca);
				}
				conn.close();
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException ("Erro ao carregar os dados: "+ e);
		}
		return lembrancas;
	}
        
        public java.sql.Date convertUtilDateToSqlDate(String str) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		java.util.Date dataUtil = new java.util.Date();
		try {
			dataUtil = df.parse(str);
		} catch (Exception ex) {

		}
		java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

		return dataSql;
	}
        
	public boolean editarLembranca(Lembranca lembranca) {
		try{
			Conexao dados_con = new Conexao();
			Class.forName(dados_con.getDriver());
			Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha());
			String query = "update Lembranca set Titulo=?, Texto=?, Data=?, Local=? where id='"+lembranca.getIdLembranca()+"'";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, lembranca.getTitulo());
			preparedStmt.setNString (2, lembranca.getTexto());
			preparedStmt.setDate(3, (Date) lembranca.getData());
			preparedStmt.setNString (4, lembranca.getLocal());
			preparedStmt.executeUpdate();
			conn.close();
			return true;
		}catch (HeadlessException | ClassNotFoundException | SQLException e){
			throw new RuntimeException ("Lembraca não alterado: "+e);
		}
	}
	
	
	
}
