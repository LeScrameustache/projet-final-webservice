package eu.fr.indyli.formation.business.ecolis.service;

import eu.fr.indyli.formation.business.dto.EcolisCommentDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;

public interface IEcolisCommentService extends IEntityService<EcolisCommentDto> {
	public EcolisCommentDto update (EcolisCommentDto advertising) throws EcolisBusinessException;
}
