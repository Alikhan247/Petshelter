package kz.iitu.alikhan.petshelter.controller;


import io.swagger.annotations.ApiOperation;
import kz.iitu.alikhan.petshelter.entity.Pet;
import kz.iitu.alikhan.petshelter.entity.User;
import kz.iitu.alikhan.petshelter.exception.PetNotFoundException;
import kz.iitu.alikhan.petshelter.exception.UserNotFoundException;
import kz.iitu.alikhan.petshelter.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @ApiOperation(value = "Get user with given id", response = User.class)
    @GetMapping("/{id}")
    public Pet findUserById(@PathVariable("id") Long id) throws PetNotFoundException {
        return petService.findPetById(id);
    }

    @ApiOperation(value = "Get specific pet by id", response = List.class)
    @GetMapping("/find/")
    public Pet findBook(@RequestParam("id") Long id) throws PetNotFoundException {
        return petService.findPetById(id);
    }

    @ApiOperation(value = "Add a new pet to the database", response = List.class)
    @PostMapping("/newPet/")
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


    @ApiOperation(value = "Update only image (id required!)", response = Pet.class, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PatchMapping("/newPet/update/img")
    public Pet updateImage(@RequestParam("file") MultipartFile file, @RequestParam Long id) throws IOException, PetNotFoundException {
        String time = String.valueOf(System.currentTimeMillis());
        File convertFile = new File("/Users/alikhan/Desktop/study/second semester/EAD/petshelter/src/main/resources/static/images/"+time+file.getOriginalFilename())
                ;
        convertFile.createNewFile();

        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return petService.findPetById(id);
    }



}
