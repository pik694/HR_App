package pik.pw.recruitme.app.model.process.domain;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobPostingConfiguration {

    JobPostingFacade jobPostingFacade() {
        return jobPostingFacade(new InMemoryJobPostingsRepository());
    }

    @Bean
    JobPostingFacade jobPostingFacade(@Qualifier("jobPostingRepository") JobPostingRepository repository) {

        JobPostingFactory creator = new JobPostingFactory();
        return new JobPostingFacade(repository, creator);
    }
}

