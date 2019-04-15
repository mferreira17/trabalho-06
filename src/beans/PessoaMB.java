package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import anotacoes.Comun;
import anotacoes.SIGAA;
import entidades.Pessoa;
import repositorios.PessoaRepositorio;

@Named
@ViewScoped
public class PessoaMB implements Serializable{
	
	@Inject
	@Named(value="pessoa")
	private Pessoa pessoa;
	
	@Comun
	@Inject
	private PessoaRepositorio repoPessoaComun;
	
	@SIGAA
	@Inject
	private PessoaRepositorio repoPessoaSigaa;
	
	private FacesContext context;
	
	@Inject
	Event<PessoaRepositorio> eventoPessoaComun;
	
	@Inject
	Event<PessoaRepositorio> eventoPessoaSigaa;
	
	@PostConstruct
	public void init(){
		context = FacesContext.getCurrentInstance();
	}
	
	public void cadastrar(){
		repoPessoaComun.salvar(pessoa);
		repoPessoaSigaa.salvar(pessoa);
		context.addMessage(null, new FacesMessage("Sucesso", "Pessoa adicionada"));
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
