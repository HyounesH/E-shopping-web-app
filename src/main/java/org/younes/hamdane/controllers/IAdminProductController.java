package org.younes.hamdane.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.younes.hamdane.entities.Categorie;
import org.younes.hamdane.entities.Produit;
import org.younes.hamdane.metier.IAdminProduitMetier;

@Controller
@RequestMapping("/admin/prod")
@SessionAttributes("updatedProduit")
public class IAdminProductController{
	
	@Autowired
	IAdminProduitMetier metier;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("produit",new Produit());
		model.addAttribute("produits", metier.listProducts());
		model.addAttribute("categories",metier.listCategories());
		return "produit";
	}
	

	@RequestMapping(value = "/saveProd")
	public String saveProd(@Valid Produit produit, Model model, BindingResult bindingResult, MultipartFile file)
			throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("produits", metier.listProducts());
			model.addAttribute("categories", metier.listCategories());
			return ("produit");
		}
		if (!file.isEmpty() && produit.getIdProduit()==null) {
			String path=System.getProperty("java.io.tmpdir");
			produit.setPhoto(file.getOriginalFilename());
			Long idProduit=metier.addProduct(produit,produit.getCategorie().getIdCategorie());
			file.transferTo(new File(path+"prod_"+idProduit+"_"+file.getOriginalFilename()));	
		}else {
			metier.addProduct(produit, produit.getCategorie().getIdCategorie());
		}
		if(produit.getIdProduit()!=null) {
			if(model.asMap().get("updatedProduit")!=null && file.isEmpty()) {
				Produit p=(Produit)model.asMap().get("updatedProduit");
				produit.setPhoto(p.getPhoto());
				model.asMap().remove("updatedProduit");
			}
			metier.updateProduct(produit);
		}
		else {
			metier.addProduct(produit, produit.getCategorie().getIdCategorie());
		}
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listProducts());
		model.addAttribute("categories",metier.listCategories());
		return "produit";
	}


	
	@RequestMapping(value = "photoProd", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoProd(Long idProduit) throws IOException {
		Produit p=metier.getProduct(idProduit);
		File file=new File(System.getProperty("java.io.tmpdir")+"prod_"+idProduit+"_"+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(file));
		
	}
	@RequestMapping(value = "/suppProd")
	public String deleteProduit(Long idProduit, Model model) {
		metier.deleteProduct(idProduit);
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listProducts());
		model.addAttribute("categories", metier.listCategories());
		return "produit";
	}
	@RequestMapping(value = "updateProd")
	public String updateProduit(Long idProduit, Model model) {
		Produit p=metier.getProduct(idProduit);
		model.addAttribute("updatedProduit", p);
		model.addAttribute("produit", p);
		model.addAttribute("produits", metier.listProducts());
		model.addAttribute("categories", metier.listCategories());
		return "produit";
	}

}
