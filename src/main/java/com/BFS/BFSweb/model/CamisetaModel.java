package com.BFS.BFSweb.model;

// TODO: Auto-generated Javadoc
/**
 * The Class CamisetaModel.
 */
public class CamisetaModel {

	/** The id. */
	// atributos
	private int id;
	
	/** The nombre. */
	private String nombre;
	
	/** The descripcion. */
	private String descripcion;
	
	/** The precio. */
	private double precio;
	
	/** The srcimagen. */
	private String srcimagen;
	
	/** The categoria. */
	private String categoria;

	/**
	 * Instantiates a new camiseta model.
	 */
	// constructores
	public CamisetaModel() {
		
	}
	
	/**
	 * Instantiates a new camiseta model.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param descripcion the descripcion
	 * @param precio the precio
	 * @param srcimagen the srcimagen
	 * @param categoria the categoria
	 */
	public CamisetaModel(int id, String nombre, String descripcion, double precio, String srcimagen, String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.srcimagen=srcimagen;
		this.categoria=categoria;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	// getters & setters
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * Gets the srcimagen.
	 *
	 * @return the srcimagen
	 */
	public String getSrcimagen() {
		return srcimagen;
	}
	
	/**
	 * Sets the srcimagen.
	 *
	 * @param srcimagen the new srcimagen
	 */
	public void setSrcimagen(String srcimagen) {
		this.srcimagen = srcimagen;
	}
	
	/**
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	
	/**
	 * Sets the categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
