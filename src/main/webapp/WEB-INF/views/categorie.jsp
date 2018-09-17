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
							<li class="dropdown"><a href="#" class="active">Categorie<i
									class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a href="#listCategorie">Liste Categories </a></li>
									<li><a href="#addCategorie">ajouter Categorie</a></li>
								</ul></li>
							<li class="dropdown"><a href="#">Produit<i
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
			<div class="col-sm-7" id="addCategorie">
				<div class="features_items">
					<h2 class="title text-center">Ajouter une Catégorie</h2>
					<f:form cssClass="form" modelAttribute="categorie" action="saveCat"
						method="post" enctype="multipart/form-data">
                       <f:hidden path="idCategorie" value="${categorie.idCategorie}" />
						<div class="form-group">
							<label for="categorieName" class="label-control"><b>Categorie
									Name :</b></label>
							<f:input path="nomCategorie" name="nomCategorie"
								id="categorieName" cssClass="form-control" />
							<f:errors path="nomCategorie" cssStyle="color:red;"></f:errors>
						</div>
						<div class="form-group">
							<label for="descriptin" class="label-control"><b>Categorie
									description :</b></label>
							<f:textarea path="descriptin" name="descriptin" id="descriptin"
								cssClass="form-control" rows="7" />
							<f:errors path="descriptin" cssStyle="color:red;"></f:errors>
						</div>
						<div>
						<c:if test="${categorie.idCategorie !=null}">
						    <img alt="" src="photoCat?idCategorie=${categorie.idCategorie}" height="150px">
						   </c:if>
						</div>
						<div class="form-group">
							<label for="file" class="label-control"><b>Categorie
									photo:</b></label> <input type="file" name="file" id="file"
								class="form-control" />
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
					<h2 class="title text-center">Liste des catégories</h2>
					<table class="table table-stripped">
						<thead>
							<tr>
								<th>ID Catégorie</th>
								<th>Désgination</th>
								<th>Description</th>
								<th>Photo</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${categories}" var="cat">
								<tr>
									<td>${cat.idCategorie}</td>
									<td>${cat.nomCategorie}</td>
									<td>${cat.descriptin}</td>
									<td><img alt="${cat.nomPhoto}"
										src="photoCat?idCategorie=${cat.idCategorie}" width="40px"
										height="50px"></td>
									<td><a href="updateCat?idCategorie=${cat.idCategorie}"
										class="btn btn-info">modifier</a> <a
										href="suppCat?idCategorie=${cat.idCategorie}" class=" btn btn-danger">Supprimer</a>
									</td>
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