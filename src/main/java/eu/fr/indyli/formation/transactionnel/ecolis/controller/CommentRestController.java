package eu.fr.indyli.formation.transactionnel.ecolis.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.fr.indyli.formation.business.dto.EcolisCommentDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisCommentService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;
import eu.fr.indyli.formation.transactionnel.ecolis.utils.EcolisConstantesWeb.EcolisConstantesURI;
import jakarta.annotation.Resource;


@RestController
@RequestMapping(EcolisConstantesURI.PATH_COMMENT)
public class CommentRestController {
	@Resource(name = EcolisConstantesService.COMMENT_SERVICE_KEY)
	IEcolisCommentService commentService;
	
	@GetMapping
	public List<EcolisCommentDto> listComments(){
		List<EcolisCommentDto> result =commentService.findAll();
		return result;		
	}
	
	@GetMapping(value=EcolisConstantesURI.PATH_COMMENT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findComment(@PathVariable Integer CommentId) throws EcolisBusinessException{
		EcolisCommentDto comment;
		try {
			comment = this.commentService.findById(CommentId);
		} catch (EcolisBusinessException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok(comment);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createNewComment(@RequestBody EcolisCommentDto comment) throws EcolisBusinessException{
		return ResponseEntity.ok(this.commentService.create(comment));
	}
	
	@PutMapping(value=EcolisConstantesURI.PATH_COMMENT_ID , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateComment(@RequestBody EcolisCommentDto comment, @PathVariable Integer commentId) throws EcolisBusinessException{
		comment.setId(commentId);
		EcolisCommentDto commentToUpdate = this.commentService.findById(commentId);
		if (commentToUpdate == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(this.commentService.update(comment));
	}
	
	@DeleteMapping(value=EcolisConstantesURI.PATH_COMMENT_ID)
	public ResponseEntity<EcolisCommentDto> deleteCommentById (@PathVariable Integer commentId) throws EcolisBusinessException{
		this.commentService.deleteById(commentId);
		return  ResponseEntity.ok().build();
	}
	
}
