package dao;

import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {
		ProduitDeoImpl dao = new ProduitDeoImpl();
		Produit p1 = dao.save(new Produit("HP 568",900,45));
		Produit p2 = dao.save(new Produit("HP1 568",700,100));
		Produit p3 = dao.save(new Produit("smartPhone ",1000,5));
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	}
	
}
