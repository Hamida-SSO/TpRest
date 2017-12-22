package fr.iocean.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.iocean.model.GenericModel;
import fr.iocean.repository.GenericRepository;

@Service
public abstract class GenericService<T extends GenericModel> {
	
	protected abstract GenericRepository<T> getRepository();
	
	public List<T> getAll(){ return getRepository().findAll();	}
	public T get(int id){return getRepository().getById(id);	}
	public void save(T b){ getRepository().save(b);	}
	public void delete(int id){getRepository().delete(getRepository().getById(id));	}

}
