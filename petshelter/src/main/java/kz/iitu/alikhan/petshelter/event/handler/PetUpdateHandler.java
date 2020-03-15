package kz.iitu.alikhan.petshelter.event.handler;

import kz.iitu.alikhan.petshelter.event.PetCreateEvent;
import kz.iitu.alikhan.petshelter.event.PetUpdateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PetUpdateHandler implements ApplicationListener<PetUpdateEvent> {

    @Override
    public void onApplicationEvent(PetUpdateEvent petUpdateEvent) {
        System.out.println();
        System.out.println("PetCreateHandler.onApplicationEvent");
        System.out.println("Updated pet id: " + petUpdateEvent.getEvent().getId());
        System.out.println("Updated pet name: " + petUpdateEvent.getEvent().getName());
        System.out.println();
    }
}
