package model_dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String senha = "";
	private static String url = "jdbc:mysql://localhost:3306/MyMemories";



	public static  Connection getConnection() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, senha);
		}
		catch(ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro na conexão: " + ex);
		} 
	}

	public static void closeConnection(Connection connection) throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement stat) throws SQLException {
		if(connection != null) {
			closeConnection(connection);

			if(stat != null) {
				stat.close();
			}
		}
	}


	public static void closeConnection(Connection connection, PreparedStatement stat, ResultSet rs) throws SQLException {
		if(connection != null) {
			closeConnection(connection, stat);

			if(rs != null) {
				rs.close();
			}
		}
	}

	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	} 
}
