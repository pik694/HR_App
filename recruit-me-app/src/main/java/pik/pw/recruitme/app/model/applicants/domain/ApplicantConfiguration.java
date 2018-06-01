package pik.pw.recruitme.app.model.applicants.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicantConfiguration {

    ApplicantFacade applicantFacade() {
        return applicantFacade(new InMemoryApplicantsRepository());
    }

    @Bean
    ApplicantFacade applicantFacade(@Qualifier("applicantRepository") ApplicantRepository repository) {
        ApplicantFactory creator = new ApplicantFactory();
        return new ApplicantFacade(repository,creator);
    }
}
