package eu.fr.indyli.formation.business.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.fr.indyli.formation.business.dao.IEcolisMessageDAO;
import eu.fr.indyli.formation.business.dto.EcolisMessageDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;

public class EcolisMessageDAOImpl extends AbstractEntityDAOImpl<EcolisMessageDto> implements IEcolisMessageDAO {

	@Override
	public EcolisMessageDto findById(Integer id) {
		for(EcolisMessageDto entity:entityInMemory) {
			if(entity !=null && entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}
	
	//Chelou comme méthode
	@Override
	public void setMessageBodyByUserIdAndCreatedDate(String newMsg, Integer userId, Date dtCreation) throws EcolisBusinessException {
		for(EcolisMessageDto entity:entityInMemory) {
			if(entity != null && entity.getUser().getId() == userId && entity.getCreationDate().equals(dtCreation)) {
				entity.setCorps(newMsg);
				break;
			}
		}

	}

	@Override
	public List<EcolisMessageDto> getMessageByEmailUser(String email) throws EcolisBusinessException {
		List<EcolisMessageDto> result = new ArrayList<EcolisMessageDto>();
		for(EcolisMessageDto entity:entityInMemory) {
			if (entity!=null && entity.getUser().getEmail().equals(email)) {
				result.add(entity);
			}
		}
		return result;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
