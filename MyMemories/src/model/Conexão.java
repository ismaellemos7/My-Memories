package model;

public class Conexão {
	private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String senha = "123456";
    private String url = "jdbc:mysql://localhost:3306/MyMemories";

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
