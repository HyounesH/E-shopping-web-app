<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="css"
	value="${pageContext.request.contextPath}/resources/css" />
<c:set var="js" value="${pageContext.request.contextPath }/resources/js" />
<c:set var="images"
	value="${pageContext.request.contextPath}/resources/images" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/font-awesome.min.css" rel="stylesheet">
<link href="${css}/prettyPhoto.css" rel="stylesheet">
<link href="${css}/price-range.css" rel="stylesheet">
<link href="${css}/animate.css" rel="stylesheet">
<link href="${css}/main.css" rel="stylesheet">
<link href="${css}/responsive.css" rel="stylesheet">
<title>E-shopping</title>
</head>
<body>
	<header id="header">
	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="index.html"><img src="${images}/home/logo.png" alt="" /></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-middle-->

	<div class="header-bottom">
		<!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<li><a href="#">Home</a></li>
							<li class="dropdown"><a href="#">Categorie<i
									class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a
										href="${pageContext.request.contextPath}/admin/cat/index#listCategorie">Liste
											Categories </a></li>
									<li><a
										href="${pageContext.request.contextPath}/admin/cat/index#addCategorie">ajouter
											Categorie</a></li>
								</ul></li>
							<li class="dropdown"><a href="#" class="active">Produit<i
									class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a href="#">Liste produits</a></li>
									<li><a href="#">Ajouter produit</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="search_box pull-right">
						<input type="text" placeholder="Search" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-bottom--> </header>
	<section>
	<div class="container">
		<br /> <br /> <br />
		<div class="row">
			<div class="col-sm-7" id="addProduit">
				<div class="features_items">
					<h2 class="title text-center">Ajouter un produit</h2>
					<f:form cssClass="form" modelAttribute="produit" action="saveProd"
						method="post" enctype="multipart/form-data">
						<f:hidden path="idProduit" value="${produit.idProduit }" />
						<div class="form-group">
							<label for="libelle" class="label-control"><b>Désignation
									:</b></label>
							<f:input path="libelle" name="libelle" id="libelle"
								cssClass="form-control" />
						</div>
						<div class="form-group">
							<label for="description" class="label-control"><b>Description
									:</b></label>
							<f:textarea path="description" name="description"
								id="description" cssClass="form-control" rows="7" />
							<f:errors path="description" cssStyle="color:red;"></f:errors>
						</div>
						<div class="form-group">
							<label class="label-control" id="categories"></label>
							<f:select path="categorie.idCategorie" class="form-control"
								items="${categories}" itemValue="idCategorie"
								itemLabel="nomCategorie" />
						</div>
						<div class="form-group">
							<label for="prix" class="label-control"><b>Prix
									Unitaire :</b></label>
							<f:input path="prix" name="prix" id="prix" class="form-control" />
						</div>
						<div class="form-group">
							<label for="qt" class="label-control"><b>Quantité :</b></label>
							<f:input path="quantite" name="quantite" id="qt"
								class="form-control" />
						</div>
						<div>
							<c:if test="${produit.idProduit!=null}">
								<img alt="" src="photoProd?idProduit=${produit.idProduit}"
									height="150px">
							</c:if>
						</div>
						<div class="form-group">
							<label for="file" class="label-control"><b> Photo:</b></label> <input
								type="file" name="file" id="file" class="form-control" />
						</div>
						<div class="form-group">
							<label class="label-control"><b>Selecionner :</b> </label> <label
								class="radio-inline"> <f:radiobutton path="selected"
									value="true" />Oui
							</label> <label class="radio-inline"> <f:radiobutton
									path="selected" value="false" />Non
							</label>
						</div>
						<input type="submit" value="Ajouter" class="btn btn-success">
						<input type="reset" class="btn btn-danger">
					</f:form>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-10" id="listCategorie">
				<div class="features_items">
					<h2 class="title text-center">Liste des produits</h2>
					<table class="table table-stripped">
						<thead>
							<tr>
								<th>ID Produit</th>
								<th>Désignation</th>
								<th>Description</th>
								<th>Prix</th>
								<th>Quantité</th>
								<th>Selectionner</th>
								<th>Photo</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${produits}" var="prod">
								<tr>
									<td>${prod.idProduit}</td>
									<td>${prod.libelle}</td>
									<td>${prod.description}</td>
									<td>${prod.prix}</td>
									<td>${prod.quantite}</td>
									<td>${prod.selected}</td>
									<td><img alt="" src="photoProd?idProduit=${prod.idProduit}"
										width="40px" height="50px"></td>
									<td><a href="updateProd?idProduit=${prod.idProduit}"
										class="btn btn-info">Modifier</a> <a
										href="suppProd?idProduit=${prod.idProduit}"
										class=" btn btn-danger">Supprimer</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	</section>
	<script type="text/javascript" src="${js}/jquery.min.js"></script>
	<script type="text/javascript" src="${js}/bootstrap.min.js"></script>
</body>
</html>