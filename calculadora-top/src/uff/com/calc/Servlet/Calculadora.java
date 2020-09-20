package uff.com.calc.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculadora
 */
@WebServlet("/calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public Calculadora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");		
		String primeiroValor = request.getParameter("primeiroValor");
		String segundoValor = request.getParameter("segundoValor");
		String operacao = request.getParameter("operacao");
		double primeiroValorDouble = Double.parseDouble(primeiroValor);
		double segundoValorDouble = Double.parseDouble(segundoValor);
		double resultado = 0;
		PrintWriter out = response.getWriter();

		if (operacao.equals("somar")) {
			resultado = primeiroValorDouble + segundoValorDouble;
		} else if (operacao.equals("subtrair")) {
			resultado = primeiroValorDouble - segundoValorDouble;
		} else if (operacao.equals("dividir")) {
			resultado = primeiroValorDouble / segundoValorDouble;
		} else if (operacao.equals("multiplicar")) {
			resultado = primeiroValorDouble * segundoValorDouble;
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			out.print("Erro " + HttpServletResponse.SC_BAD_REQUEST);
			out.print("Operação inválida");
			return;
		}
		request.setAttribute("resultado", resultado);
		
		int contador = 1;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("contador")) {				
				contador = Integer.parseInt(cookie.getValue()) + 1;
				break;
			}
		}
		Cookie cookie = new Cookie("contador", String.valueOf(contador));
		response.addCookie(cookie);
		request.setAttribute("contador", contador);
		request.getRequestDispatcher("./resultado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
