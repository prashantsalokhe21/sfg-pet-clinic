package com.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.services.OwnerService;
import com.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Prashant");
		owner1.setLastName("Salokhe");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Kunal");
		owner2.setLastName("Patil");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owner data...");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sarita");
		vet1.setLastName("Sawant");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(1L);
		vet2.setFirstName("Pallavi");
		vet2.setLastName("Marne");
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vet data...");
	}

}
