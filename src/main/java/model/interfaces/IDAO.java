package model.interfaces;

import java.util.Set;



public interface IDAO<T> {
	
	void save(T t);
	void delete(T t);
	T getById(Long id);
	Set<T> getByName(String name);
	Set<T> getAll();
}
