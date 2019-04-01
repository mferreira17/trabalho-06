package dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Named
public class EntidadeDao<T> {

	@PersistenceContext(unitName = "automoveisPU")
	private static EntityManager em;

	@Transactional(rollbackOn=Exception.class)
	public void salvar(T entidade) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(entidade);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public List<T> obterTodosPorClasse(Class classe) {
		TypedQuery<T> query = em.createQuery("select o from ".concat(classe.getSimpleName()).concat(" o"), classe);
		return query.getResultList();
	}

}
