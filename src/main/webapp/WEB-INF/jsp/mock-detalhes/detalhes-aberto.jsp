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
.msg_history {
  height: 516px;
  overflow-y: auto;
}
.incoming_msg_img {
  display: inline-block;
  width: 6%;
}
.received_msg {
  display: inline-block;
  padding: 0 0 0 10px;
  vertical-align: top;
  width: 92%;
  margin-bottom: 1em;
 }
 .received_withd_msg p {
  background: #ebebeb none repeat scroll 0 0;
  border-radius: 3px;
  color: #646464;
  font-size: 14px;
  margin: 0;
  padding: 5px 10px 5px 12px;
  width: 100%;
}
.time_date {
  color: #747474;
  display: block;
  font-size: 12px;
  margin: 8px 0 0;
}
.received_withd_msg { width: 57%;}
.mesgs {
  float: left;
  padding: 30px 15px 0 25px;
  height: 80vh;
}
 .sent_msg p {
  background: #05728f none repeat scroll 0 0;
  border-radius: 3px;
  font-size: 14px;
  margin: 0; color:#fff;
  padding: 5px 10px 5px 12px;
  width:100%;
}
.outgoing_msg{ 
	overflow:hidden; 
	margin:26px 0 26px;
}
.sent_msg {
  float: right;
  width: 46%;
}
img{ max-width:100%;}
.incoming_msg_img {
  display: inline-block;
  width: 6%;
}
.input_msg_write {
  width: 100%;
}
.input_msg_write input {
  background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
  border: medium none;
  color: #4c4c4c;
  font-size: 15px;
  min-height: 48px;
  width: 100%;
}
.type_msg {
	border-top: 1px solid #c4c4c4;
	position: fixed;
	bottom: 0;
	width: 100%
}
.msg_send_btn {
  background: #05728f none repeat scroll 0 0;
  border: medium none;
  border-radius: 50%;
  color: #fff;
  cursor: pointer;
  font-size: 17px;
  height: 33px;
  width: 33px;
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
						<div class="mesgs">
							<div class="outgoing_msg">
				              <div class="sent_msg">
				                <p>Em razão da pandemia do Coronavírus e da Resolução nº 1.198, de 20 de março de 2020, a Ouvidoria do Ministério Público de São Paulo receberá reclamações, denúncias, críticas, apreciações, comentários, elogios, pedido de informação e sugestões de qualquer interessado EXCLUSIVAMENTE pelo formulário.</p>
				                <span class="time_date"> 18:34 | Quinta-feira 29/10</span> </div>
				            </div>
				            <div class="incoming_msg">
				              <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
				              <div class="received_msg">
				                <div class="received_withd_msg">
				                  <p>Boa tarde! Quero informar que abriu um buraco na av. Principal</p>
				                  <span class="time_date"> 18:35 | Quinta-feira 29/10</span></div>
				              </div>
				            </div>
				            <div class="incoming_msg">
				              <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
				              <div class="received_msg">
				                <div class="received_withd_msg">
				                  <p>O que pode ser feito? Temos previsão de quando esse buraco for fechado? Obrigado</p>
				                  <span class="time_date"> 18:36 | Quinta-feira 29/10</span></div>
				              </div>
				            </div>
				          <div class="type_msg">
				            <div class="input_msg_write row">
				              <input type="text" class="write_msg col-9" placeholder="Digite sua mensagem" />
				              <div class="col-3 d-flex align-items-center">
				              	<button class="msg_send_btn" type="button"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
				              </div>				              
				            </div>
				          </div>
				      </div>
					</div>
				</div>
			</main>
		</div>
	</div>
</body>
</html>