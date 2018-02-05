package com.BFS.BFSweb.service;

import java.util.List;
import com.BFS.BFSweb.entity.Camiseta;

// TODO: Auto-generated Javadoc
/**
 * The Interface CamisetaService.
 */
public interface CamisetaService {
	
	/**
	 * List all camisetas.
	 *
	 * @return the list
	 */
	public abstract List<Camiseta> listAllCamisetas();
	
	/**
	 * Adds the camiseta.
	 *
	 * @param camiseta the camiseta
	 * @return the camiseta
	 */
	public abstract Camiseta addCamiseta(Camiseta camiseta);
	
	/**
	 * Removecamiseta.
	 *
	 * @param id the id
	 */
	public abstract void removecamiseta(int id);
	
	/**
	 * Update camiseta.
	 *
	 * @param camiseta the camiseta
	 * @return the camiseta
	 */
	public abstract Camiseta updateCamiseta(Camiseta camiseta);
	
	/**
	 * Find camiseta by id.
	 *
	 * @param id the id
	 * @return the camiseta
	 */
	public abstract Camiseta findCamisetaById(int id);
	
}
