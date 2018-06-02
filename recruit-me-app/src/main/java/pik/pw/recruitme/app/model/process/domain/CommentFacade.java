package pik.pw.recruitme.app.model.process.domain;

import org.springframework.transaction.annotation.Transactional;
import pik.pw.recruitme.app.model.process.dto.CommentDTO;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Transactional
public class CommentFacade {

    private CommentRepository repository;
    private CommentFactory commentFactory;

    public CommentFacade(CommentRepository repository, CommentFactory commentFactory) {

        this.repository = repository;
        this.commentFactory = commentFactory;
    }

    public CommentDTO add(CommentDTO dto) {

        requireNonNull(dto);

        Comment comment = commentFactory.from(dto);

        comment = repository.save(comment);

        return comment.toDTO();
    }

    public CommentDTO show(Integer id) {

        Comment comment = repository.findByIdOrThrow(id);

        return comment.toDTO();
    }

    public void delete(Integer... ids) {

        requireNonNull(ids);

        Arrays.stream(ids).forEach(repository::deleteById);
    }

    public List<CommentDTO> findAll() {

        List<CommentDTO> dtos = new ArrayList<>();

        for(Comment comment: repository.findAll()) {
            dtos.add(comment.toDTO());
        }

        return dtos;
    }
}
