<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>
<% 
	String primeiroValor = request.getParameter("primeiroValor");
	String segundoValor = request.getParameter("segundoValor");
	String operador = request.getParameter("operacao");
	String resultado = request.getAttribute("resultado").toString();
	String contador = request.getAttribute("contador").toString();
%>
Primeiro operando: <% out.print(primeiroValor); %>
<br>
Segundo operando: <% out.print(segundoValor); %>
<br>
Operação: <% out.print(operador); %>
<br>
Resultado: <% out.print(resultado); %>
<br>
Número de vezes acessado: <% out.print(contador); %>
</body>
</html>