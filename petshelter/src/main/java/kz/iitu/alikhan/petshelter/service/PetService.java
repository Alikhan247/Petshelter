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

    public List<Pet> showAllPets() {
        return petRepository.findAll();
    }
}
