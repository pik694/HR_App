package pik.pw.recruitme.app.model.recruiter.domain;

public class RecruiterNotFoundException extends RuntimeException {
    RecruiterNotFoundException(Integer id) {
        super("Could not find a recruiter with id: " + id.toString());
    }
}