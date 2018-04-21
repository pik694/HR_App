package pik.pw.recruitme.app.model.users.domain;


import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pik.pw.recruitme.app.model.users.dto.UserDTO;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

@Transactional
public class UserFacade {

    private UserRepository repository;
    private UserFactory userFactory;

    public UserFacade(UserRepository repository, UserFactory userFactory) {
        this.repository = repository;
        this.userFactory = userFactory;
    }

    public UserDTO add(UserDTO dto) {

        requireNonNull(dto);
        User user = userFactory.from(dto);
        user = repository.save(user);
        return user.toDTO();

    }

    public UserDTO show(int id) {

        User user = repository.findByIdOrThrow(id);
        return user.toDTO();

    }


    public void delete(Integer... ids) {

        requireNonNull(ids);

        Arrays.stream(ids).forEach(
                repository::deleteById
        );

    }

    public Page<UserDTO> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return repository
                .findAll(pageable)
                .map(User::toDTO);
    }

}
