package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.contoller.model.PetStoreData;
import pet.store.service.PetStoreService;

/*
 * @RestController tells Spring this class is a REST controller, and expects JSON
 * @RequestMapping tells Spring that the URI for every HTTP request 
 * that is mapped begins with /pet_store
 * @Slf4j is a Lombok annotation that creates an instance variable named log
 */
@RestController
@RequestMapping
@Slf4j
public class PetStoreController {

	@Autowired
	private PetStoreService petStoreService;
	
	// Method that maps an HTTP POST request to /pet_store, response status set to 201 (Created)
	@PostMapping("/pet_store")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Creating pet store{}", petStoreData);
		
		return petStoreService.savePetStore(petStoreData);
	}
	
	// Method that sends an HTTP PUT request to the running application
	@PutMapping("/pet_store/{petStoreId}")
	public PetStoreData updatePetStore
	(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {

		petStoreData.setPetStoreId(petStoreId);
		log.info("Updating pet store {}", petStoreData);
		
		return petStoreService.savePetStore(petStoreData);
		
	}
	
}
