package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The livro. */
	JavaBeans livro = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			livraria(request, response);
		} else if (action.equals("/insert")) {
			novoLivro(request, response);
		} else if (action.equals("/select")) {
			listarLivro(request, response);
		} else if (action.equals("/update")) {
			editarLivro(request, response);
		} else if (action.equals("/delete")) {
			removerLivro(request, response);
		} else {
			response.sendRedirect("index.html");
		}

		// teste de conexão
		dao.testeConexao();
	}

	/**
	 * Livraria.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// listar contatos
	protected void livraria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um obj que recebe os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarLivros();
		request.setAttribute("livros", lista);
		RequestDispatcher rd = request.getRequestDispatcher("livro.jsp");
		rd.forward(request, response);
	}

	/**
	 * Novo livro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// adc livr onovo
	protected void novoLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("autor"));
		// System.out.println(request.getParameter("numpg"));
		// System.out.println(request.getParameter("valor"));

		// setando val javabens
		livro.setNome(request.getParameter("nome"));
		livro.setAutor(request.getParameter("autor"));
		livro.setNumpg(request.getParameter("numpg"));
		livro.setValor(request.getParameter("valor"));

		// invocar o medtodo inserirLivro passando o objeto Livro
		dao.inserirLivro(livro);

		// redirecionar para livro.jsp
		response.sendRedirect("main");

	}

	/**
	 * Listar livro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// editar contato
	protected void listarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		livro.setId(id);
		dao.selecionarLivro(livro);

		request.setAttribute("id", livro.getId());
		request.setAttribute("nome", livro.getNome());
		request.setAttribute("autor", livro.getAutor());
		request.setAttribute("numpg", livro.getNumpg());
		request.setAttribute("valor", livro.getValor());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	/**
	 * Editar livro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println(request.getParameter("id"));
		// System.out.println(request.getParameter("autor"));
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("numpg"));
		// System.out.println(request.getParameter("valor"));

		// setar variaveis java beans
		livro.setId(request.getParameter("id"));
		livro.setNome(request.getParameter("nome"));
		livro.setAutor(request.getParameter("autor"));
		livro.setNumpg(request.getParameter("numpg"));
		livro.setValor(request.getParameter("valor"));
		dao.alterarLivro(livro);
		response.sendRedirect("main");
	}

	/**
	 * Remover livro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// remover contato
	protected void removerLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// System.out.println(id);
		livro.setId(id);
		dao.deletarLivro(livro);
		response.sendRedirect("main");

	}
}
