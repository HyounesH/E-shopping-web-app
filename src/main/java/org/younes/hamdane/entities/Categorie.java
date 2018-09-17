package org.younes.hamdane.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 * 
 * @author Younes Hamdane
 *
 */
@Entity
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	private String nomCategorie;
	private String descriptin;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produits;

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(String nomCategorie, String descriptin, byte[] photo, String nomPhoto) {
		super();
		this.nomCategorie = nomCategorie;
		this.descriptin = descriptin;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescriptin() {
		return descriptin;
	}

	public void setDescriptin(String descriptin) {
		this.descriptin = descriptin;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	
	
	
	
}
