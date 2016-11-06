<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gerenciador de Contatos - Página Inicial</title>
</head>
<body>
	<div align="center">
		<h1>Lista de Contatos</h1>
		<h3>
			<a href="novo">Novo Contato</a>
		</h3>
		<table border="1">
			<tr>
				<th>No.</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Telefone</th>
				<th>Ações</th>
			</tr>

			<c:forEach var="contato" items="${contatos}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${contato.nome}</td>
					<td>${contato.email}</td>
					<td>${contato.endereco}</td>
					<td>${contato.telefone}</td>
					<td><a href="/editar?id=${contato.codigo}">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="/excluir?id=${contato.codigo}">Excluir</a>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>