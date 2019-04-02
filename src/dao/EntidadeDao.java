package dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Named
public class EntidadeDao<T> {

	@PersistenceContext(unitName = "automoveisPU")
	private static EntityManager em;

	@Transactional(rollbackOn = Exception.class)
	public void salvar(T entidade) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(entidade);
		transaction.commit();
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void editar(T entidade) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(entidade);
		transaction.commit();
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void remover(Class classe , int id) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(em.getReference(classe, id));
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public List<T> obterTodosPorClasse(Class classe) {
		TypedQuery<T> query = em.createQuery("select o from ".concat(classe.getSimpleName()).concat(" o"), classe);
		return query.getResultList();
	}

	public T obterEntidadePorId(Class classe, Integer id) {
		return (T) em.find(classe, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> obterTodosPorConsulta(String consulta, HashMap<String, Object> parametros ){
		Query query = em.createNamedQuery(consulta);
		parametros.entrySet().forEach(p -> query.setParameter(p.getKey(),p.getValue()));
		return query.getResultList();
	}

}
