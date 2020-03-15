package kz.iitu.alikhan.petshelter.controller;

import kz.iitu.alikhan.petshelter.entity.Pet;
import kz.iitu.alikhan.petshelter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainController {
    private PetService petService;

    Scanner sc = new Scanner(System.in);

    @Autowired
    public MainController(PetService petService) {
        this.petService = petService;
    }


    public void showMenu() {
        System.out.println("Welcome!");
        System.out.println("Select an option:");
        System.out.println("1) list all pets in the base");
        System.out.println("2) update pet name");
        System.out.println("3) update pet height");
        System.out.println("4) update pet weight");
        System.out.println("5) update pet breed");
        System.out.println("6) update pet gender");
        System.out.println("7) add a pet");
        System.out.println("8) delete a pet");
    }

    public void showAllPets() {
        petService.showAllPets();
    }

    public void updatePetName(int id) {

        System.out.println("Enter name of the pet:");

        petService.updatePetName(id, sc.next());
    }

    public void updatePetWeight(int id) {

        System.out.println("Enter name of the weight:");

        petService.updatePetWeight(id, sc.nextDouble());
    }


    public void updatePetHeight(int id) {

        System.out.println("Enter name of the height:");

        petService.updatePetHeight(id, sc.nextDouble());
    }

    public void updatePetGender(int id) {

        System.out.println("Please select gender below: ");
        System.out.println("0) Unspecified");
        System.out.println("1) Male");
        System.out.println("2) Female");
        System.out.println();
        System.out.println("For example enter 1 for male");

        petService.updatePetGender(id, sc.nextInt());
    }


    public void updatePetBreed(int id) {

        System.out.println("Please enter pet breed: ");

        petService.updatePetBreed(id, sc.next());
    }

    public void deletePet(int id) {
        petService.deletePet(id);
    }

    public void addPet(Pet pet) {

        System.out.println("Please enter name of the pet:");
        pet.setName(sc.nextLine());

        System.out.println("Please select gender below: ");
        System.out.println("0) Unspecified");
        System.out.println("1) Male");
        System.out.println("2) Female");
        System.out.println();
        System.out.println("For example enter 1 for male");
        pet.setGender(sc.nextInt());
        System.out.println("Please enter breed of the pet:");
        pet.setBreed(sc.next());
        System.out.println("Please enter height of the pet:");
        pet.setHeight(sc.nextDouble());
        System.out.println("Please enter weight of the pet:");
        pet.setWeight(sc.nextDouble());

        petService.addPet(pet);
    }

}
