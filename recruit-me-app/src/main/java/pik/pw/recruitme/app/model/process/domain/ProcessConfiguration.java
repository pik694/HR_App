package pik.pw.recruitme.app.model.process.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pik.pw.recruitme.app.model.applicants.domain.ApplicantConfiguration;
import pik.pw.recruitme.app.model.applicants.domain.ApplicantFacade;

@Configuration
public class ProcessConfiguration {

    public ProcessFacade processFacade() {

        return processFacade(new InMemoryProcessesRepository(), (new ApplicantConfiguration()).applicantFacade(), (new JobPostingConfiguration()).jobPostingFacade());
    }

    @Bean
    public ProcessFacade processFacade(@Qualifier("processRepository") ProcessRepository repository, ApplicantFacade applicantFacade, JobPostingFacade jobPostingFacade){
        ProcessFactory creator = new ProcessFactory();
        return new ProcessFacade(repository, creator, applicantFacade, jobPostingFacade);
    }
}
