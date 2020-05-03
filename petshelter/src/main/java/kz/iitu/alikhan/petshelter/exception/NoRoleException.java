package kz.iitu.alikhan.petshelter.exception;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

public class NoRoleException extends NullPointerException {

    public NoRoleException() {
        super("Unknown Null Pointer Exception");
    }

    public NoRoleException(String s) {
        super(s);
    }
}
