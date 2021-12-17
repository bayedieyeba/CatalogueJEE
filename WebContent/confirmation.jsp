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
	 <div class="panel-heading">Confirmation</div>
	 <div class="panel-body">
	 	<div class="form-group">
	 	<label>ID:</label>
	 	<label>${produit.id}</label>
	 	</div>
	 	<div class="form-group">
	 	<label>Designation:</label>
	 	<label>${produit.designation}</label>
	 	</div>
	 	<div class="form-group">
	 	<label>Prix:</label>
	 	<label>${produit.prix}</label>
	 	</div>
	 	<div class="form-group">
	 	<label>Quantite:</label>
	 	<label>${produit.quantite}</label>
	 	</div>
	 </div>
	</div>
	</div>
</body>
</html>