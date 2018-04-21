package pik.pw.recruitme.app.infrastructure.mvc;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(Object object) {
        super("Could not find an object in database: " + object.toString());
    }
}