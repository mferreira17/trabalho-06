package implementacoes;

import javax.enterprise.context.ApplicationScoped;

import anotacoes.Comun;
import dao.EntidadeDao;
import entidades.Pessoa;
import repositorios.PessoaRepositorio;

@Comun
@ApplicationScoped
public class PessoaComun implements PessoaRepositorio{
	

	@Override
	public void salvar(Pessoa pessoa) {
		EntidadeDao<Pessoa> dao = new EntidadeDao<>();
		System.out.println("salvando em pessoa comum...");
		dao.salvar(pessoa);
	}

	@Override
	public void excluir(Pessoa pessoa) {
	}


}
