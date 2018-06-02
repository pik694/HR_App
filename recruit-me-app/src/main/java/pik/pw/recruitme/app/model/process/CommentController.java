package pik.pw.recruitme.app.model.process;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pik.pw.recruitme.app.model.process.domain.CommentFacade;
import pik.pw.recruitme.app.model.process.dto.CommentDTO;

import java.util.List;

@RestController
public class CommentController {

    private CommentFacade commentFacade;

    public CommentController(CommentFacade commentFacade) {

        this.commentFacade = commentFacade;
    }

    @GetMapping("/comments")
    List<CommentDTO> getComments() {
        return commentFacade.findAll();
    }

    @GetMapping("/comment/{id}")
    CommentDTO getComment(@PathVariable int id) {
        return commentFacade.show(id);
    }

    @PostMapping("/comments")
    CommentDTO addComment(@RequestBody CommentDTO commentDTO){

        return commentFacade.add(commentDTO);
    }

    @PostMapping("/comments/{id}")
    ResponseEntity<?> addComments(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/comments")
    ResponseEntity<?> updateComments(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/comments/{id}")
    void updateComment(@RequestBody CommentDTO commentDTO){
        commentFacade.add(commentDTO);
    }


    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable int id){

        commentFacade.delete(id);

    }

    @DeleteMapping("/comments")
    ResponseEntity<?> deleteComments(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
