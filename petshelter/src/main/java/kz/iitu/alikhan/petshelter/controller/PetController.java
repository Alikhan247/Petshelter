package kz.iitu.alikhan.petshelter.controller;


import io.swagger.annotations.ApiOperation;
import kz.iitu.alikhan.petshelter.entity.Pet;
import kz.iitu.alikhan.petshelter.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@AllArgsConstructor
public class PetController {
    private final PetService petService;

    @ApiOperation(value = "Get all pets", response = List.class)
    @GetMapping("")
    public List<Pet> getAllPets() {
        return petService.showAllPets();
    }

    @ApiOperation(value = "Get specific pet by id", response = List.class)
    @GetMapping("/find/")
    public Pet findBook(@RequestParam("id") Long id) {
        return petService.findPetById(id);
    }

    @ApiOperation(value = "Add a new pet to the database", response = List.class)
    @GetMapping("/newPet/")
    public Pet save(@RequestBody() Pet pet) {
        return petService.savePet(pet);
    }

    @ApiOperation(value = "Update the whole field by providing a whole body of the object (id required!)", response = Pet.class)
    @PutMapping("/newPet/update")
    public Pet updatePet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

    @ApiOperation(value = "Update only weight (id required!)", response = Pet.class)
    @PatchMapping("/newPet/update/name")
    public Pet updatePetName(@RequestParam Long id, @RequestParam String name) {
        return petService.updatePetName(id, name);
    }

    @ApiOperation(value = "Update only weight (id required!)", response = Pet.class)
    @PatchMapping("/newPet/update/weight")
    public Pet updatePetWeight(@RequestParam Long id, @RequestParam double weight) {
        return petService.updatePetWeight(id, weight);
    }

    @ApiOperation(value = "Update only height (id required!)", response = Pet.class)
    @PatchMapping("/newPet/update/height")
    public Pet updatePetHeight(@RequestParam Long id, @RequestParam double height) {
        return petService.updatePetHeight(id, height);
    }

    @ApiOperation(value = "Update only breed (id required!)", response = Pet.class)
    @PatchMapping("/newPet/update/breed")
    public Pet updatePetBreed(@RequestParam Long id, @RequestParam String breed) {
        return petService.updatePetBreed(id, breed);
    }

    @ApiOperation(value = "Update only gender (id required!)", response = Pet.class)
    @PatchMapping("/newPet/update/gender")
    public Pet updatePetGender(@RequestParam Long id, @RequestParam int gender) {
        return petService.updatePetGender(id, gender);
    }

}
