package com.BFS.BFSweb.converter;

import com.BFS.BFSweb.entity.Camiseta;
import com.BFS.BFSweb.model.CamisetaModel;

// TODO: Auto-generated Javadoc
/**
 * The Class CamisetaConverter.
 */
public class CamisetaConverter {
	
	/**
	 * Entity 2 model.
	 *
	 * @param camiseta the camiseta
	 * @return the camiseta model
	 */
	// Entity-->Model
	public CamisetaModel entity2model(Camiseta camiseta) {
		CamisetaModel camisetaModel = new CamisetaModel();
		camisetaModel.setId(camiseta.getId());
		camisetaModel.setNombre(camiseta.getNombre());
		camisetaModel.setDescripcion(camiseta.getDescripcion());
		camisetaModel.setPrecio(camiseta.getPrecio());
		camisetaModel.setCategoria(camiseta.getCategoria());
		return camisetaModel;
	}
	
	/**
	 * Model 2 entity.
	 *
	 * @param camisetaModel the camiseta model
	 * @return the camiseta
	 */
	// Model-->Entity
	public Camiseta model2entity(CamisetaModel camisetaModel) {
		Camiseta camiseta = new Camiseta();
		camiseta.setId(camisetaModel.getId());
		camiseta.setNombre(camisetaModel.getNombre());
		camiseta.setDescripcion(camisetaModel.getDescripcion());
		camiseta.setPrecio(camisetaModel.getPrecio());
		camiseta.setCategoria(camisetaModel.getCategoria());
		return camiseta;
	}
	
}
