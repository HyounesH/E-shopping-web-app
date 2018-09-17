package org.younes.hamdane.metier;

import java.util.List;

import org.younes.hamdane.entities.Categorie;
import org.younes.hamdane.entities.Client;
import org.younes.hamdane.entities.Commande;
import org.younes.hamdane.entities.Panier;
import org.younes.hamdane.entities.Produit;

public interface InternauteMetier {
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCategorie);
	
	public List<Produit> listProducts();
	public List<Produit> listProductsByMotCle(String motcle);
	public List<Produit> ListProductsByCategorie(Long idCategorie);
	public List<Produit> selectedProducts();
	public Produit getProduct(Long idProduct);

	public Commande saveCommdane(Panier panier,Client client);

	
}
