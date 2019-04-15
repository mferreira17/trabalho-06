package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;

import anotacoes.Comun;
import anotacoes.SIGAA;
import entidades.Pessoa;
import interceptor.Interceptadora;
import repositorios.PessoaRepositorio;

@ViewScoped
@Named(value="pessoaMB")
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
	
	@Inject
	private Event<Pessoa> eventoPessoa;
	
	private List<Pessoa> pessoas;
	
	@PostConstruct
	public void init(){
		pessoas = PessoaRepositorio.listar();
	}
	
	@Interceptors({Interceptadora.class})
	public void cadastrar(){
		
		Pessoa pessoaComun = pessoa;
		
		repoPessoaComun.salvar(pessoaComun);
		
		eventoPessoa.fire(pessoaComun);

		FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Sucesso")); 
		
		pessoa = new Pessoa();
		
	}
	
	
	public void dispararEmail(@Observes Pessoa pessoa) {
		System.out.println(pessoa.getNome()+" esta sendo contratado! Disparando email para : "+pessoa.getEmail());
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	

}
