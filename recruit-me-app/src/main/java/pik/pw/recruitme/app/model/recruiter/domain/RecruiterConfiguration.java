package pik.pw.recruitme.app.model.recruiter.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RecruiterConfiguration {

    RecruiterFacade recruiterFacade() {
        return recruiterFacade(new InMemoryRecruiterRepository());
    }

    @Bean
    RecruiterFacade recruiterFacade(@Qualifier("recruiterRepository") RecruiterRepository repository) {
        RecruiterCreator creator = new RecruiterCreator();
        return new RecruiterFacade(repository, creator);
    }


}
