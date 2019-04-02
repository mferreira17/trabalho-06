package beans;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import dao.EntidadeDao;
import lombok.Getter;
import lombok.Setter;

@Named
public abstract class EntidadeBean<T> {

	@Getter
	@Setter
	protected T entidade;

	@Inject
	private transient EntidadeDao<T> dao;

	public EntidadeBean() {
		createEntidade();
	}

	public void salvar()  {
		System.out.println(entidade.toString());
		dao.salvar(entidade);
		FacesContext.getCurrentInstance().addMessage("growlMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
				entidade.getClass().getSimpleName().concat(" salva com Sucesso!")));
		entidade = createEntidade(); 
	}
	
	public void editar() {
		System.out.println(entidade.toString());
		dao.editar(entidade);
		FacesContext.getCurrentInstance().addMessage("growlMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
				entidade.getClass().getSimpleName().concat(" editada com Sucesso!")));
	}
	
	public void remover(Integer id) {
		System.out.println(entidade.toString());
		dao.remover(entidade.getClass(),id);
		FacesContext.getCurrentInstance().addMessage("growlMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
		entidade.getClass().getSimpleName().concat(" removida com Sucesso!")));
	}
	
	public List<T> listar() {
		return dao.obterTodosPorClasse(entidade.getClass());
	}
	
	public T recuperaEntidadePorId(String id) {
		entidade = dao.obterEntidadePorId(entidade.getClass(), Integer.valueOf(id));
		return entidade;
	}
	
	@SuppressWarnings("unchecked")
	private T createEntidade(){
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Type typedClass = type.getActualTypeArguments()[0];
			entidade = (T) Class.forName(typedClass.getTypeName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return entidade;
	}
	
	public List obterPorConsulta(String consulta, HashMap<String, Object> parametros){
		return dao.obterTodosPorConsulta(consulta, parametros);
	}


}
