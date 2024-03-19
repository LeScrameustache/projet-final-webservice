package eu.fr.indyli.formation.business.ecolis.service;

import java.util.List;

import eu.fr.indyli.formation.business.dto.EcolisAdvertisingDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;

public interface IEcolisAdvertisingService extends IEntityService<EcolisAdvertisingDto> {
	public EcolisAdvertisingDto update (EcolisAdvertisingDto advertising) throws EcolisBusinessException;
	public List<EcolisAdvertisingDto> findByVilleDepartContaining(String departureTown);
	 public void setPrimeForSomeDeparture(String departureTown) throws EcolisBusinessException;
}
