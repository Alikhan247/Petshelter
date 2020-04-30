package kz.iitu.alikhan.petshelter.repository;

import kz.iitu.alikhan.petshelter.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Pet findByName(String name);
    Pet findByBreed(String breed);
}
