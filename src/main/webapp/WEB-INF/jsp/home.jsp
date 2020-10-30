<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">

<head>
<meta charset="ISO-8859-1">

<title>Virtualities - Home</title>

<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<style type="text/css">
.chover:hover {
	-webkit-box-shadow: 0px 0px 9px 6px rgba(0, 0, 0, 0.67);
	box-shadow: 0px 0px 9px 6px rgba(0, 0, 0, 0.67);
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

input[type=number] {
  -moz-appearance: textfield;
}
</style>

</head>
<body style="height: 100%; padding: 1em;">
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
				<div class="container-fluid h-100 mt-4">
					<div class="row">
						<div class="col-md-4" >
							<a href="${contextPath}/chamado/lista?status=aberto" style="display:block; text-decoration: none;">
								<div class="card border-success mx-sm-1 p-3 h-100 chover" id="abertos">
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
								<div class="card border-info mx-sm-1 p-3 h-100 chover" id="aguardando">
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
								<div class="card border-danger mx-sm-1 p-3 h-100 chover" id="fechados">
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
					<div class="row mt-2">
				        <div class="col-12">
				            <canvas id="myChart" height="100"></canvas>
				        </div>
				    </div>   
				</div>
			</main>
		</div>
	</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script>
var ctx = document.getElementById("myChart").getContext('2d');
var myChart = new Chart(ctx, {
	type: 'bar',
    data: {
    	labels: ${dia},
        datasets: [
            {
                label: "Abertos",
                backgroundColor: "green",
                data: ${qtdAberto}
            },
            {
                label: "Aguardando",
                backgroundColor: "blue",
                data: ${qtdAguardando}
            },
            {
                label: "Fechados",
                backgroundColor: "red",
                data: ${qtdFechado}
            }
        ]
    },
    options: {
        barValueSpacing: 20,
        scales: {
            yAxes: [{
                ticks: {
                    min: 0,
                    stepSize: 1
                }
            }]
        }
    }
});
</script>
</body>
</html>