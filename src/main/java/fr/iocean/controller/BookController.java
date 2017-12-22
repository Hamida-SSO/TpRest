package fr.iocean.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.exceptions.NotFoundException;
import fr.iocean.model.Book;
import fr.iocean.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired BookService service;
	
	@RequestMapping(method=RequestMethod.GET) 
	@ResponseStatus(value=HttpStatus.OK)
	public List<Book> getAll(){		return service.getAll();	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public Book get(@PathVariable int id){ 
		Book result = service.get(id);		
		if(result==null) throw new NotFoundException();
		return result;
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateBook(@PathVariable int id, @RequestBody @Valid Book b){		service.save(b);	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public int createBook(@RequestBody @Valid Book b){		
		service.save(b);
		return b.getId();
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteBook(@PathVariable int id){		service.delete(id);	}

}
