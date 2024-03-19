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

import eu.fr.indyli.formation.business.dto.EcolisAlertDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisAlertService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;
import eu.fr.indyli.formation.transactionnel.ecolis.utils.EcolisConstantesWeb.EcolisConstantesURI;
import jakarta.annotation.Resource;

@RestController
@RequestMapping(EcolisConstantesURI.PATH_ALERT)
public class EcolisAlertRestController {

	@Resource(name = EcolisConstantesService.ALERTE_SERVICE_KEY)
	IEcolisAlertService alertService;
	
	@GetMapping
	public List<EcolisAlertDto> listAlerts(){
		List<EcolisAlertDto> result =alertService.findAll();
		return result;		
	}
	
	@GetMapping(value=EcolisConstantesURI.PATH_ALERT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAlert(@PathVariable Integer AlertId) throws EcolisBusinessException{
		EcolisAlertDto alert;
		try {
			alert = this.alertService.findById(AlertId);
		} catch (EcolisBusinessException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok(alert);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createNewAlert(@RequestBody EcolisAlertDto alert) throws EcolisBusinessException{
		return ResponseEntity.ok(this.alertService.create(alert));
	}
	
	@PutMapping(value=EcolisConstantesURI.PATH_ALERT_ID , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateAlert(@RequestBody EcolisAlertDto alert, @PathVariable Integer alertId) throws EcolisBusinessException{
		alert.setId(alertId);
		EcolisAlertDto alertToUpdate = this.alertService.findById(alertId);
		if (alertToUpdate == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(this.alertService.update(alert));
	}
	
	@DeleteMapping(value=EcolisConstantesURI.PATH_ALERT_ID)
	public ResponseEntity<EcolisAlertDto> deleteAlertById (@PathVariable Integer alertId) throws EcolisBusinessException{
		this.alertService.deleteById(alertId);
		return  ResponseEntity.ok().build();
	}
	
}

