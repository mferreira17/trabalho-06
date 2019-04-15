package implementacoes;

import java.util.Arrays;
import java.util.List;

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
		dao.salvar(pessoa);
	}

	@Override
	public void excluir(Pessoa pessoa) {
	}

}
