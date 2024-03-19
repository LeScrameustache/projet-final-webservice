package eu.fr.indyli.formation.business.ecolis.service.impl;

import org.springframework.stereotype.Service;

import eu.fr.indyli.formation.business.dao.IEcolisCommentDAO;
import eu.fr.indyli.formation.business.dao.IEntityDAO;
import eu.fr.indyli.formation.business.dao.impl.EcolisCommentDAOImpl;
import eu.fr.indyli.formation.business.dto.EcolisCommentDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisCommentService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;

@Service(EcolisConstantesService.COMMENT_SERVICE_KEY)
public class EcolisCommentServiceImpl extends AbstractEntityServiceImpl<EcolisCommentDto>
		implements IEcolisCommentService {

		private IEcolisCommentDAO commentDAO = new EcolisCommentDAOImpl();
		
	@Override
	public EcolisCommentDto update(EcolisCommentDto comment) throws EcolisBusinessException {
		EcolisCommentDto existingComment = this.commentDAO.findById(comment.getId());
		existingComment.setUser(comment.getUser());
		existingComment.setCorps(comment.getCorps());
		existingComment.setCreationDate(comment.getCreationDate());
		
		return this.commentDAO.create(existingComment);
	}

	@Override
	public IEntityDAO<EcolisCommentDto> getDAO() {
		return this.commentDAO;
	}

}
