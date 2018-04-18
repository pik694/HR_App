package pik.pw.recruitme.app.model.recruiter.domain;

import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO;

class RecruiterCreator {

    Recruiter from(RecruiterDTO dto){

        return Recruiter.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();

    }

}
