package kz.iitu.alikhan.petshelter.exception;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

public class PetNotFoundException extends PSQLException {
    public PetNotFoundException() {
        super("Pet not found", PSQLState.DATA_ERROR);
    }

    public PetNotFoundException(String s) {
        super(s, PSQLState.DATA_ERROR);
    }
}
