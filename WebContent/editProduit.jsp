<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Saisie Produit</title>
</head>
<body>
<%@include file="header.jsp" %>
   <p></p>
	<div class="container col-md-10 col-md-offset-1">
	<div class="panel panel-primary">
	 <div class="panel-heading">Update produit </div>
	 <div class="panel-body">
	 <form action="updateProduit.do" method="post">
	 <div class="form-group">
	 <label class="control-label">ID</label>
	 <input type="text" name="id" class="form-control" value="${produit.id }"/>
	 <span></span>
	 </div>
	 <div class="form-group">
	 <label class="control-label">Désignation</label>
	 <input type="text" name="designation" class="form-control " value="${produit.designation }"/>
	 <span></span>
	 </div>
	 <div class="form-group">
	 <label class="control-label">Prix</label>
	 <input type="text" name="prix" class="form-control" value="${produit.prix }"/>
	 <span></span>
	 </div>
	 <div class="form-group">
	 <label class="control-label">Quantite</label>
	 <input type="text" name="quantite" class="form-control" value="${produit.quantite }"/>
	 <span></span>
	 </div>
	 <div>
	 <button class="btn btn-primary">Save</button>
	 </div>
	 </form>
	 </div>
	</div>
	</div>
</body>
</html>