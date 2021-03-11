package com.ens.Rest.WebService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ens.dto.ChamadoDTO;
import com.ens.service.ChamadoService;

@Path("/service")
public class Services {
	
	@Inject ChamadoService chamadoService = new ChamadoService();
			

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/testeService")
	public String testeServiçe() {
		String string = "";
		return string;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Response incluir(ChamadoDTO dto) {
		return Response.ok().entity(chamadoService.incluirChamado(dto)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public Response listar() {
		
		return Response.ok().entity(chamadoService.listarChamados()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public Response buscar() {
		return Response.ok().entity(chamadoService.listarChamados()).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public void atualizar(ChamadoDTO dto) {
		ChamadoDTO chamado = null;
	}

}
