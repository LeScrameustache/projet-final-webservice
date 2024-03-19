package eu.fr.indyli.formation.business.dao.impl;

import eu.fr.indyli.formation.business.dao.IEcolisCommentDAO;
import eu.fr.indyli.formation.business.dto.EcolisCommentDto;

public class EcolisCommentDAOImpl extends AbstractEntityDAOImpl<EcolisCommentDto> implements IEcolisCommentDAO {

	@Override
	public EcolisCommentDto findById(Integer id) {
		for(EcolisCommentDto entity:entityInMemory) {
			if(entity !=null && entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
