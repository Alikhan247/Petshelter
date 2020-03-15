package kz.iitu.alikhan.petshelter.service;

import kz.iitu.alikhan.petshelter.dao.PetDao;
import kz.iitu.alikhan.petshelter.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetService {
    private PetDao petDao;


    @Autowired
    public PetService(PetDao petDao){
        this.petDao = petDao;
    }

//    public void updateEmployeeSalary(int id){
//        petDao.updateSalary(id);
//    }

    public void updatePetName(int id, String name) {
        petDao.updateName(id, name);
    }
    public void updatePetWeight(int id, double weight) {
        petDao.updateWeight(id, weight);
    }
    public void updatePetHeight(int id, double height) {
        petDao.updateHeight(id, height);
    }

    public void updatePetGender(int id, int gender) {
        petDao.updateGender(id, gender);
    }

     public void updatePetBreed(int id, String breed) {
         petDao.updateBreed(id, breed);

    }

    public void deletePet(int id) {
         petDao.deletePetById(id);

    }

    public void addPet(Pet pet) {
        petDao.createPet(pet);
    }

    public void showAllPets(){
        List<Pet> employees = petDao.getAll();
        System.out.println();
        if (employees.size()>0){
            System.out.println("Pets list: ");
            for (Pet employee: employees) {
                System.out.println(employee.toString());
            }
            System.out.println();
        } else{
            System.out.println();
            System.out.println("There are no pets in the shelter base");
            System.out.println();
        }
    }
}
