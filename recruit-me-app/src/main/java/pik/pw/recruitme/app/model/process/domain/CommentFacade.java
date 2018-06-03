package pik.pw.recruitme.app.model.process.domain;

import org.springframework.transaction.annotation.Transactional;
import pik.pw.recruitme.app.model.process.dto.CommentDTO;
import pik.pw.recruitme.app.model.users.domain.UserFacade;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Transactional
public class CommentFacade {

    private CommentRepository repository;
    private CommentFactory commentFactory;
    private UserFacade userFacade;
    private ProcessFacade processFacade;

    public CommentFacade(CommentRepository repository, CommentFactory commentFactory, UserFacade userFacade, ProcessFacade processFacade) {

        this.repository = repository;
        this.commentFactory = commentFactory;
        this.userFacade = userFacade;
        this.processFacade = processFacade;
    }

    public CommentDTO add(CommentDTO dto, int processId) {

        requireNonNull(dto);

        dto.setUser(userFacade.findAll().get(0));
        dto.setDate(LocalDateTime.now());

        Comment comment = commentFactory.from(dto, processFacade.show(processId));

        comment = repository.save(comment);

        return comment.toDTO();
    }

    public CommentDTO update(CommentDTO dto) {


        Comment comment =  repository.findById(dto.getId());
        comment.setContent(dto.getContent());

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
