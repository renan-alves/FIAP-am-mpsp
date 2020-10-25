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

<script type="text/javascript">
	function setOpenActive() {
		var element = document.getElementById("abertos");
		element.classList.add("active");

		var waiting = document.getElementById("aguardando");
		waiting.classList.remove("active");
		var closed = document.getElementById("fechados");
		closed.classList.remove("active");
	}

	function setWaitingActive() {
		var element = document.getElementById("aguardando");
		element.classList.add("active");

		var open = document.getElementById("abertos");
		open.classList.remove("active");
		var closed = document.getElementById("fechados");
		closed.classList.remove("active");
	}

	function setClosedActive() {
		var element = document.getElementById("fechados");
		element.classList.add("active");

		var waiting = document.getElementById("aguardando");
		waiting.classList.remove("active");
		var open = document.getElementById("abertos");
		open.classList.remove("active");
	}
	
	function initializeActive(){
		if(window.location.pathname == "/chamado" || window.location.pathname == "/chamado/lista?status=aberto"){
			var element = document.getElementById("abertos");
			element.classList.add("active");
		} else if(window.location.pathname == "/chamado/lista?status=aguardando"){
			var element = document.getElementById("aguardando");
			element.classList.add("active");
		} else if(window.location.pathname == "/chamado/lista?status=fechado"){
			var element = document.getElementById("fechados");
			element.classList.add("active");
		}
	}
</script>

<style type="text/css">
.active {
	-webkit-box-shadow: 0px 0px 9px 6px rgba(0, 0, 0, 0.67);
	box-shadow: 0px 0px 9px 6px rgba(0, 0, 0, 0.67);
}
</style>

</head>
<body style="height: 100%;" onbeforeunload="initializeActive()">
	<div class="container-fluid h-100">
		<div class="row h-100">
			<aside class="col-2 px-0 fixed-top h-100" id="left">

				<div class="h-100 w-100" style="border-right: solid black 1px">
					<a href="#" class="list-group-item">HOME</a>
				</div>

			</aside>
			<main class="col-10 invisible"></main>
			<main class="col offset-2 h-100">
				<div class="container-fluid h-100 mt-4">
					<div class="row">

						<div class="col-md-4" >
							<a href="${contextPath}/chamado/lista?status=aberto" style="display:block; text-decoration: none;">
								<div class="card border-success mx-sm-1 p-3 h-100"
									onclick="setOpenActive();" id="abertos">
									<div class="card border-success text-success p-3 text-center">
										<span class="fa fa-check" aria-hidden="true"></span>
									</div>
									<div class="text-success text-center mt-3">
										<h4>Abertos</h4>
									</div>
									<div class="text-success text-center mt-2">
										<h1>${quantidadeAberto}</h1>
									</div>
								</div>
							</a>
						</div>

						<div class="col-md-4">
							<a href="${contextPath}/chamado/lista?status=aguardando" style="display:block; text-decoration: none;">
								<div class="card border-info mx-sm-1 p-3 h-100"
									onclick="setWaitingActive();" id="aguardando">
									<div class="card border-info text-info p-3 text-center">
										<span class="fa fa-check" aria-hidden="true"></span>
									</div>
									<div class="text-info text-center mt-3">
										<h4>Aguardando resposta</h4>
									</div>
									<div class="text-info text-center mt-2">
										<h1>${quantidadeAguardando}</h1>
									</div>
								</div>
							</a>
						</div>

						<div class="col-md-4">
							<a href="${contextPath}/chamado/lista?status=fechado" style="display:block; text-decoration: none;">
								<div class="card border-danger mx-sm-1 p-3 h-100"
									onclick="setClosedActive();" id="fechados">
									<div class="card border-danger text-danger p-3 text-center">
										<span class="fa fa-times" aria-hidden="true"></span>
									</div>
									<div class="text-danger text-center mt-3">
										<h4>Fechados</h4>
									</div>
									<div class="text-danger text-center mt-2">
										<h1>${quantidadeFechado}</h1>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
				<div class="container-fluid" style="margin-top: 1em;">
					<div class="row">
						<c:forEach items="${listaChamados}" var="item">
							<div class="col-5 m-auto">
								<div class="card text-center mb-3">
									<div class="card-header">Protocolo no
										#${item.protocoloChamado}</div>
									<div class="card-body">
										<h5 class="card-title">${item.tituloChamado}</h5>
										<p class="card-text">${item.descricaoChamado}</p>
										<a href="#" class="btn btn-primary">Visualizar</a>
									</div>
									<div class="card-footer text-muted">2 days ago</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>