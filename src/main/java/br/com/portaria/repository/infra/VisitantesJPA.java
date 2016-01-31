package br.com.portaria.repository.infra;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.portaria.model.Visitante;
import br.com.portaria.repository.Visitantes;

public class VisitantesJPA implements Visitantes, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@Override
	public Visitante guardar(Visitante visitante) {
		manager.getTransaction().begin();
		visitante = manager.merge(visitante);
		manager.getTransaction().commit();
		
		return visitante;
	}

	@Override
	public List<Visitante> todos() {
		return manager.createQuery("from Visitante order by dataVisita desc",
				Visitante.class).getResultList();
	}

	@Override
	public Visitante porId(Long id) {
		return manager.find(Visitante.class, id);
	}
	
}
