package pik.pw.recruitme.app.model.users.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pik.pw.recruitme.app.model.users.dto.UserDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@DiscriminatorValue(value = "user")
@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Column(unique = true)
    private String username;


//    @NotEmpty
//    @NotNull
//    private String password;


    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;

    @Email
    @NotNull
    @NotEmpty
    private String email;

    UserDTO toDTO() {
        return UserDTO.builder()
                .id(id)
                .username(username)
//                .password(password)
                .firstName(name)
                .lastName(surname)
                .email(email)
                .build();
    }


}
