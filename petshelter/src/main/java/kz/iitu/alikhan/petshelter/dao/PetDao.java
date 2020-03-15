package kz.iitu.alikhan.petshelter.dao;

import kz.iitu.alikhan.petshelter.dao.mapper.PetMapper;
import kz.iitu.alikhan.petshelter.database.Database;
import kz.iitu.alikhan.petshelter.entity.Pet;
import kz.iitu.alikhan.petshelter.event.PetCreateEvent;
import kz.iitu.alikhan.petshelter.event.PetUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class PetDao implements ApplicationEventPublisherAware {
    //This entity


    //also DAO, SERVICE, CONTROLLER

    private ApplicationEventPublisher eventPublisher;
    private JdbcTemplate jdbcTemplate;

    private final String GET_ALL_PETS = "SELECT * FROM pets";
    private final String GET_PET_BY_ID = "SELECT * FROM pets WHERE id =";
    private final String GET_PET_BY_NAME = "SELECT * FROM pets WHERE name =";
    private final String DELETE_PET = "DELETE FROM pets WHERE id =";
    private final String NEW_PET = "INSERT INTO pets(name, gender, breed, height, weight) VALUES(?,?,?,?,?)";

    private final String UPDTE_PET_NAME = "UPDATE pets SET name = ? WHERE id = ?";
    private final String UPDTE_PET_WEIHGT = "UPDATE pets SET weight = ? WHERE id = ?";
    private final String UPDTE_PET_HEIGHT = "UPDATE pets SET height = ? WHERE id = ?";
    private final String UPDTE_PET_GENDER = "UPDATE pets SET gender = ? WHERE id = ?";
    private final String UPDTE_PET_BREED = "UPDATE pets SET breed = ? WHERE id = ?";

    public static final int GENDER_UNKNOWN = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;


    @Autowired
    public PetDao(Database database) {
        this.jdbcTemplate = new JdbcTemplate(database.getDataSource());
    }

    public void createPet(Pet pet) {
        savePet(pet, NEW_PET);
        this.eventPublisher.publishEvent(new PetCreateEvent(this, pet));
    }

    public Boolean savePet(final Pet e, String query) {
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, e.getName());
                ps.setInt(2, e.getGender());
                ps.setString(3, e.getBreed());
                ps.setDouble(4, e.getHeight());
                ps.setDouble(5, e.getWeight());

                return ps.execute();

            }
        });
    }

    public void updateName(int id, String name) {
        updatePetName(UPDTE_PET_NAME, name, id);
    }

    public void updateWeight(int id, double weight) {
        updatePetWeight(UPDTE_PET_WEIHGT, weight, id);

    }

    public void updateHeight(int id, double weight) {
        updatePetHeight(UPDTE_PET_HEIGHT, weight, id);

    }

    public void updateGender(int id, int gender) {
        updatePetGender(UPDTE_PET_GENDER, gender, id);

    }

    public void updateBreed(int id, String breed) {
        updatePetBreed(UPDTE_PET_NAME, breed, id);

    }


    public Boolean updatePetName(String query, String value, int id) {
        this.eventPublisher.publishEvent(new PetUpdateEvent(this, getPetById(id).get(0)));
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, value);
                ps.setInt(2, id);
                return ps.execute();

            }
        });
    }

    public Boolean updatePetWeight(String query, double value, int id) {
        this.eventPublisher.publishEvent(new PetUpdateEvent(this, getPetById(id).get(0)));
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setDouble(1, value);
                ps.setInt(2, id);
                return ps.execute();

            }
        });
    }

    public Boolean updatePetHeight(String query, double value, int id) {
        this.eventPublisher.publishEvent(new PetUpdateEvent(this, getPetById(id).get(0)));

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setDouble(1, value);
                ps.setInt(2, id);
                return ps.execute();

            }
        });
    }

    public Boolean updatePetGender(String query, int value, int id) {
        this.eventPublisher.publishEvent(new PetUpdateEvent(this, getPetById(id).get(0)));

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1, value);
                ps.setInt(2, id);
                return ps.execute();

            }
        });
    }

    public Boolean updatePetBreed(String query, String value, int id) {
        this.eventPublisher.publishEvent(new PetUpdateEvent(this, getPetById(id).get(0)));
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1, value);
                ps.setInt(2, id);
                return ps.execute();

            }
        });
    }

    public List<Pet> getAll() {
        return jdbcTemplate.query(GET_ALL_PETS, new PetMapper());
    }

    public List<Pet> getPetById(int id) {
        return jdbcTemplate.query(GET_PET_BY_ID + id, new PetMapper());
    }

    public void deletePetById(int id) {
        jdbcTemplate.execute(DELETE_PET + id);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}

