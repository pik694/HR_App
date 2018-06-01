package pik.pw.recruitme.app.model.users.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryUserRepository implements UserRepository {

    private ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();

    public User save(User user) {

        requireNonNull(user);

        map.put(user.toDTO().getId(), user);

        return user;

    }

    public User findById(Integer id) {

        return map.get(id);

    }

    public void deleteById(Integer id) {
        map.remove(id);
    }


    public List<User> findAll() {

        return new ArrayList<>(map.values());
    }


}
