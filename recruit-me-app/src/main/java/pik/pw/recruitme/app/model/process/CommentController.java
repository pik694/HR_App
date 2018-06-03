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

    // "/comments"

    @DeleteMapping("/comments")
    ResponseEntity<?> deleteComments() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/comments")
    ResponseEntity<?> getComments() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/comments")
    ResponseEntity<?> addComment(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/comments")
    ResponseEntity<?> updateComments(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    // "/comments/{id}"

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable int id){

        commentFacade.delete(id);

    }

    @GetMapping("/comments/{id}")
    ResponseEntity<?> getComment() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @PostMapping("/comments/{id}")
    ResponseEntity<?> addComments(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/comments/{id}")
    void updateComment(@RequestBody CommentDTO commentDTO){


        commentFacade.update(commentDTO);
    }

}
