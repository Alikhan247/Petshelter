package kz.iitu.alikhan.petshelter.controller;


import io.swagger.annotations.ApiOperation;
import kz.iitu.alikhan.petshelter.entity.Pet;
import kz.iitu.alikhan.petshelter.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
