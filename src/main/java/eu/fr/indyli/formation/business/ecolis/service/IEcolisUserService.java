package eu.fr.indyli.formation.business.ecolis.service;

import java.util.Date;
import java.util.List;

import eu.fr.indyli.formation.business.dto.EcolisUserDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;

/**
 * 
 * @author CHZOME
 *
 */
public interface IEcolisUserService extends IEntityService<EcolisUserDto>{

	/**
     * recupere un utilisateur par son login et son password
     * @param login : Login de l'utilisateur qu'on souhaite recuperer
     * @param password : Password de l'utilisateur qu'on souhaite recuperer
     * @return : Utilisateur recherche
     */
    public EcolisUserDto findByLoginAndPassword(String login,String password) throws EcolisBusinessException ;
    /**
     * recupere un utilisateur par son login et son password
     * @param login : Login de l'utilisateur qu'on souhaite recuperer
     * @param password : Password de l'utilisateur qu'on souhaite recuperer
     * @return : Utilisateur recherche
     */
    public EcolisUserDto findByLogin(String login) throws EcolisBusinessException ;
    /**
     * Remonte les auteurs de comment postés après une date et ayant déposé une annonce pour ville arrivee donnée
     * @param pDatePivot : Date pivot de depot du commentaire
     * @param pVilleArrivee : Ville d'arrivée
     * @return
     */
    public List<EcolisUserDto> findAuthorsCommentByDateAndPostedAnnonce(Date paramDatePivot,String paramVilleArrivee) throws EcolisBusinessException;
    /**
     * Recupere un utilisateur par son email
     * @param email
     * @return
     */
    public EcolisUserDto findByEmail(String email) throws EcolisBusinessException;
    
	/**
	 * Recherche les utilisateurs par email ou login
	 * @param login : Login pour lesquels on recherche des utilisateurs
	 * @param email : Email pour lesquels on recherche des utilisateurs
	 * @return
	 * @throws EcolisBusinessException
	 */
	 public List<EcolisUserDto> findByLoginOrEmail(String login,String email) throws EcolisBusinessException;
	 
	 public EcolisUserDto update(EcolisUserDto user) throws EcolisBusinessException;
}
