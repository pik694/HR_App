package pik.pw.recruitme.app.model.process.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessConfiguration {

    ProcessFacade processFacade() {

        return processFacade(new InMemoryProcessesRepository());
    }

    @Bean
    ProcessFacade processFacade(@Qualifier("processRepository") ProcessRepository repository ){

        ProcessFactory creator = new ProcessFactory();
        return new ProcessFacade(repository, creator);
    }
}
