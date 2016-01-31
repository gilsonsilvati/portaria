package br.com.portaria.repository;

import java.util.List;

import br.com.portaria.model.Visitante;

public interface Visitantes {
	
	public Visitante guardar(Visitante visitante);

	public List<Visitante> todos();

	public Visitante porId(Long id);

}
