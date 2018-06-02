package pik.pw.recruitme.app.model.process.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pik.pw.recruitme.app.model.users.dto.UserDTO;

import java.sql.Date;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CommentDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("user")
    private UserDTO user;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("content")
    private String content;
}
