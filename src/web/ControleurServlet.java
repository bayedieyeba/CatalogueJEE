package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDeoImpl;
import metier.entities.Produit;
//@WebServlet(name = "cs", urlPatterns = {"*.do"})
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       private IProduitDao metier;
 ControleurServlet() {
        super();
       
    }
    @Override
	public void init() throws ServletException{
    	metier = new ProduitDeoImpl();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/index.do")) {
		 request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else if(path.equals("chercher.do")) {
			String motCle = request.getParameter("motCle");
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits = new ArrayList<Produit>();
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else if(path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);
		}
		else if(path.equals("/saveProduit")&&(request.getMethod().equals("POST"))) {
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = metier.save(new Produit(des,prix,quantite));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		else if(path.equals("/supprimer.do")) {
			Long id =Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			//request.getRequestDispatcher("produits.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
		}
		else if(path.equals("/edit.do")) {
			Long id =Long.parseLong(request.getParameter("id"));
			Produit p = metier.getProduit(id);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("editProduit.jsp").forward(request, response);
		}
		else if(path.equals("/updateProduit")&&(request.getMethod().equals("POST"))) {
			Long id =Long.parseLong(request.getParameter("id"));
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = new Produit(des, prix, quantite);
			p.setId(id);
			metier.update(p);
			request.setAttribute("produit", p);
			response.sendRedirect("confirmation.jsp");
		}
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
