package eu.fr.indyli.formation.business.dao;

import java.util.List;

import eu.fr.indyli.formation.business.dto.EcolisAlertDto;

public interface IEcolisAlertDAO extends IEntityDAO<EcolisAlertDto> {
	public List<EcolisAlertDto> findByVilleDepart(String villeDep);
}
