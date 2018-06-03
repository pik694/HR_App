package pik.pw.recruitme.app.model.process.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pik.pw.recruitme.app.model.users.dto.UserDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CommentDTO {

    @JsonProperty("id")
    private int id;

    @Setter
    @JsonProperty("user")
    private UserDTO user;

    @Setter
    @JsonProperty("date")
    private LocalDateTime date;

    @JsonProperty("content")
    private String content;

//    @JsonProperty("process")
//    private ProcessDTO process;
}
