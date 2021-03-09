package com.ens.Rest.WebService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ens.dto.ChamadoDTO;

@Path("/service")
public class Services {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/testeService")
	public String testeServiçe() {
		String string = "";
		return string;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public void incluir(ChamadoDTO dto) {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public ChamadoDTO listar() {
		ChamadoDTO chamado = null;
		return chamado;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public void atualizar(ChamadoDTO dto) {
		ChamadoDTO chamado = null;
	}

}
