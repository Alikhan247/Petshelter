package kz.iitu.alikhan.petshelter.dao;

import java.util.List;

public interface Pet {
    public List<Pet> getAll();
    public List<Pet> getPetById(int id);
    public List<Pet> deletePetById(int id);
}
