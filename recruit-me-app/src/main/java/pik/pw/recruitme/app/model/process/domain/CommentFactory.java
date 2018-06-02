package pik.pw.recruitme.app.model.process.domain;

import pik.pw.recruitme.app.model.process.dto.CommentDTO;
import pik.pw.recruitme.app.model.users.domain.User;

public class CommentFactory {

    Comment from(CommentDTO dto) {

        return Comment.builder()
                .id(dto.getId())
                .user(User.builder()
                            .id(dto.getUser().getId())
                            .username(dto.getUser().getUsername())
                            .name(dto.getUser().getFirstName())
                            .surname(dto.getUser().getLastName())
                            .email(dto.getUser().getEmail())
                            .build())
                .date(dto.getDate())
                .content(dto.getContent())
                .build();
    }
}
