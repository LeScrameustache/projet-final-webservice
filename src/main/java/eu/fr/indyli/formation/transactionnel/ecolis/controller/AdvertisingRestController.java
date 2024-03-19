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

import eu.fr.indyli.formation.business.dto.EcolisAdvertisingDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisAdvertisingService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;
import eu.fr.indyli.formation.transactionnel.ecolis.utils.EcolisConstantesWeb.EcolisConstantesURI;
import jakarta.annotation.Resource;

@RestController
@RequestMapping(EcolisConstantesURI.PATH_ADVERTISING)
public class AdvertisingRestController {

	@Resource(name = EcolisConstantesService.ADVERTISING_SERVICE_KEY)
	IEcolisAdvertisingService advertisingService;
	
	@GetMapping
	public List<EcolisAdvertisingDto> listAdvertisings(){
		List<EcolisAdvertisingDto> result =advertisingService.findAll();
		return result;		
	}
	
	@GetMapping(value=EcolisConstantesURI.PATH_ADVERTISING_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAdvertising(@PathVariable Integer AdvertisingId) throws EcolisBusinessException{
		EcolisAdvertisingDto advertising;
		try {
			advertising = this.advertisingService.findById(AdvertisingId);
		} catch (EcolisBusinessException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok(advertising);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createNewAdvertising(@RequestBody EcolisAdvertisingDto advertising) throws EcolisBusinessException{
		return ResponseEntity.ok(this.advertisingService.create(advertising));
	}
	
	@PutMapping(value=EcolisConstantesURI.PATH_ADVERTISING_ID , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateAdvertising(@RequestBody EcolisAdvertisingDto advertising, @PathVariable Integer advertisingId) throws EcolisBusinessException{
		advertising.setId(advertisingId);
		EcolisAdvertisingDto advertisingToUpdate = this.advertisingService.findById(advertisingId);
		if (advertisingToUpdate == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(this.advertisingService.update(advertising));
	}
	
	@DeleteMapping(value=EcolisConstantesURI.PATH_ADVERTISING_ID)
	public ResponseEntity<EcolisAdvertisingDto> deleteAdvertisingById (@PathVariable Integer advertisingId) throws EcolisBusinessException{
		this.advertisingService.deleteById(advertisingId);
		return  ResponseEntity.ok().build();
	}
}
