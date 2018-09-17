package org.younes.hamdane;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.younes.hamdane.entities.Categorie;
import org.younes.hamdane.metier.EshoppingMetierImpl;
import org.younes.hamdane.metier.IAdminCategorieMetier;

public class TestMetier {

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});
			IAdminCategorieMetier metier=(IAdminCategorieMetier) context.getBean("metier");
			List<Categorie> list1=metier.listCategories();
			metier.addCategorie(new Categorie("Ordinateurs", "Pc Portable", null, "image.jpg"));
			metier.addCategorie(new Categorie("Télephone","télephone portable et fix",null,"image2.jpg"));
			List<Categorie> list2=metier.listCategories();
			assertTrue(list1.size()+2==list2.size());
		}catch(Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
