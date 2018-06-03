package pik.pw.recruitme.app.model.users.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    public UserFacade userFacade() {
        return userFacade(new InMemoryUserRepository());
    }

    @Bean
    public UserFacade userFacade(@Qualifier("userRepository") UserRepository repository) {
        UserFactory creator = new UserFactory();
        return new UserFacade(repository, creator);
    }


}
