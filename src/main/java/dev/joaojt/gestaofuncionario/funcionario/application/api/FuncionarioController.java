package dev.joaojt.gestaofuncionario.funcionario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.joaojt.gestaofuncionario.funcionario.application.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class FuncionarioController implements FuncionarioAPI{
	
	private final FuncionarioService funcionarioService;

	@Override
	public FuncionarioResponse insereFuncionario(FuncionarioNovoRequest novoFuncionario) {
		log.info("[inicia] FuncionarioController - insereFuncionario");
		FuncionarioResponse funcionario = funcionarioService.insereFuncionario(novoFuncionario);
		log.info("[finaliza] FuncionarioController - insereFuncionario");
		return funcionario;
	}
    
	@Override
	public void deletaFuncionario(UUID idFuncionario) {
		log.info("[inicia] FuncionarioController - deletaFuncionario");
		funcionarioService.deletaFuncionario(idFuncionario);
		log.info("[finaliza] FuncionarioController - deletaFuncionario");
	}
	
	@Override
	public void deletaTodosFuncionarios() {
		log.info("[inicia] FuncionarioController - deletaTodosFuncionarios");
		funcionarioService.deletaTodosFuncionarios();
		log.info("[finaliza] FuncionarioController - deletaTodosFuncionarios");
	}	

	@Override
	public FuncionarioResponse buscaFuncionarioPorId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioController - buscaFuncionarioPorId");
		log.info("[idFuncionario] {}", idFuncionario);
		FuncionarioResponse funcionarioResponse = funcionarioService.buscaFuncionarioPorId(idFuncionario);
		log.info("[finaliza] FuncionarioController - buscaFuncionarioPorId");
		return funcionarioResponse;
	}

	@Override
	public void editaNomeFuncionario(UUID idFuncionario, FuncionarioNomeRequest nomeFuncionario) {
		log.info("[inicia] FuncionarioController - editaNomeFuncionario");
		funcionarioService.editaNomeFuncionario(idFuncionario, nomeFuncionario);
		log.info("[finaliza] FuncionarioController - editaNomeFuncionario");		
	}

	@Override
	public void editaFuncionario(UUID idFuncionario, FuncionarioCustomRequest funcionarioCustom) {
		log.info("[inicia] FuncionarioController - editaFuncionario");
		funcionarioService.editaFuncionario(idFuncionario, funcionarioCustom);
		log.info("[finaliza] FuncionarioController - editaFuncionario");			
	}

	@Override
	public List<FuncionarioResponse> buscaTodosFuncionarios() {
		log.info("[inicia] FuncionarioController - buscaTodosFuncionarios");			
		List<FuncionarioResponse> funcionarios = funcionarioService.buscaTodosFuncionarios();
		log.info("[finaliza] FuncionarioController - buscaTodosFuncionarios");			
		return funcionarios;
	}

}