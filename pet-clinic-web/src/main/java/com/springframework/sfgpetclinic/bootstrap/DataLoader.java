package com.springframework.sfgpetclinic.bootstrap;

import com.springframework.sfgpetclinic.model.*;
import com.springframework.sfgpetclinic.services.OwnerService;
import com.springframework.sfgpetclinic.services.PetTypeService;
import com.springframework.sfgpetclinic.services.SpecialityService;
import com.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Prashant");
		owner1.setLastName("Salokhe");
		owner1.setAddress("10/2 Vishwadharam Warje");
		owner1.setTelephone("8899562314");
		owner1.setCity("Pune");
		Pet prashantsPet = new Pet();
		prashantsPet.setPetType(savedDogPetType);
		prashantsPet.setOwner(owner1);
		prashantsPet.setBirthDate(LocalDate.now());
		prashantsPet.setName("Tommy");
		owner1.getPets().add(prashantsPet);
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Kunal");
		owner2.setLastName("Patil");
		owner2.setAddress("Flat No-6 Shantai Sinhgad Road");
		owner2.setTelephone("9988441122");
		owner2.setCity("Pune");
		Pet kunalsPet = new Pet();
		kunalsPet.setPetType(savedCatPetType);
		kunalsPet.setOwner(owner2);
		kunalsPet.setBirthDate(LocalDate.now());
		kunalsPet.setName("furry");
		owner2.getPets().add(kunalsPet);
		ownerService.save(owner2);

		System.out.println("Loaded Owner data...");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sarita");
		vet1.setLastName("Sawant");
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Pallavi");
		vet2.setLastName("Marne");
		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vet data...");
	}

}
