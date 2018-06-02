package pik.pw.recruitme.app.model.process.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentConfiguration {

    CommentFacade commentFacade() {

        return commentFacade(new InMemoryCommentsRepository());
    }

    @Bean
    CommentFacade commentFacade(@Qualifier("commentRepository") CommentRepository repository) {
        CommentFactory creator = new CommentFactory();
        return new CommentFacade(repository, creator);
    }
}
