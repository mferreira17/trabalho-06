package implementacoes;

import javax.enterprise.context.ApplicationScoped;

import anotacoes.SIGAA;
import dao.EntidadeDao;
import entidades.Pessoa;
import repositorios.PessoaRepositorio;

@SIGAA
@ApplicationScoped
public class PessoaSigaa implements PessoaRepositorio{
	

	@Override
	public void salvar(Pessoa pessoa) {
		EntidadeDao<Pessoa> dao = new EntidadeDao<>();
		System.out.println("salvando em pessoa sigaa...");
		dao.salvar(pessoa);
	}

	@Override
	public void excluir(Pessoa pessoa) {
	}

}
