package org.younes.hamdane.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * 
 * @author Younes Hamdane
 *
 */
@Entity
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long idProduit;
     private String libelle;
     private String description;
     private double prix;
     private int quantite;
     private boolean selected;
     private String photo;
     
     @ManyToOne
     @JoinColumn(name="idCategorie")
     private Categorie categorie;
     
	 public Produit() {
		super();
		// TODO Auto-generated constructor stub
	 }

	public Produit(String libelle, String description, double prix, int quantite, boolean selected, String photo) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selected = selected;
		this.photo = photo;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	
     
}
