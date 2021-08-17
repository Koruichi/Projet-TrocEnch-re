package fr.eni.formation.projetTrocEnchere.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.formation.projetTrocEnchere.bo.Utilisateur;

public class UtilisateurDAOMock implements UtilisateurDAO{

	public List<Utilisateur> lstUtilisateur = new ArrayList<>();
	private static int cpt = 0;
	@Override
	public void insert(Utilisateur utilisateur) {
		lstUtilisateur.add(utilisateur);
		utilisateur.setNo_utilisateur(cpt++);
		
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		lstUtilisateur.remove(utilisateur);
	}

	@Override
	public void update(Utilisateur utilisateur) {
		for ( Utilisateur u : lstUtilisateur) {
			if(utilisateur.getNo_utilisateur() == u.getNo_utilisateur()) {
				utilisateur.setNom(utilisateur.getNom());
				utilisateur.setPrenom(utilisateur.getPrenom());
				utilisateur.setPseudo(utilisateur.getPseudo());
				utilisateur.setEmail(utilisateur.getEmail());
				utilisateur.setTelephone(utilisateur.getTelephone());
				utilisateur.setRue(utilisateur.getRue());
				utilisateur.setCode_postal(utilisateur.getCode_postal());
				utilisateur.setVille(utilisateur.getVille());
				utilisateur.setMot_de_passe(utilisateur.getMot_de_passe());
				utilisateur.setCredit(utilisateur.getCredit());
			}
		}
	}

	@Override
	public List<Utilisateur> getAll() {
		return lstUtilisateur;
	}

	@Override
	public Utilisateur getById(int id) {
		return lstUtilisateur.get(id);
	}

	
}
