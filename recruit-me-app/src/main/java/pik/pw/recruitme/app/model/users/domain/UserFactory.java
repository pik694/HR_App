package pik.pw.recruitme.app.model.users.domain;

import pik.pw.recruitme.app.model.users.dto.UserDTO;

class UserFactory {

    User from(UserDTO dto) {

        return User.builder()
                .id(dto.getId())
                .name(dto.getFirstName())
                .surname(dto.getLastName())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .build();

    }


}
