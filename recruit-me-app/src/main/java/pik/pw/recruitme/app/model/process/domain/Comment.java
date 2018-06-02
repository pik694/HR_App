package pik.pw.recruitme.app.model.process.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pik.pw.recruitme.app.model.process.dto.CommentDTO;
import pik.pw.recruitme.app.model.users.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotEmpty
    @NotNull
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @NotEmpty
    @NotNull
    @DateTimeFormat
    private Date date;

    @NotEmpty
    @NotNull
    private String content;

    CommentDTO toDTO() {

        return CommentDTO.builder()
                .id(id)
                .user(user.toDTO())
                .date(date)
                .content(content)
                .build();
    }
}
