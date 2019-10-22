package model;

import java.util.List;

public interface UsuarioDAO {
	public List<Usuario> listarTodosUsuario();
	public Usuario verUsuarioPorId(String id);
	public void salvarUsuario(Usuario usuario);
	public void deletarUsuario(Usuario usuario);
	public void atualizarUsuario(Usuario usuario);
}
