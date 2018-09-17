package org.younes.hamdane.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
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
import org.younes.hamdane.metier.IAdminCategorieMetier;

@Controller
@RequestMapping("/admin/cat")
@SessionAttributes("updatedCategorie")
public class IAdminCategorieController implements HandlerExceptionResolver {

	@Autowired
	private IAdminCategorieMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categorie";
	}

	@RequestMapping(value = "/saveCat")
	public String saveCat(@Valid Categorie categorie, Model model, BindingResult bindingResult, MultipartFile file)
			throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", metier.listCategories());
			return ("categorie");
		}
		if (!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			categorie.setPhoto(file.getBytes());
			categorie.setNomPhoto(file.getOriginalFilename());
		}
		if (categorie.getIdCategorie() != null) {
			if(model.asMap().get("updatedCategorie")!=null && file.isEmpty()) {
				Categorie c=(Categorie)model.asMap().get("updatedCategorie");
				categorie.setPhoto(c.getPhoto());
				model.asMap().remove("updatedCategorie");
			}
           metier.updateCategorie(categorie);
		} else
			metier.addCategorie(categorie);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categorie";
	}

	@RequestMapping(value = "photoCat", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCategorie) throws IOException {
		Categorie c = metier.getCategorie(idCategorie);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value = "suppCat")
	public String deleteCategorie(Long idCategorie, Model model) {
		metier.deleteCategorie(idCategorie);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categorie";
	}

	@RequestMapping(value = "updateCat")
	public String updateCategorie(Long idCategorie, Model model) {
		Categorie c = metier.getCategorie(idCategorie);
		model.addAttribute("updatedCategorie", c);
		model.addAttribute("categorie", c);
		model.addAttribute("categories", metier.listCategories());
		return "categorie";
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception ex) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("ex", ex.getMessage());
		mav.setViewName("error");
		return mav;
	}

}
