package kz.iitu.alikhan.petshelter.event;


import kz.iitu.alikhan.petshelter.entity.Pet;
import org.springframework.context.ApplicationEvent;


public class PetCreateEvent extends ApplicationEvent {

    private Pet pet;

    public PetCreateEvent(Object source, Pet pet) {
        super(source);
        this.pet = pet;
    }

    public Pet getEvent() {
        return pet;
    }
}
