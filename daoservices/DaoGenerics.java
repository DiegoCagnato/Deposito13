package daoservices;

import java.util.List;

public interface DaoGenerics<T> {

	public void insert(T object);
	
	public void cancel(T object, String id);
	
	public T getById(T object, String id); 
	
	public List<T> getAll(T objects);
	
}
