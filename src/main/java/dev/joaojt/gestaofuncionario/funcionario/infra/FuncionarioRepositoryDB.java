package dev.joaojt.gestaofuncionario.funcionario.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.joaojt.gestaofuncionario.funcionario.application.repository.FuncionarioRepository;
import dev.joaojt.gestaofuncionario.funcionario.domain.Funcionario;
import dev.joaojt.gestaofuncionario.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
@RequiredArgsConstructor
public class FuncionarioRepositoryDB implements FuncionarioRepository{
	
	private final FuncionarioRepositoryJpa funcionarioRepositoryJpa;
	
	@Override
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		log.info("[inicia] FuncionarioRepositoryDB - salvaFuncionario");
		Funcionario funcionarioNovo = funcionarioRepositoryJpa.save(funcionario);
		log.info("[finaliza] FuncionarioRepositoryDB - salvaFuncionario");
		return funcionarioNovo; 
	}

	@Override
	public Funcionario buscaFuncionarioPorId(UUID idFuncionario) {
		log.info("[inicia] FuncionarioRepositoryDB - buscaFuncionarioPorId");
		Funcionario funcionario = funcionarioRepositoryJpa.findById(idFuncionario)
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Funcionário não encontrado."));
		log.info("[finaliza] FuncionarioRepositoryDB - buscaFuncionarioPorId");
		return funcionario;
	}
	
	@Override
	public void deletaFuncionario(Funcionario funcionario) {
		log.info("[inicia] FuncionarioRepositoryDB - deletaFuncionario");
		funcionarioRepositoryJpa.delete(funcionario);
		log.info("[finaliza] FuncionarioRepositoryDB - deletaFuncionario");
	}

	@Override
	public List<Funcionario> buscaTodosFuncionarios() {
		log.info("[inicia] FuncionarioRepositoryDB - buscaTodosFuncionarios");
		List<Funcionario> funcionarios = funcionarioRepositoryJpa.findAll();
		log.info("[finaliza] FuncionarioRepositoryDB - buscaTodosFuncionarios");
		return funcionarios;
	}

	@Override
	public void deletaTodosFuncionarios() {
		log.info("[inicia] FuncionarioRepositoryDB - deletaTodosFuncionarios");
		funcionarioRepositoryJpa.deleteAll();
		log.info("[finaliza] FuncionarioRepositoryDB - deletaTodosFuncionarios");
	}
	
}
