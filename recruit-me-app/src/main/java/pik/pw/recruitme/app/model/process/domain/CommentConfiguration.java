package pik.pw.recruitme.app.model.process.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pik.pw.recruitme.app.model.users.domain.UserConfiguration;
import pik.pw.recruitme.app.model.users.domain.UserFacade;

@Configuration
public class CommentConfiguration {

    CommentFacade commentFacade() {

        return commentFacade(new InMemoryCommentsRepository(), (new UserConfiguration()).userFacade(), (new ProcessConfiguration()).processFacade());
    }

    @Bean
    CommentFacade commentFacade(@Qualifier("commentRepository") CommentRepository repository, UserFacade userFacade, ProcessFacade processFacade) {
        CommentFactory creator = new CommentFactory();
        return new CommentFacade(repository, creator, userFacade, processFacade);
    }
}
