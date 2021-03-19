package com.ens.Rest.WebService;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ens.dto.ChamadoDTO;
import com.ens.dto.ComentarioDTO;
import com.ens.dto.ConsultaDTO;
import com.ens.dto.RetornoDTO;
import com.ens.model.domain.DominioStatus;
import com.ens.service.ChamadoService;

@Path("/service")
public class Services {

	@Inject
	ChamadoService chamadoService = new ChamadoService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Response incluir(ChamadoDTO dto) {
		return Response.ok().entity(chamadoService.salvarChamado(dto)).build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public Response listar(@QueryParam("idChamado") Long idChamado, @QueryParam("status") String status,
			@QueryParam("dtInicio") String dtInicio, @QueryParam("dtFim") String dtFim) {

		ConsultaDTO dto = new ConsultaDTO(idChamado, status, dtInicio, dtFim);
		return Response.ok().entity(chamadoService.listarChamados(dto)).build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public Response buscar(@PathParam("id") Long id) {
		return Response.ok().entity(chamadoService.buscarChamado(id)).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public Response atualizar(ChamadoDTO dto) {
		return Response.ok().entity(chamadoService.salvarChamado(dto)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir/comentario")
	public Response incluirComentario(ComentarioDTO dto) {
		return Response.ok().entity(chamadoService.salvarComentario(dto)).build();
	}

}
