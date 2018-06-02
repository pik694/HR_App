package pik.pw.recruitme.app.model.process.domain;

import org.springframework.data.repository.Repository;
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException;

import java.util.List;

interface CommentRepository extends Repository<Comment, Integer> {

    Comment save(Comment comment);

    Comment findById(Integer id);

    void deleteById(Integer id);

    List<Comment> findAll();

    default Comment findByIdOrThrow(Integer id) {

        Comment comment = findById(id);

        if(comment == null){
            throw new ObjectNotFoundException("Comment with id "+id);
        }

        return comment;
    }
}
