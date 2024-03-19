package eu.fr.indyli.formation.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import eu.fr.indyli.formation.business.dao.IEcolisAlertDAO;
import eu.fr.indyli.formation.business.dto.EcolisAlertDto;

public class EcolisAlertDAOImpl extends AbstractEntityDAOImpl<EcolisAlertDto> implements IEcolisAlertDAO {

	@Override
	public EcolisAlertDto findById(Integer id) {
		for(EcolisAlertDto entity:entityInMemory) {
			if(entity !=null && entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}

	@Override
	public List<EcolisAlertDto> findByVilleDepart(String villeDep) {
		List<EcolisAlertDto> result = new ArrayList<EcolisAlertDto>();
		for(EcolisAlertDto entity:entityInMemory) {
			if (entity!= null && entity.getStartCity().equals(villeDep)) {
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
