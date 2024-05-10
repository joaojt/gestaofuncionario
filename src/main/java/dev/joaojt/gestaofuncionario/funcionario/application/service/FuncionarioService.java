package dev.joaojt.gestaofuncionario.funcionario.application.service;

import java.util.List;
import java.util.UUID;

import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioCustomRequest;
import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioNomeRequest;
import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioNovoRequest;
import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioResponse;

public interface FuncionarioService {

	FuncionarioResponse insereFuncionario(FuncionarioNovoRequest novofuncionario);

	FuncionarioResponse buscaFuncionarioPorId(UUID idFuncionario);

	void deletaFuncionario(UUID idFuncionario);

	void editaNomeFuncionario(UUID idFuncionario, FuncionarioNomeRequest nomeFuncionario);

	void editaFuncionario(UUID idFuncionario, FuncionarioCustomRequest funcionarioCustom);

	List<FuncionarioResponse> buscaTodosFuncionarios();

	void deletaTodosFuncionarios();
}
