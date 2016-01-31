package br.com.portaria.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import br.com.portaria.model.Visitante;
import br.com.portaria.repository.Visitantes;

@WebServlet(urlPatterns = "/foto-visitante")
public class FotoVisitanteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Visitantes visitantes;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idVisitante = Long.valueOf(request.getParameter("visitante"));
		
		Visitante visitante = visitantes.porId(idVisitante);
		
		response.setContentType("image/jpeg");
		IOUtils.write(visitante.getFoto(), response.getOutputStream());
	}

}
