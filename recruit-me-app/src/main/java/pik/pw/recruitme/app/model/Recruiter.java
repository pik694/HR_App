package pik.pw.recruitme.app.model;

import javax.persistence.*;

@Entity
@Table(name = "\"RECRUITERS\"")
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID\"")
    private long id;

    @Column(name = "\"FIRST_NAME\"")
    private String firstName;

    @Column(name = "\"LAST_NAME\"")
    private String lastName;

    public Recruiter() { }

    public Recruiter(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
