package com.springframework.sfgpetclinic.services.map;

import java.util.Set;

import com.springframework.sfgpetclinic.model.Pet;
import com.springframework.sfgpetclinic.services.CrudService;
import com.springframework.sfgpetclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{

	@Override
	public Set<Pet> findAll() {
		
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public void delete(Pet object) {
		
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		
		super.deleteById(id);
	}

	@Override
	public Pet save(Pet object) {
		
		return super.save(object.getId(), object);
	}

	
}
