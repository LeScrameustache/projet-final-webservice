package eu.fr.indyli.formation.business.dao;

import java.util.Date;
import java.util.List;

import eu.fr.indyli.formation.business.dto.EcolisUserDto;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;

public interface IEcolisUserDAO extends IEntityDAO<EcolisUserDto>{
	/**
     * recupere un utilisateur par son login et son password
     * @param login : Login de l'utilisateur qu'on souhaite recuperer
     * @param password : Password de l'utilisateur qu'on souhaite recuperer
     * @return : Utilisateur recherche
     */
    public EcolisUserDto findByLoginAndPassword(String login,String password);

    public List<EcolisUserDto> findAuthorsCommentByDateAndPostedAnnonce(Date paramDatePivot,String paramVilleArrivee);
    
    public EcolisUserDto findByEmail(String email);
    
    public EcolisUserDto findByLogin(String login);
    
    
    /**
     * Renvoie tous les utilisateurs possedant un telephone et dont l'adresse mail est d'un domaine donné
     * @param domaineP : Domaine pour lequel on recherche des utilisateurs
     * @return
     * @throws EcolisBusinessException
     */
    public List<EcolisUserDto> getUtilisateurParDomaineEtPossedantTel(String domaineP) throws EcolisBusinessException;
    
    /**
     * Recherche si un login ou email n'est pas déjà occupé
     * @param login : Login à chercher
     * @param email  : email à chercher
     * @return
     * @throws EcolisBusinessException
     */
    public List<EcolisUserDto> findByLoginOrEmail(String login,String email) throws EcolisBusinessException;
}
