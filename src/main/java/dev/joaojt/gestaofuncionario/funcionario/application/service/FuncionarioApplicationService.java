package dev.joaojt.gestaofuncionario.funcionario.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioCustomRequest;
import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioNomeRequest;
import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioNovoRequest;
import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioResponse;
import dev.joaojt.gestaofuncionario.funcionario.application.repository.FuncionarioRepository;
import dev.joaojt.gestaofuncionario.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class FuncionarioApplicationService implements FuncionarioService{
	
	private final FuncionarioRepository funcionarioRepository;
	
	@Override
	public FuncionarioResponse insereFuncionario(FuncionarioNovoRequest novoFuncionario) {
		log.info("[inicia] FuncionarioApplicationService - insereFuncionario");
		Funcionario funcionario = new Funcionario();
		funcionario.insereFuncionario(novoFuncionario);
		funcionarioRepository.salvaFuncionario(funcionario);
		log.info("[finaliza] FuncionarioApplicationService - insereFuncionario");
		return new FuncionarioResponse(funcionario);
	}

	@Override
	public FuncionarioResponse buscaFuncionarioPorId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioApplicationService - buscaFuncionarioPorId");
		Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
		log.info("[finaliza] FuncionarioApplicationService - buscaFuncionarioPorId");
		return new FuncionarioResponse(funcionario);
	}

	@Override
	public void deletaFuncionario(UUID idFuncionario) {
		log.info("[inicia] FuncionarioApplicationService - deletaFuncionario");
		Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
		funcionarioRepository.deletaFuncionario(funcionario);
		log.info("[finaliza] FuncionarioApplicationService - deletaFuncionario");
	}
	
	@Override
	public void deletaTodosFuncionarios() {
		log.info("[finaliza] FuncionarioApplicationService - deletaTodosFuncionarios");
		funcionarioRepository.deletaTodosFuncionarios();
		log.info("[finaliza] FuncionarioApplicationService - deletaTodosFuncionarios");
	}	

	@Override
	public void editaNomeFuncionario(UUID idFuncionario, FuncionarioNomeRequest nomeFuncionario) {
		log.info("[inicia] FuncionarioApplicationService - editaNomeFuncionario");
		Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
		funcionario.editaNomeFuncionario(nomeFuncionario);
		funcionarioRepository.salvaFuncionario(funcionario);
		log.info("[finaliza] FuncionarioApplicationService - editaNomeFuncionario");		
	}

	@Override
	public void editaFuncionario(UUID idFuncionario, FuncionarioCustomRequest funcionarioCustom) {
		log.info("[inicia] FuncionarioApplicationService - editaFuncionario");
		Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
		funcionario.editaFuncionario(funcionarioCustom);
		funcionarioRepository.salvaFuncionario(funcionario);
		log.info("[finaliza] FuncionarioApplicationService - editaFuncionario");
	}
	
	@Override
	public List<FuncionarioResponse> buscaTodosFuncionarios() {
		log.info("[inicia] FuncionarioApplicationService - buscaTodosFuncionarios");
		List<Funcionario> funcionarios = funcionarioRepository.buscaTodosFuncionarios();
		log.info("[finaliza] FuncionarioApplicationService - buscaTodosFuncionarios");
		return FuncionarioResponse.converter(funcionarios);
	}	
	
}