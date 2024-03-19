package eu.fr.indyli.formation.business.ecolis.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import eu.fr.indyli.formation.business.dao.IEcolisMessageDAO;
import eu.fr.indyli.formation.business.dao.IEntityDAO;
import eu.fr.indyli.formation.business.dao.impl.EcolisMessageDAOImpl;
import eu.fr.indyli.formation.business.dto.EcolisMessageDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisMessageService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;
@Service(EcolisConstantesService.MESSAGE_SERVICE_KEY)
public class EcolisMessageServiceImpl extends AbstractEntityServiceImpl<EcolisMessageDto> implements IEcolisMessageService {

	private IEcolisMessageDAO messageDAO = new EcolisMessageDAOImpl();
	@Override
	public EcolisMessageDto update(EcolisMessageDto message) throws EcolisBusinessException {
		EcolisMessageDto existingMessage = this.messageDAO.findById(message.getId());
		existingMessage.setAnnouncement(message.getAnnouncement());
		existingMessage.setUser(message.getUser());
		existingMessage.setCorps(message.getCorps());
		existingMessage.setCreationDate(message.getCreationDate());
		return this.messageDAO.create(existingMessage);
	}

	@Override
	public void setMessageBodyByUserIdAndCreatedDate(String newMsg, Integer userId, Date dtCreation)
			throws EcolisBusinessException {
		this.messageDAO.setMessageBodyByUserIdAndCreatedDate(newMsg, userId, dtCreation);
	}

	@Override
	public List<EcolisMessageDto> getMessageByEmailUser(String email) throws EcolisBusinessException {
		return this.messageDAO.getMessageByEmailUser(email);
	}

	@Override
	public IEntityDAO<EcolisMessageDto> getDAO() {
		return this.messageDAO;
	}

	

}
