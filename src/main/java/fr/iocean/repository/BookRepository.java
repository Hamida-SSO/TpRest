package fr.iocean.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.iocean.model.Book;

@Repository
public class BookRepository extends GenericRepository<Book>{
	
	@PersistenceContext EntityManager em;
	@Override	protected Class<Book> getEntityClass() {return Book.class;	}

}
