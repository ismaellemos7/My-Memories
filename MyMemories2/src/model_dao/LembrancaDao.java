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
import model.Lembranca;
import model_dao.Conexao;

public class LembrancaDao {

	public void create(Lembranca l) {

		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO lembranca (titulo, texto, data, local) VALUES(?, ?, ?, ?)");
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getTexto());
			stmt.setDate(3, new java.sql.Date(l.getData().getTime()));
			stmt.setString(4, l.getLocal());

			stmt.executeUpdate();

			JOptionPane.showConfirmDialog(null, "salvo com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);

		} finally {

			Conexao.closeConnection(con, stmt);

		}
	}

	public List<Lembranca> read() {

		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Lembranca> lembrancas = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM mymemories.lembranca ORDER BY Data");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Lembranca l = new Lembranca();

				l.setIdLembranca(rs.getInt("idLembranca"));
				l.setTitulo(rs.getString("Titulo"));
				l.setTexto(rs.getString("Texto"));
				l.setData(rs.getDate("Data"));
				l.setLocal(rs.getString("Local"));
				l.setDono_lembranca(rs.getInt("Dono_lembranca"));
				l.setTipolembranca(rs.getInt("Tipo_de_lembranca"));
				lembrancas.add(l);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Conexao.closeConnection(con, stmt, rs);
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

	public void delete(Lembranca l) {

		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM lembranca WHERE id = ?");
			stmt.setInt(1, l.getIdLembranca());

			stmt.executeUpdate();

			JOptionPane.showConfirmDialog(null, "deletado com sucesso!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e);

		} finally {

			Conexao.closeConnection(con, stmt);

		}
	}

}
