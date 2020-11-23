package daoservices;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import hibernateutil.HibernateUtil;

public class GenericDao<T> implements DaoGenerics<T> {

	
	@Override
	public void insert(T object) {
		
		EntityManager em = HibernateUtil.getEM();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(object);
		et.commit();
		em.close();
		
	}
	
	@Override
	public void cancel(T object, String id){
		
		Class<?> objectClass = object.getClass();
		EntityManager em = HibernateUtil.getEM();
		EntityTransaction et = em.getTransaction();
		et.begin();
		@SuppressWarnings("unchecked")
		T obj = (T)em.find(objectClass, id);
		em.remove(obj);
		et.commit();
		em.close();
	}

	@Override
	public T getById(T object, String id) {
		
		Class<?> objectClass = object.getClass();
		EntityManager em = HibernateUtil.getEM();
		EntityTransaction et = em.getTransaction();
		et.begin();
		@SuppressWarnings("unchecked")
		T obj = (T)em.find(objectClass, id);
		et.commit();
		em.close();
		return obj;
	}

	@Override
	public List<T> getAll(T object) {
		
		Class<?> objectClass = object.getClass();
		EntityManager em = HibernateUtil.getEM();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("from : T");
		query.setParameter("T", objectClass);
		List<T> objects = query.getResultList();
		et.commit();
		em.close();
		return objects;
	}
	
	//aggiungi update e metodo getEM() nel hibernateUtil

}
