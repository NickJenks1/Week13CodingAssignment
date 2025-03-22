package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.store.contoller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {

	// Instance variable of PetStoreDao that injects DAO object into variable via Autowired
	@Autowired
	private PetStoreDao petStoreDao;

	// Method that returns PetStore object if ID is null, and if not null calls findPetStoreById
	private PetStore findOrCreatePetStore(Long petStoreId) {

		PetStore petStore;

		if (Objects.isNull(petStoreId)) {
			petStore = new PetStore();
		} else {
			petStore = findPetStoreById(petStoreId);
		}
		return petStore;
	}

	// Method that returns a NoSuchElementException if Id does not exist
	private PetStore findPetStoreById(Long petStoreId) {

		return petStoreDao.findById(petStoreId)
				.orElseThrow(() -> new NoSuchElementException
						("Pet store with ID= " + petStoreId + " does not exist"));
	}

	private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
		petStore.setPetStoreId(petStoreData.getPetStoreId());
		petStore.setPetStoreName(petStoreData.getPetStoreName());
		petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		petStore.setPetStoreState(petStoreData.getPetStoreState());
		petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
		petStore.setPetStorePhone(petStoreData.getPetStorePhone());
		petStore.setPetStoreZip(petStoreData.getPetStoreZip());
	}

	public PetStoreData savePetStore(PetStoreData petStoreData) {

		Long petStoreId = petStoreData.getPetStoreId();
		PetStore petStore = findOrCreatePetStore(petStoreId);

		copyPetStoreFields(petStore, petStoreData);

		return new PetStoreData(petStoreDao.save(petStore));
	}

}
