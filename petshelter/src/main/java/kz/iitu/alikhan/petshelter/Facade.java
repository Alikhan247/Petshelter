package kz.iitu.alikhan.petshelter;

import kz.iitu.alikhan.petshelter.Main;
import kz.iitu.alikhan.petshelter.SpringConfiguration;
import kz.iitu.alikhan.petshelter.controller.MainController;
import kz.iitu.alikhan.petshelter.entity.Pet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Facade {
    public void show() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        MainController controller = context.getBean("mainController", MainController.class);


        controller.showMenu();

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        switch (input) {
            case 1:
                controller.showAllPets();
                break;
            case 2:
                controller.showAllPets();
                System.out.println("Enter pet id");
                int id = sc.nextInt();
                controller.updatePetName(id);
                break;
            case 3:
                controller.showAllPets();
                System.out.println("Enter pet id");
                id = sc.nextInt();
                controller.updatePetHeight(id);
                break;
            case 4:
                controller.showAllPets();
                System.out.println("Enter pet id");
                id = sc.nextInt();
                controller.updatePetWeight(id);
                break;
            case 5:
                controller.showAllPets();
                System.out.println("Enter pet id");
                id = sc.nextInt();
                controller.updatePetBreed(id);
                break;
            case 6:
                System.out.println("Enter pet id");
                id = sc.nextInt();
                controller.updatePetGender(id);
                break;
            case 8:
                controller.showAllPets();
                System.out.println("Enter pet id");
                id = sc.nextInt();
                controller.deletePet(id);
                break;
        }

    }
}
