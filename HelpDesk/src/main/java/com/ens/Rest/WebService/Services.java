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
	
	@Inject ChamadoService chamadoService = new ChamadoService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public RetornoDTO incluir(ChamadoDTO dto) {
		return chamadoService.salvarChamado(dto);
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public List<ChamadoDTO> listar(@QueryParam("id")Long id,
			@QueryParam("dtInicio")String dtInicio,
			@QueryParam("dtFim")String dtFim,
			@QueryParam("Status")String status) {
	
		ConsultaDTO dto = new ConsultaDTO(id, status,dtInicio, dtFim);		
		return chamadoService.listarChamados(dto);
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public ChamadoDTO buscar(@PathParam("id")Long id) {
		return chamadoService.buscarChamado(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public RetornoDTO atualizar(ChamadoDTO dto) {
		return chamadoService.salvarChamado(dto);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir/comentario")
	public RetornoDTO incluirComentario(ComentarioDTO dto) {
		return chamadoService.salvarComentario(dto);
	}

}
