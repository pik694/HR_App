package pik.pw.recruitme.app.model.process.domain

import groovy.transform.CompileStatic
import pik.pw.recruitme.app.model.process.dto.JobPostingDTO

@CompileStatic
trait SampleJobPostings {
    JobPostingDTO programmer = new JobPostingDTO(1, "programmer", "java", "b2b")
    JobPostingDTO tester = new JobPostingDTO(2, "tester", "manual", "b2b")
}
