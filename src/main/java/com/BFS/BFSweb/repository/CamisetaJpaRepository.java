package com.BFS.BFSweb.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BFS.BFSweb.entity.Camiseta;

// TODO: Auto-generated Javadoc
/**
 * The Interface CamisetaJpaRepository.
 */
@Repository("camisetaJpaRepository")
public interface CamisetaJpaRepository extends JpaRepository<Camiseta, Serializable>{
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the camiseta
	 */
	public abstract Camiseta findById(int id);

	/**
	 * Find by id order by precio.
	 *
	 * @param id the id
	 * @param precio the precio
	 * @return the list
	 */
	public abstract List<Camiseta> findByIdOrderByPrecio (int id, double precio);
	
}
