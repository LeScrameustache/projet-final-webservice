package eu.fr.indyli.formation.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import eu.fr.indyli.formation.business.dao.IEcolisAdvertisingDAO;
import eu.fr.indyli.formation.business.dto.EcolisAdvertisingDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;

public class EcolisAdvertisingDAOImpl extends AbstractEntityDAOImpl<EcolisAdvertisingDto> implements IEcolisAdvertisingDAO {

	@Override
	public EcolisAdvertisingDto findById(Integer id) {
		for(EcolisAdvertisingDto entity:entityInMemory) {
			if(entity !=null && entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}

	@Override
	public List<EcolisAdvertisingDto> findByVilleDepartContaining(String departureTown) {
		List<EcolisAdvertisingDto> result = new ArrayList<EcolisAdvertisingDto>();
		for(EcolisAdvertisingDto entity:entityInMemory) {
			if (entity!= null && entity.getStartCity().contains(departureTown)) {
				result.add(entity);
			}
		}
		return result;
	}

	@Override
	public void setPrimeForSomeDeparture(String departureTown) throws EcolisBusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}

	

}
