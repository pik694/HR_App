package pik.pw.recruitme.app;

import pik.pw.recruitme.app.model.Recruiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pik.pw.recruitme.app.repository.RecruiterRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecruiterTests {
    @Autowired
    RecruiterRepository recruiterRepo;

    @Test
    public void addDeleteRecruiterDbTest() {
        Recruiter r = new Recruiter("Bob", "Johnson");
        long countBefore = recruiterRepo.count();

        Recruiter savedRecruiter = recruiterRepo.save(r);

        assertThat( recruiterRepo.count() ).isEqualTo(countBefore + 1);

        recruiterRepo.delete(savedRecruiter);

        assertThat( recruiterRepo.findById( savedRecruiter.getId() ) ).isEmpty();
    }
}
