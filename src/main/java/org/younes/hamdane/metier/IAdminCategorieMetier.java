package org.younes.hamdane.metier;

import org.younes.hamdane.entities.Categorie;
import org.younes.hamdane.entities.Role;
import org.younes.hamdane.entities.User;

public interface IAdminCategorieMetier extends IAdminProduitMetier {

	public Long addCategorie(Categorie categorie);
	public void deleteCategorie(Long idCategorie);
	public Categorie updateCategorie(Categorie categorie);
	
	public void addUser(User user);
	public void attributeRoleToUser(Role role,Long userId);
}
