package com.springframework.sfgpetclinic.services.map;

import com.springframework.sfgpetclinic.model.Speciality;
import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.services.SpecialityService;
import com.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

	private final SpecialityService specialityService;

	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Vet save(Vet object) {
		if(object != null) {
			if(object.getSpecialities().size() > 0) {
				object.getSpecialities().forEach( speciality -> {
					if(speciality.getId() == null) {
						Speciality speciality1 = specialityService.save(speciality);
						speciality.setId(speciality1.getId());
					}
				});
			}
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public void delete(Vet object) {
		
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		
		super.deleteById(id);
	}
	
	

}
