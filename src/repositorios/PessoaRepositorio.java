package repositorios;

import java.util.List;

import javax.enterprise.inject.Produces;

import entidades.Pessoa;

public interface PessoaRepositorio {
	
	public void salvar(Pessoa pessoa);
	
	public void excluir(Pessoa pessoa);
	
	@Produces static List<Pessoa> listar() {
		return null;
	}; 
	

}
