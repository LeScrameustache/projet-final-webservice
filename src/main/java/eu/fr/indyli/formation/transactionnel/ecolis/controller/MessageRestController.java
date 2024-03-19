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

import eu.fr.indyli.formation.business.dto.EcolisMessageDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisMessageService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;
import eu.fr.indyli.formation.transactionnel.ecolis.utils.EcolisConstantesWeb.EcolisConstantesURI;
import jakarta.annotation.Resource;

@RestController
@RequestMapping(EcolisConstantesURI.PATH_MESSAGE)
public class MessageRestController {
	
	@Resource(name = EcolisConstantesService.MESSAGE_SERVICE_KEY)
	IEcolisMessageService messageService;
	
	@GetMapping
	public List<EcolisMessageDto> listMessages(){
		List<EcolisMessageDto> result =messageService.findAll();
		return result;		
	}
	
	@GetMapping(value=EcolisConstantesURI.PATH_MESSAGE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findMessage(@PathVariable Integer messageId) throws EcolisBusinessException{
		EcolisMessageDto message;
		try {
			message = this.messageService.findById(messageId);
		} catch (EcolisBusinessException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok(message);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createNewMessage(@RequestBody EcolisMessageDto message) throws EcolisBusinessException{
		return ResponseEntity.ok(this.messageService.create(message));
	}
	
	@PutMapping(value=EcolisConstantesURI.PATH_MESSAGE_ID , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateMessage(@RequestBody EcolisMessageDto message, @PathVariable Integer messageId) throws EcolisBusinessException{
		message.setId(messageId);
		EcolisMessageDto messageToUpdate = this.messageService.findById(messageId);
		if (messageToUpdate == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(this.messageService.update(message));
	}
	
	@DeleteMapping(value=EcolisConstantesURI.PATH_MESSAGE_ID)
	public ResponseEntity<EcolisMessageDto> deleteMessageById (@PathVariable Integer messageId) throws EcolisBusinessException{
		this.messageService.deleteById(messageId);
		return  ResponseEntity.ok().build();
	}
	
}
