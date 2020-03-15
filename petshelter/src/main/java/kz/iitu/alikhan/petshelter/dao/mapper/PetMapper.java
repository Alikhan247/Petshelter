package kz.iitu.alikhan.petshelter.dao.mapper;

import kz.iitu.alikhan.petshelter.entity.Pet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PetMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
        Pet pet = new Pet();
        pet.setId(resultSet.getInt(1));
        pet.setName(resultSet.getString(2));
        pet.setGender(resultSet.getInt(3));
        pet.setBreed(resultSet.getString(4));
        pet.setHeight(resultSet.getDouble(5));
        pet.setWeight(resultSet.getDouble(6));

        return pet;
    }
}
