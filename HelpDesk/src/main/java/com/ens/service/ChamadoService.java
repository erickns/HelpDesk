package com.ens.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.ens.dto.ChamadoDTO;
import com.ens.dto.ComentarioDTO;
import com.ens.dto.ConsultaDTO;
import com.ens.dto.RetornoDTO;
import com.ens.model.Chamado;
import com.ens.model.Comentario;
import com.ens.model.domain.DominioStatus;
import com.ens.model.domain.HttpsStatus;
import com.ens.repository.ChamadosRepository;

public class ChamadoService {
	
	@Inject 
	private ChamadosRepository chamadosRepository =  new ChamadosRepository();
	private static final Logger logger = Logger.getLogger(ChamadoService.class.getName());

	
	
	public RetornoDTO salvarChamado(ChamadoDTO dto) {
		String msgSucesso ="atualizado";
		String msgErro ="atualizar";
		Long idChamado;
		try {
			if(dto.getId()==null) {
				dto.setDtInclusao(new Date());
				msgSucesso = "incluído";
				msgErro = "incluir";
			}
			else if(dto.getId()!=null && DominioStatus.FECHADO.equals(dto.getStatus()) ) {
				dto.setDtConclusao(new Date());
			}
			idChamado = chamadosRepository.salvarChamado(new Chamado(dto));
			
		}catch(Exception e) {
			logger.log(Level.WARNING, e.getMessage(),e);
			return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.BAD_REQUEST.value()))
					.withmensagem("Erro ao "+msgErro+" chamado");		
		}
		return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.OK.value())).withmensagem("Chamado "+idChamado+" "+msgSucesso+" com sucesso");	
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
			if(dto.getId()==null) {
				dto.setDtInclusao(new Date());
			}
			idComentario= chamadosRepository.salvarComentario(new Comentario(dto));
			
		}catch(Exception e) {
			logger.log(Level.WARNING, e.getMessage(),e);
			return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.BAD_REQUEST.value())).withmensagem("Erro ao incluir comentario");			
		}
		return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.OK.value())).withmensagem("Comentario incluído com sucesso");	
	}
	

}
