package fr.iocean.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.model.GenericModel;

@Repository
@Transactional
public abstract class GenericRepository<T extends GenericModel> {
	
	protected Class<T> entityClass ;
	@PostConstruct    public void init() {entityClass = getEntityClass();    }

	@PersistenceContext protected EntityManager  em;
	
	public Criteria getCriteria(){		return getSession().createCriteria(entityClass);	}
	
	protected abstract Class<T> getEntityClass();
	protected Session getSession() {		return em.unwrap(Session.class);	}
	public boolean isNew(T entity) {        return entity.getId() <= 0;    }
    public T getById(int id) {        return em.find(entityClass, id);    }
    public List<T> findAll() {        return em.createQuery("select o from "+entityClass.getSimpleName()+ " o ", entityClass).getResultList();  }
   
    
    public List<T> findByQuery(String query, Object[] args){
    	TypedQuery<T> tq = em.createQuery(query,entityClass);
    	if(args!=null){
    		for(int i=0;i<args.length;i++)tq.setParameter(i+1, args[i]);
    	}
    	return tq.getResultList();
    }
    
    public T findOne(String query, Object[] args){
    	List<T> lst = findByQuery(query, args);
    	if(lst==null || lst.size()==0) return null;
    	return lst.get(0);
    }
        
    public List<T> findByQuery(String query){    	return findByQuery(query,null);    }    
    public T findOne(String query){    	return findOne(query,null);    }

    public T save(T entity) {
        if (isNew(entity)) {
            em.persist(entity);
            return entity;
        } else if (!em.contains(entity)) {
            return em.merge(entity);
        }
        return entity;
    }

	
    public void delete(T entity) {
        if (!getSession().contains(entity)) em.remove(getSession().merge(entity));
        else  em.remove(entity);
    }
	
    public void delete(int id) {
    	em.remove(getById(id));
    }
    
    public T first(List<T> list){
    	if(list==null || list.size()==0) return null;
    	return list.get(0);
    }

}