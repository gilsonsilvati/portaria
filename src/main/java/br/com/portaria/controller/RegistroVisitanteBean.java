package br.com.portaria.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.portaria.model.Visitante;
import br.com.portaria.repository.Visitantes;
import br.com.portaria.util.FacesMessages;

@Named
@ViewScoped
public class RegistroVisitanteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FotoCameraBean fotoCamera;
	
	@Inject
	private Visitantes visitantes;
	
	@Inject
	private FacesMessages messages;
	
	private Visitante visitante;
	
	private List<Visitante> todosVisitantes;
	
	public void novo() {
		visitante = new Visitante();
		fotoCamera.limpar();
	}
	
	public void adicionar() {
		visitante.setDataVisita(new Date());
		visitante.setFoto(fotoCamera.getFotoBytes());
		
		visitantes.guardar(visitante);
		
		consultar();
		
		messages.info("Visitante registrado!");
		
		RequestContext.getCurrentInstance().execute("PF('novoVisitanteDialog').hide()");
		RequestContext.getCurrentInstance().update("frm:msg-geral");
	}
	
	public void consultar() {
		todosVisitantes = visitantes.todos();
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public List<Visitante> getTodosVisitantes() {
		return todosVisitantes;
	}
	
}
