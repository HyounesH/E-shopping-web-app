package org.younes.hamdane.dao;

import java.util.List;

import org.younes.hamdane.entities.Categorie;
import org.younes.hamdane.entities.Client;
import org.younes.hamdane.entities.Commande;
import org.younes.hamdane.entities.Panier;
import org.younes.hamdane.entities.Produit;
import org.younes.hamdane.entities.Role;
import org.younes.hamdane.entities.User;

public interface EshoppingDao {
	public Long addCategorie(Categorie categorie);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCategorie);
	public void deleteCategorie(Long idCategorie);
	public Categorie updateCategorie(Categorie categorie);
	
	public Long addProduct(Produit produit,Long idCategorie);
	public List<Produit> listProducts();
	public List<Produit> listProductsByMotCle(String motcle);
	public List<Produit> ListProductsByCategorie(Long idCategorie);
	public List<Produit> selectedProducts();
	public Produit getProduct(Long idProduct);
	public void deleteProduct(Long idProduct);
	public Produit updateProduct(Produit product);
	
	
	public void addUser(User user);
	public void attributeRoleToUser(Role role,Long userId);
	public Commande saveCommdane(Panier panier,Client client);

}
