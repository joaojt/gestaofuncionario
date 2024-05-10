package dev.joaojt.gestaofuncionario.funcionario.application.repository;

import java.util.List;
import java.util.UUID;

import dev.joaojt.gestaofuncionario.funcionario.domain.Funcionario;

public interface FuncionarioRepository {
	
	Funcionario salvaFuncionario(Funcionario funcionario);

	Funcionario buscaFuncionarioPorId(UUID idFuncionario);

	void deletaFuncionario(Funcionario funcionario);

	List<Funcionario> buscaTodosFuncionarios();

	void deletaTodosFuncionarios();
	
}
