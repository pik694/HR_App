package pik.pw.recruitme.app.model.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

}
