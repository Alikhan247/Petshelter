package kz.iitu.alikhan.petshelter.service;

import kz.iitu.alikhan.petshelter.entity.Pet;
import kz.iitu.alikhan.petshelter.repository.PetRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class PetService {
   private PetRepository petRepository;

    public Pet findPetById(Long id) {
        return petRepository.findById(id).get();
    }

    public Pet savePet(Pet pet){
        return petRepository.save(pet);
    }


    public Pet updatePetWeight(Long id, double weight){
        Pet pet = petRepository.findById(id).get();
        pet.setWeight(weight);
        return petRepository.save(pet);
    }

    public Pet updatePetName(Long id, String name){
        Pet pet = petRepository.findById(id).get();
        pet.setName(name);
        return petRepository.save(pet);
    }

    public Pet updatePetHeight(Long id, double height){
        Pet pet = petRepository.findById(id).get();
        pet.setHeight(height);
        return petRepository.save(pet);
    }

    public Pet updatePetBreed(Long id, String breed){
        Pet pet = petRepository.findById(id).get();
        pet.setBreed(breed);
        return petRepository.save(pet);
    }

    public Pet updatePetGender(Long id, int gender){
        Pet pet = petRepository.findById(id).get();
        pet.setGender(gender);
        return petRepository.save(pet);
    }

    public List<Pet> showAllPets() {
        return petRepository.findAll();
    }
}
