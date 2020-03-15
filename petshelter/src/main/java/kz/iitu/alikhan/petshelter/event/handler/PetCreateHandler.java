package kz.iitu.alikhan.petshelter.event.handler;

import kz.iitu.alikhan.petshelter.event.PetCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PetCreateHandler implements ApplicationListener<PetCreateEvent> {

    @Override
    public void onApplicationEvent(PetCreateEvent petCreateEvent) {
        System.out.println("PetCreateHandler.onApplicationEvent");
        System.out.println("Created pet id: " + petCreateEvent.getEvent().getId());
        System.out.println("Created pet name: " + petCreateEvent.getEvent().getName());
    }
}
