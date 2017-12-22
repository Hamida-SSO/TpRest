package fr.iocean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iocean.model.Book;
import fr.iocean.repository.BookRepository;
import fr.iocean.repository.GenericRepository;

@Service
public class BookService extends GenericService<Book>{
	
	@Autowired BookRepository repository;
	@Override	protected GenericRepository<Book> getRepository() {		return repository;	}
	
}
