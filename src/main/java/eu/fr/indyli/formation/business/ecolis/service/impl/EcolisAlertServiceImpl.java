package eu.fr.indyli.formation.business.ecolis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import eu.fr.indyli.formation.business.dao.IEcolisAlertDAO;
import eu.fr.indyli.formation.business.dao.IEntityDAO;
import eu.fr.indyli.formation.business.dao.impl.EcolisAlertDAOImpl;
import eu.fr.indyli.formation.business.dto.EcolisAlertDto;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisAlertService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;

@Service(EcolisConstantesService.ALERTE_SERVICE_KEY)
public class EcolisAlertServiceImpl extends AbstractEntityServiceImpl<EcolisAlertDto> implements IEcolisAlertService {
	
	private IEcolisAlertDAO alertDAO = new EcolisAlertDAOImpl();
	
	@Override
	public IEntityDAO<EcolisAlertDto> getDAO() {
		return this.alertDAO;
	}

	@Override
	public EcolisAlertDto update(EcolisAlertDto alert) {
		EcolisAlertDto existingAlert = this.alertDAO.findById(alert.getId());
		existingAlert.setUser(alert.getUser());
		existingAlert.setStartCity(alert.getStartCity());
		existingAlert.setEndCity(alert.getEndCity());
		existingAlert.setDepositDate(alert.getDepositDate());
		
		return this.alertDAO.create(existingAlert);
	}

	@Override
	public List<EcolisAlertDto> findByVilleDepart(String villeDep) {
		return this.alertDAO.findByVilleDepart(villeDep) ;
	}

	

}
