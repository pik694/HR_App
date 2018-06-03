package pik.pw.recruitme.app.model.process.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pik.pw.recruitme.app.model.process.dto.CommentDTO;
import pik.pw.recruitme.app.model.users.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @NotNull
    @DateTimeFormat
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "process_id", nullable = false)
    private Process process;


    @NotEmpty
    @NotNull
    @Setter
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
