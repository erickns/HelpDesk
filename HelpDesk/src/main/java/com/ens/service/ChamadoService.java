package com.ens.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.ens.dto.ChamadoDTO;
import com.ens.dto.RetornoDTO;
import com.ens.model.domain.HttpsStatus;
import com.ens.repository.ChamadosRepository;

public class ChamadoService {
	
	@Inject private ChamadosRepository chamadosRepository;
	
	
	public RetornoDTO incluirChamado(ChamadoDTO dto) {
		Long idChamado = 0l;
		try {
			if (true) {
				idChamado = 0l;
			}
		}catch(Exception e) {
			return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.BAD_REQUEST.value())).withmensagem("Erro ao incluir chamado");			
		}
		return RetornoDTO.create().withcodigoStatus(String.valueOf(HttpsStatus.OK.value())).withmensagem("Chamado "+idChamado+" incluído com sucesso");	
	}
	
	public List<ChamadoDTO> listarChamados() {
		List<ChamadoDTO> dto = new ArrayList();
		return dto;
	}
	
	public ChamadoDTO buscar(Long id) {
		ChamadoDTO dto = new ChamadoDTO();
		return dto;
	}

}
