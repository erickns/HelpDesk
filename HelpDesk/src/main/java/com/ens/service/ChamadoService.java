package com.ens.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ens.dto.ChamadoDTO;
import com.ens.dto.ComentarioDTO;
import com.ens.dto.ConsultaDTO;
import com.ens.dto.RetornoDTO;
import com.ens.model.Chamado;
import com.ens.model.Comentario;
import com.ens.model.domain.HttpsStatus;
import com.ens.repository.ChamadosRepository;

public class ChamadoService {
	
	@Inject 
	private ChamadosRepository chamadosRepository =  new ChamadosRepository();
	
	
	public RetornoDTO salvarChamado(ChamadoDTO dto) {
		Long idChamado=null;
		try {
			idChamado= chamadosRepository.salvarChamado(new Chamado(dto));
			
			if(dto.getComentarios().size()>0) {
				for(Comentario comentario:dto.getComentarios()) {
					comentario.setIdChamado(idChamado);
					chamadosRepository.salvarComentario(comentario);
				}
			}
			
			
		}catch(Exception e) {
			return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.BAD_REQUEST.value())).withmensagem("Erro ao incluir chamado");			
		}
		return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.OK.value())).withmensagem("Chamado "+idChamado+" incluído com sucesso");	
	}
	
	public List<ChamadoDTO> listarChamados(ConsultaDTO dto) {
		List<ChamadoDTO> list= new ArrayList<ChamadoDTO>();
		for(Chamado model:chamadosRepository.listarChamado(dto)) {
			ChamadoDTO dtoRetorno= new ChamadoDTO(model);
			list.add(dtoRetorno);
		}
		return list;
	}
	
	public ChamadoDTO buscarChamado(Long id) {
		Chamado m = chamadosRepository.buscar(id);
		ChamadoDTO dto = new ChamadoDTO(m);
		
		for(Comentario commentModel: chamadosRepository.listarComentarios(dto.getId())) {
			dto.getComentarios().add(commentModel);
		}
		
		return dto;
	}
	
	public RetornoDTO salvarComentario(ComentarioDTO dto) {
		Long idComentario=null;
		try {
			idComentario= chamadosRepository.salvarComentario(new Comentario(dto));
			
		}catch(Exception e) {
			return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.BAD_REQUEST.value())).withmensagem("Erro ao incluir comentario");			
		}
		return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.OK.value())).withmensagem("Comentario incluído com sucesso");	
	}
	

}
