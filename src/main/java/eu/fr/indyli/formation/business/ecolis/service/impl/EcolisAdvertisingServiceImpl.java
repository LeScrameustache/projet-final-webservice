package eu.fr.indyli.formation.business.ecolis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import eu.fr.indyli.formation.business.dao.IEcolisAdvertisingDAO;
import eu.fr.indyli.formation.business.dao.IEntityDAO;
import eu.fr.indyli.formation.business.dao.impl.EcolisAdvertisingDAOImpl;
import eu.fr.indyli.formation.business.dto.EcolisAdvertisingDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisAdvertisingService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;

@Service(EcolisConstantesService.ADVERTISING_SERVICE_KEY)
public class EcolisAdvertisingServiceImpl extends AbstractEntityServiceImpl<EcolisAdvertisingDto>
		implements IEcolisAdvertisingService {
	
	private IEcolisAdvertisingDAO advertisingDAO = new EcolisAdvertisingDAOImpl();

	@Override
	public EcolisAdvertisingDto update(EcolisAdvertisingDto advertising) throws EcolisBusinessException {
		EcolisAdvertisingDto existingAdvertising = this.advertisingDAO.findById(advertising.getId());
		existingAdvertising.setUser(advertising.getUser());
		existingAdvertising.setParcelContents(advertising.getParcelContents());
		existingAdvertising.setPoids(advertising.getPoids());
		existingAdvertising.setUnitePoids(advertising.getUnitePoids());
		existingAdvertising.setDepositDate(advertising.getDepositDate());
		existingAdvertising.setStartDate(advertising.getStartDate());
		existingAdvertising.setEndDate(advertising.getEndDate());
		existingAdvertising.setStartCity(advertising.getStartCity());
		existingAdvertising.setEndCity(advertising.getEndCity());
		existingAdvertising.setPrime(advertising.getPrime());
		existingAdvertising.setDevise(advertising.getDevise());
		existingAdvertising.setStatut(advertising.getStatut());
		existingAdvertising.setAnnouncementType(advertising.getAnnouncementType());
		existingAdvertising.setDetail(advertising.getDetail());
		existingAdvertising.setMessages(advertising.getMessages());
		
		return this.advertisingDAO.create(existingAdvertising);
	}

	@Override
	public List<EcolisAdvertisingDto> findByVilleDepartContaining(String departureTown) {
		return this.advertisingDAO.findByVilleDepartContaining(departureTown);
	}

	@Override
	public void setPrimeForSomeDeparture(String departureTown) throws EcolisBusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IEntityDAO<EcolisAdvertisingDto> getDAO() {
		return this.advertisingDAO;
	} 


}
