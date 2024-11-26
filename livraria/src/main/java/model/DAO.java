package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  modulo de conexão *. */
	// parametros
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dblivros?useTimezone=true&severTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "1234";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// metodo
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Teste conexao.
	 */
	// teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Inserir livro.
	 *
	 * @param livro the livro
	 */
	// crude create
	public void inserirLivro(JavaBeans livro) {
		String create = "insert into livros (nome, autor, numpag, valor) values(?,?,?,?)";
		try {
			// abrir a conexao com o banco
			Connection con = conectar();
			// preparar a query (prepared statement)
			PreparedStatement pst = con.prepareStatement(create);
			// substitruir com o conteudo do javebeans
			pst.setString(1, livro.getNome());
			pst.setString(2, livro.getAutor());
			pst.setString(3, livro.getNumpg());
			pst.setString(4, livro.getValor());

			// executar query
			pst.executeUpdate();
			// encerrar conexao com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Listar livros.
	 *
	 * @return the array list
	 */
	//crud read
	public ArrayList<JavaBeans> listarLivros(){
		ArrayList<JavaBeans> livros = new ArrayList<>();
		String read = "select * from livros order by id";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//laço será executado enquanto houver livros
			while(rs.next()){
				//var de apoio
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String autor = rs.getString(3);
				String numpag = rs.getString(4);
				String valor = rs.getString(5);
				
				//alimentar esse array
				livros.add(new JavaBeans(id, nome, autor, numpag, valor));
				
			}
			con.close();
			return livros;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//crud update
	/**
	 * Selecionar livro.
	 *
	 * @param livro the livro
	 */
	//selecionar livro
	public void selecionarLivro(JavaBeans livro) {
		String read2 = "select * from livros where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, livro.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				livro.setId(rs.getString(1));
				livro.setNome(rs.getString(2));
				livro.setAutor(rs.getString(3));
				livro.setNumpg(rs.getString(4));
				livro.setValor(rs.getString(5));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar livro.
	 *
	 * @param livro the livro
	 */
	//editar contato 
	public void alterarLivro(JavaBeans livro) {
		String create = "update livros set nome=?, autor=?, numpag=?, valor=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst. setString(1, livro.getNome());
			pst. setString(2, livro.getAutor());
			pst. setString(3, livro.getNumpg());
			pst. setString(4, livro.getNumpg());
			pst. setString(5, livro.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar livro.
	 *
	 * @param livro the livro
	 */
	//CRUD DELETE
	public void deletarLivro(JavaBeans livro) {
		String delete = "delete from livros where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst. setString(1, livro.getId());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

