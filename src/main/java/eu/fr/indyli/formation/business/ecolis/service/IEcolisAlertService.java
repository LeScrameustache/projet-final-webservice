package eu.fr.indyli.formation.business.ecolis.service;

import java.util.List;

import eu.fr.indyli.formation.business.dto.EcolisAlertDto;

public interface IEcolisAlertService extends IEntityService<EcolisAlertDto> {

	public EcolisAlertDto update(EcolisAlertDto alert);
	public List<EcolisAlertDto> findByVilleDepart(String villeDep);

}
