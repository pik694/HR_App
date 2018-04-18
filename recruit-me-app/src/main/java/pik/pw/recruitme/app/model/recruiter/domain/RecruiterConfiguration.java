package pik.pw.recruitme.app.model.recruiter.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RecruiterConfiguration {

    @Bean
    RecruiterFacade recruiterFacade(){
        InMemoryRecruiterRepository repository = new InMemoryRecruiterRepository();
        RecruiterCreator creator = new RecruiterCreator();
        return new RecruiterFacade(repository, creator);
    }

}
