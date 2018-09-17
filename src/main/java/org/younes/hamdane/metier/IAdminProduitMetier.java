package org.younes.hamdane.metier;

import org.younes.hamdane.entities.Produit;

public interface IAdminProduitMetier extends InternauteMetier {
	public Long addProduct(Produit produit,Long idCategorie);
	public void deleteProduct(Long idProduct);
	public Produit updateProduct(Produit product);
}
