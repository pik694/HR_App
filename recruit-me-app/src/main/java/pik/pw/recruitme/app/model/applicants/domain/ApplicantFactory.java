package pik.pw.recruitme.app.model.applicants.domain;

import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO;

public class ApplicantFactory {

    public Applicant from(ApplicantDTO dto) {

        return Applicant.builder()
                .id(dto.getId())
                .name(dto.getFirstName())
                .surname(dto.getLastName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }
}
