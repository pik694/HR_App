package pik.pw.recruitme.app.model.process;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pik.pw.recruitme.app.model.process.domain.CommentFacade;
import pik.pw.recruitme.app.model.process.domain.ProcessFacade;
import pik.pw.recruitme.app.model.process.dto.CommentDTO;
import pik.pw.recruitme.app.model.process.dto.ProcessDTO;

import java.util.List;

@RestController
public class ProcessController {

    private ProcessFacade processFacade;
    private CommentFacade commentFacade;

    public ProcessController(ProcessFacade processFacade, CommentFacade commentFacade) {

        this.processFacade = processFacade;
        this.commentFacade = commentFacade;
    }

    // "/processes"

    @DeleteMapping("/processes")
    ResponseEntity<?> deleteProcesses() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/processes")
    ResponseEntity<?> getProcesses() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/processes")
    ProcessDTO addProcess(@RequestBody ProcessDTO processDTO) {

        return processFacade.add(processDTO);
    }

    @PutMapping("processes")
    ResponseEntity<?> updateProcesses() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // "processes/{id}"

    @DeleteMapping("/processes/{id}")
    void deleteProcess(@PathVariable int id) {

        processFacade.delete(id);
    }

    @GetMapping("/process/{id}")
    ProcessDTO getProcess(@PathVariable int id) {

        return processFacade.show(id);
    }

    @PostMapping("/processses/{id}")
    ResponseEntity<?> addPermittedProcess() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/processes/{id}")
    ProcessDTO updateProcess(@RequestBody ProcessDTO processDTO) {


        //TODO
        //CommentDTO commentDTO()
        //commentFacade.add(commentDTO);

        return processFacade.add(processDTO);
    }

    // "/processes/{id}/comments

    @DeleteMapping("/processes/{id}/comments")
    ResponseEntity<?> deleteComments() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/processes/{id}/comments")
    List<CommentDTO> getComments(@PathVariable int id) {

        return processFacade.show(id).getComments();
    }

    @PostMapping("/processes/{id}/comments")
    CommentDTO addComment(@RequestBody CommentDTO commentDTO, @PathVariable int id) {

        ProcessDTO processDTO = processFacade.show(id);
        processDTO.addComment(commentDTO);
        return commentFacade.add(commentDTO);
    }

    @PutMapping("/processes/{id}/comments")
    ResponseEntity<?> updateComments() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
