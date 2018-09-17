package org.younes.hamdane.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.younes.hamdane.dao.EshoppingDao;
import org.younes.hamdane.entities.Categorie;
import org.younes.hamdane.entities.Client;
import org.younes.hamdane.entities.Commande;
import org.younes.hamdane.entities.Panier;
import org.younes.hamdane.entities.Produit;
import org.younes.hamdane.entities.Role;
import org.younes.hamdane.entities.User;

@Transactional
public class EshoppingMetierImpl implements IAdminCategorieMetier{
	
	private EshoppingDao dao;
	

	public void setDao(EshoppingDao dao) {
		this.dao = dao;
	}

	@Override
	public Long addProduct(Produit produit, Long idCategorie) {
		// TODO Auto-generated method stub
		return dao.addProduct(produit, idCategorie);
	}

	@Override
	public void deleteProduct(Long idProduct) {
		dao.deleteProduct(idProduct);
		
	}

	@Override
	public Produit updateProduct(Produit product) {
		// TODO Auto-generated method stub
		return dao.updateProduct(product);
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCategorie);
	}

	@Override
	public List<Produit> listProducts() {
		// TODO Auto-generated method stub
		return dao.listProducts();
	}

	@Override
	public List<Produit> listProductsByMotCle(String motcle) {
		// TODO Auto-generated method stub
		return dao.listProductsByMotCle(motcle);
	}

	@Override
	public List<Produit> ListProductsByCategorie(Long idCategorie) {
		// TODO Auto-generated method stub
		return dao.ListProductsByCategorie(idCategorie);
	}

	@Override
	public List<Produit> selectedProducts() {
		// TODO Auto-generated method stub
		return dao.selectedProducts();
	}

	@Override
	public Produit getProduct(Long idProduct) {
		// TODO Auto-generated method stub
		return dao.getProduct(idProduct);
	}

	@Override
	public Commande saveCommdane(Panier panier, Client client) {
		// TODO Auto-generated method stub
		return dao.saveCommdane(panier, client);
	}

	@Override
	public Long addCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return dao.addCategorie(categorie);
	}

	@Override
	public void deleteCategorie(Long idCategorie) {
		// TODO Auto-generated method stub
		dao.deleteCategorie(idCategorie);
		
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return dao.updateCategorie(categorie);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		dao.addUser(user);
	}

	@Override
	public void attributeRoleToUser(Role role, Long userId) {
		// TODO Auto-generated method stub
		dao.attributeRoleToUser(role, userId);
	}

}
