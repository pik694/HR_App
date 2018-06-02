package pik.pw.recruitme.app.model.process.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public class InMemoryCommentsRepository implements CommentRepository {

    private ConcurrentHashMap<Integer, Comment> map = new ConcurrentHashMap<>();

    @Override
    public Comment save(Comment comment) {

        requireNonNull(comment);

        map.put(comment.toDTO().getId(), comment);

        return comment;
    }

    @Override
    public Comment findById(Integer id) {

        return map.get(id);
    }

    @Override
    public void deleteById(Integer id) {

        map.remove(id);
    }

    @Override
    public List<Comment> findAll() {

        return new ArrayList<>(map.values());
    }
}
