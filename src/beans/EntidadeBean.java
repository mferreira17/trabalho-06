package beans;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.EntidadeDao;
import lombok.Getter;
import lombok.Setter;

@Named
public abstract class EntidadeBean<T>  {

	@Getter
	@Setter
	private T entidade;
	
	@Inject
	transient private EntidadeDao<T> dao;
	
	@SuppressWarnings("unchecked")
	public EntidadeBean() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Type typedClass = type.getActualTypeArguments()[0];
			entidade = (T) Class.forName(typedClass.getTypeName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void salvar() {
		System.out.println(entidade.toString());
		dao.salvar(entidade);
	}
	
	public List<T> listar(){
		return dao.obterTodosPorClasse(entidade.getClass());
	}

}
