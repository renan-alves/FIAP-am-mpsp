<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<link
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">

<head>
<meta charset="ISO-8859-1">
<title>Virtualities - Home</title>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<style type="text/css">
.chover:hover {
	-webkit-box-shadow: 0px 0px 9px 6px rgba(0, 0, 0, 0.67);
	box-shadow: 0px 0px 9px 6px rgba(0, 0, 0, 0.67);
}
</style>

</head>
<body style="height: 100%;">
	<div class="container-fluid h-100">
		<div class="row h-100">
			<aside class="col-2 px-0 fixed-top h-100" id="left">
				<div class="h-100 w-100">
					<a href="${contextPath}/chamado">
						<img class="img-fluid p-3" src="https://www.direitosbc.br/wp-content/uploads/2019/09/logo-mpsp-transparente-1024x576.png"/>
					</a>
					<a class="list-group-item list-group-item-action" href="${contextPath}/chamado" class="list-group-item">Home</a>
					<a class="list-group-item list-group-item-action" href="${contextPath}/chamado/lista?status=aberto" class="list-group-item">Chamados</a>
					<a class="list-group-item list-group-item-action" href="${contextPath}/chamado/lista?status=aberto" class="list-group-item">&nbsp;&nbsp;&nbsp;- Abertos</a>
					<a class="list-group-item list-group-item-action" href="${contextPath}/chamado/lista?status=aguardando" class="list-group-item">&nbsp;&nbsp;&nbsp;- Aguardando resposta</a>
					<a class="list-group-item list-group-item-action" href="${contextPath}/chamado/lista?status=fechado" class="list-group-item">&nbsp;&nbsp;&nbsp;- Fechados</a>
					<form method="GET" action="${contextPath}/chamado/?">
						<div class="input-group mb-3">
		  					<input type="number" class="form-control" id="txt-protocolo" placeholder="Digite o Protocolo">
		  					<div class="input-group-append">
		    					<a href="" onclick="this.href='${contextPath}/chamado/home/'+document.getElementById('txt-protocolo').value" class="btn btn-outline-secondary">Buscar</a>
		  					</div>
						</div>
					</form>
					<c:if test="${not empty messages}">
						<span class="alert alert-warning">${messages}</span>
					</c:if>
				</div>
			</aside>
			<main class="col-10 invisible"></main>
			<main class="col offset-2 h-100">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb mt-3">
				    	<li class="breadcrumb-item"><a href="${contextPath}/chamado">Chamados</a></li>
				    	<li class="breadcrumb-item">Detalhes</li>
				    	<li class="breadcrumb-item active" aria-current="page">${chamado.protocoloChamado}</li>
					</ol>
				</nav>
				<div class="container-fluid" style="margin-top: 1em;">
					<div class="row">
						
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>