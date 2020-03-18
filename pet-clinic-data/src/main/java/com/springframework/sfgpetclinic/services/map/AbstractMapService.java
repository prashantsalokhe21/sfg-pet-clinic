/**
 * 
 */
package com.springframework.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lenovo
 *
 */
public class AbstractMapService<T , ID> {

	protected Map<ID, T>  map = new HashMap<>();

	Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	T findById(ID id) {
		return map.get(id);
	}

	T save(ID id, T object) {
		map.put(id, object);
		return object;
	}

	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	 }

	void deleteById(ID id) {
		map.remove(id);
	}
	

	/*public T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);

		} else {
			throw new RuntimeException("Object can not be null!");
		}
		return object;
	}*/
	
	  
	/*private Long getNextId() {

		Long nextId = null;

		try {
			nextId = Collections.max(map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			return 1L;
		}

		return nextId;
	}*/
}
