package model;

import java.util.List;

public interface LembrancaDAO {
	public List<Lembranca> listarTodasLembranca();
	public Lembranca verLembrancaPorId(String id);
	public void salvarLembranca(Lembranca lembranca);
	public void deletarLembranca(Lembranca lembranca);
	public void atualizarLembranca(Lembranca lembranca);
}
