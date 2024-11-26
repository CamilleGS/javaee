<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("livros");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Livros</title>
<link rel="icon" href="imagens/livro.png">
<link rel="stylesheet" href="style.css">

</head>
<body>
	<h1>Biblioteca de Livros</h1>
	<a href="novo.html" class="botao1">Novo Livro</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Autor</th>
				<th>Numero de páginas</th>
				<th>valor</th>
				<th>Opções</th>

			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getAutor()%></td>
				<td><%=lista.get(i).getNumpg()%></td>
				<td><%=lista.get(i).getValor()%></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>" class="botao">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getId()%>)"
					class="botao2">Excluir</a></td>

			</tr>

			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>