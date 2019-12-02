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
        preparedStmt.setString(1, lembranca.getTitulo());
        preparedStmt.setString(2, lembranca.getTexto());
        preparedStmt.setDate(3, new java.sql.Date(lembranca.getData().getTime()));
        preparedStmt.setString(4, lembranca.getLocal());
        preparedStmt.setInt(5, usuario.getId());
        preparedStmt.setInt(6, tipo.getId());
        preparedStmt.execute();
        conn.close();
        return true;
    }

    public boolean deleteLembranca(String Titulo, Usuario usuario) throws ClassNotFoundException, SQLException {
        Conexao con = new Conexao();
        Class.forName(con.getDriver());
        Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
        String query = " delete from Lembranca where Dono_lembranca='" + usuario.getId() + "' AND Titulo='" + Titulo + "'";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.executeUpdate();
        return true;
    }

    public ArrayList<Lembranca> listarLembrancas(Tipo_Lembranca tipo, Usuario usuario) {
        ArrayList<Lembranca> lembrancas = new ArrayList<>();
        try {
            Conexao dados_con = new Conexao();
            Class.forName(dados_con.getDriver());
            try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
                Statement stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM Lembranca Where dono_lembranca='" + usuario.getId() + "' and Tipo_de_lembranca='" + tipo.getId() + "'");

                while (rs.next()) {
                    Lembranca lembranca = new Lembranca();
                    lembranca.setIdLembranca(rs.getInt("idLembranca"));
                    lembranca.setTitulo(rs.getString("Titulo"));
                    lembranca.setTexto(rs.getString("Texto"));
                    lembranca.setData(rs.getDate("Data"));
                    lembranca.setLocal(rs.getString("Local"));
                    lembrancas.add(lembranca);
                }
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao carregar os dados: " + e);
        }
        return lembrancas;
    }

    public ArrayList<Lembranca> listarTodasLembrancas(Usuario usuario) {
        ArrayList<Lembranca> lembrancas = new ArrayList<>();
        try {
            Conexao dados_con = new Conexao();
            Class.forName(dados_con.getDriver());
            try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
                Statement stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM Lembranca Where dono_lembranca='" + usuario.getId() + "'");

                while (rs.next()) {
                    Lembranca lembranca = new Lembranca();
                    lembranca.setIdLembranca(rs.getInt("idLembranca"));
                    lembranca.setTitulo(rs.getString("Titulo"));
                    lembranca.setTexto(rs.getString("Texto"));
                    lembranca.setData(rs.getDate("Data"));
                    lembranca.setLocal(rs.getString("Local"));
                    lembrancas.add(lembranca);
                }
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao carregar os dados: " + e);
        }
        return lembrancas;
    }

    public ArrayList<Lembranca> listarLembrancasPorAno(Usuario usuario, String ano) {
        ArrayList<Lembranca> lembrancas = new ArrayList<>();
        try {
            Conexao dados_con = new Conexao();
            Class.forName(dados_con.getDriver());
            try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
                Statement stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM Lembranca Where dono_lembranca='" + usuario.getId() + "' and YEAR(Data) = '" + ano + "'");

                while (rs.next()) {
                    Lembranca lembranca = new Lembranca();
                    lembranca.setIdLembranca(rs.getInt("idLembranca"));
                    lembranca.setTitulo(rs.getString("Titulo"));
                    lembranca.setTexto(rs.getString("Texto"));
                    lembranca.setData(rs.getDate("Data"));
                    lembranca.setLocal(rs.getString("Local"));
                    lembrancas.add(lembranca);
                }
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao carregar os dados: " + e);
        }
        return lembrancas;
    }

    public ArrayList<Lembranca> listarLembrancasPorMes(Usuario usuario, String mes) {
        ArrayList<Lembranca> lembrancas = new ArrayList<>();
        try {
            Conexao dados_con = new Conexao();
            Class.forName(dados_con.getDriver());
            try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
                Statement stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM Lembranca Where dono_lembranca='" + usuario.getId() + "' and MONTH(Data) = '" + mes + "'");

                while (rs.next()) {
                    Lembranca lembranca = new Lembranca();
                    lembranca.setIdLembranca(rs.getInt("idLembranca"));
                    lembranca.setTitulo(rs.getString("Titulo"));
                    lembranca.setTexto(rs.getString("Texto"));
                    lembranca.setData(rs.getDate("Data"));
                    lembranca.setLocal(rs.getString("Local"));
                    lembrancas.add(lembranca);
                }
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao carregar os dados: " + e);
        }
        return lembrancas;
    }

    public ArrayList<Lembranca> listarLembrancasPorDia(Usuario usuario, String dia) {
        ArrayList<Lembranca> lembrancas = new ArrayList<>();
        try {
            Conexao dados_con = new Conexao();
            Class.forName(dados_con.getDriver());
            try (Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha())) {
                Statement stmt = conn.createStatement();
                ResultSet rs;

                rs = stmt.executeQuery("SELECT * FROM Lembranca Where dono_lembranca='" + usuario.getId() + "' and DAY(Data) = '" + dia + "'");

                while (rs.next()) {
                    Lembranca lembranca = new Lembranca();
                    lembranca.setIdLembranca(rs.getInt("idLembranca"));
                    lembranca.setTitulo(rs.getString("Titulo"));
                    lembranca.setTexto(rs.getString("Texto"));
                    lembranca.setData(rs.getDate("Data"));
                    lembranca.setLocal(rs.getString("Local"));
                    lembrancas.add(lembranca);
                }
                conn.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao carregar os dados: " + e);
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

    public boolean editarLembranca(Lembranca lembranca, String Titulo) {
        
        try {
            Conexao dados_con = new Conexao();
            Class.forName(dados_con.getDriver());
            Connection conn = DriverManager.getConnection(dados_con.getUrl(), dados_con.getUser(), dados_con.getSenha());
            String query = "update Lembranca set Titulo=?, Texto=?, Data=?, Local=? where Titulo='" + Titulo + "'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, lembranca.getTitulo());
            preparedStmt.setNString(2, lembranca.getTexto());
            preparedStmt.setDate(3, (Date) lembranca.getData());
            preparedStmt.setNString(4, lembranca.getLocal());
            preparedStmt.executeUpdate();
            conn.close();
            return true;
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Lembraca não alterado: " + e);
        }
    }

    public Lembranca getLembranca(Usuario usuario, String titulo) throws SQLException, ClassNotFoundException {
        Lembranca lembranca = new Lembranca();
        Conexao con = new Conexao();
        Class.forName(con.getDriver());
        Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getSenha());
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM Lembranca Where Dono_lembranca='" + usuario.getId() + "' AND Titulo ='" + titulo + "'");
        if (rs.next()) {
            lembranca.setIdLembranca(rs.getInt("idLembranca"));
            lembranca.setTitulo(rs.getString("Titulo"));
            lembranca.setTexto(rs.getString("Texto"));
            lembranca.setData(rs.getDate("Data"));
            lembranca.setLocal(rs.getString("Local"));
        }
        return lembranca;
    }
}
