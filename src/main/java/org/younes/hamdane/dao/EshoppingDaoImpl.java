package org.younes.hamdane.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.younes.hamdane.entities.Categorie;
import org.younes.hamdane.entities.Client;
import org.younes.hamdane.entities.Commande;
import org.younes.hamdane.entities.LigneCommande;
import org.younes.hamdane.entities.Panier;
import org.younes.hamdane.entities.Produit;
import org.younes.hamdane.entities.Role;
import org.younes.hamdane.entities.User;

public class EshoppingDaoImpl  implements EshoppingDao{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long addCategorie(Categorie categorie) {
		em.persist(categorie);
		return categorie.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		Query query=em.createQuery("SELECT c FROM Categorie c");
		return query.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		return em.find(Categorie.class, idCategorie);
	}

	@Override
	public void deleteCategorie(Long idCategorie) {
		Categorie c=em.find(Categorie.class, idCategorie);
		em.remove(c);
		
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		return em.merge(categorie);
	
	}

	@Override
	public Long addProduct(Produit produit, Long idCategorie) {
		Categorie c=getCategorie(idCategorie);
		produit.setCategorie(c);
		em.persist(produit);
		return produit.getIdProduit();
	}

	@Override
	public List<Produit> listProducts() {
		Query query=em.createQuery("SELECT p FROM Produit p");
		return query.getResultList();
	}

	@Override
	public List<Produit> listProductsByMotCle(String motcle) {
		Query query=em.createQuery("SELECT p FROM Produit p where p.libelle like :mot OR p.description like :mot");
		query.setParameter("mot", "%"+motcle+"%");
		return query.getResultList();
	}

	@Override
	public List<Produit> ListProductsByCategorie(Long idCategorie) {
		Query query=em.createQuery("SELECT p FROM Produit p  where p.categorie.idCategorie=:value");
		query.setParameter("value", idCategorie);
		return query.getResultList();
	}

	@Override
	public List<Produit> selectedProducts() {
		Query query=em.createQuery("SELECT p FROM Produit p where p.selected=true");
		return query.getResultList();
	}

	@Override
	public Produit getProduct(Long idProduct) {
		return em.find(Produit.class, idProduct);
	}

	@Override
	public void deleteProduct(Long idProduct) {
		Produit p=em.find(Produit.class, idProduct);
		em.remove(p);
		
	}

	@Override
	public Produit updateProduct(Produit product) {
		return em.merge(product);
	}

	@Override
	public void addUser(User user) {
		em.persist(user);
		
	}

	@Override
	public void attributeRoleToUser(Role role, Long userId) {
		User user=em.find(User.class,userId);
		user.getRoles().add(role);
		em.persist(role);
	}

	@Override
	public Commande saveCommdane(Panier panier, Client client) {
		em.persist(client);
		Commande cmd=new Commande(new Date());
		cmd.setItems(panier.getItems());
		for(LigneCommande lc:panier.getItems()) {
			em.persist(lc);
		}
		em.persist(cmd);
		return cmd;
	}

}
