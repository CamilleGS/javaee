<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livraria</title>
<link rel="icon" href="imagens/bookshelf.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar livro</h1>
	<form name="frmLivro" action="update">
		<table>
			<tr>
				<td><input type="text" name="id"
					value="<%out.print(request.getAttribute("id")); %>" id="caixa3"
					readonly></td>
			</tr>
			<tr>
				<td><input type="text" name="nome"
					value="<%out.print(request.getAttribute("nome")); %>"
					class="caixa1"></td>
			</tr>
			<tr>
				<td><input type="text" name="autor"
					value="<%out.print(request.getAttribute("autor")); %>"
					class="caixa1"></td>
			</tr>
			<tr>
				<td><input type="number" name="numpg"
					value="<%out.print(request.getAttribute("numpg")); %>"
					class="caixa1"></td>
			</tr>
			<tr>
				<td><input type="number" name="valor"
					value="<%out.print(request.getAttribute("valor")); %>"
					class="caixa1"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>
