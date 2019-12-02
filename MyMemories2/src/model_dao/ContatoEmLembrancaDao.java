package model_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Contato;
import model.ContatoLembranca;
import model.Lembranca;

public class ContatoEmLembrancaDao {
	
	public boolean CompartilharLembranca(Lembranca lembranca, Contato contato) throws ClassNotFoundException, SQLException {
		Conexao con = new Conexao();
        Class.forName(con.getDriver());
        Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
        String query = " insert into ContatoEmLembranca (Lembranca_idLembranca, Contato_idContato) values (?, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, lembranca.getIdLembranca());
        stmt.setInt(2, contato.getId());
        stmt.execute();
        conn.close();
        
		return true;
	}
	
	public ArrayList<ContatoLembranca> listarContatoEmLembrancas(Lembranca lembranca, Contato contato) {
        ArrayList<ContatoLembranca> ContatoEmLembranca = new ArrayList<>();
        try {
            Conexao dados_con = new Conexao();
            Class.forName(dados_con.getDriver());
            try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
                Statement stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM ContatoEmLembranca Where Lembranca_idLembranca='" + lembranca.getIdLembranca() + "' and Contato_idContato='" + contato.getId() + "'");

                while (rs.next()) {
                	ContatoLembranca Contato = new ContatoLembranca();
                	Contato.setIdLembranca(lembranca.getIdLembranca());
                	Contato.setIdContato(contato.getId());
                    ContatoEmLembranca.add(Contato);
                }
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao carregar os dados: " + e);
        }
        return ContatoEmLembranca;
    }
	
}
