package repositorios;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;

import dao.EntidadeDao;
import entidades.Pessoa;

@Named
public interface PessoaRepositorio {
	
	public void salvar(Pessoa pessoa);
	
	public void excluir(Pessoa pessoa);
	
	@Produces static List<Pessoa> listar() {
		EntidadeDao<Pessoa> dao = new EntidadeDao<Pessoa>();
		return dao.obterTodosPorClasse(Pessoa.class);
	}; 
	

}
