package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The id. */
	private String id;
	
	/** The nome. */
	private String nome;
	
	/** The autor. */
	private String autor;
	
	/** The numpg. */
	private String numpg;
	
	/** The valor. */
	private String valor;
	
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param autor the autor
	 * @param numpg the numpg
	 * @param valor the valor
	 */
	public JavaBeans(String id, String nome, String autor, String numpg, String valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.numpg = numpg;
		this.valor = valor;
	}


	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the numpg.
	 *
	 * @return the numpg
	 */
	public String getNumpg() {
		return numpg;
	}
	
	/**
	 * Sets the numpg.
	 *
	 * @param numpg the new numpg
	 */
	public void setNumpg(String numpg) {
		this.numpg = numpg;
	}
	
	/**
	 * Gets the autor.
	 *
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * Sets the autor.
	 *
	 * @param autor the new autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/**
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	
	/**
	 * Sets the valor.
	 *
	 * @param valor the new valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
}
