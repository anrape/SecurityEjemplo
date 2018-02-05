package com.BFS.BFSweb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.BFS.BFSweb.entity.Camiseta;
import com.BFS.BFSweb.repository.CamisetaJpaRepository;
import com.BFS.BFSweb.service.CamisetaService;

// TODO: Auto-generated Javadoc
/**
 * The Class CamisetaServiceImpl.
 */
@Service("/camisetaServiceImpl")
public class CamisetaServiceImpl implements CamisetaService{
	
	/** The camiseta jpa repository. */
	@Autowired
	@Qualifier("camisetaJpaRepository")
	private CamisetaJpaRepository camisetaJpaRepository;
	
	/* (non-Javadoc)
	 * @see com.BFS.BFSweb.service.CamisetaService#listAllCamisetas()
	 */
	@Override
	public List<Camiseta> listAllCamisetas() {
		return camisetaJpaRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.BFS.BFSweb.service.CamisetaService#addCamiseta(com.BFS.BFSweb.entity.Camiseta)
	 */
	@Override
	public Camiseta addCamiseta(Camiseta camiseta) {
		return camisetaJpaRepository.save(camiseta);
	}

	/* (non-Javadoc)
	 * @see com.BFS.BFSweb.service.CamisetaService#removecamiseta(int)
	 */
	@Override
	public void removecamiseta(int id) {
		Camiseta camiseta = findCamisetaById(id);
		if(camiseta!=null) {
			camisetaJpaRepository.delete(id);
		}
	}

	/* (non-Javadoc)
	 * @see com.BFS.BFSweb.service.CamisetaService#updateCamiseta(com.BFS.BFSweb.entity.Camiseta)
	 */
	@Override
	public Camiseta updateCamiseta(Camiseta camiseta) {
		return camisetaJpaRepository.save(camiseta);
	}
	
	/* (non-Javadoc)
	 * @see com.BFS.BFSweb.service.CamisetaService#findCamisetaById(int)
	 */
	@Override
	public Camiseta findCamisetaById(int id) {
		return camisetaJpaRepository.findById(id);
	}
	
}
