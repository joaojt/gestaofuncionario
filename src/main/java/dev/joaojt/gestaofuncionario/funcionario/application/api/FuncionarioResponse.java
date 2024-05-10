package dev.joaojt.gestaofuncionario.funcionario.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.joaojt.gestaofuncionario.funcionario.domain.Funcionario;
import lombok.Getter;

@Getter
public class FuncionarioResponse {
	
	private final UUID id;
	private final String nome;
	private final String designacao;
	private final Double salario;
	private final String telefone;
	private final String endereco;
	
	public FuncionarioResponse(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.designacao = funcionario.getDesignacao();
		this.salario = funcionario.getSalario();
		this.telefone = funcionario.getTelefone();
		this.endereco = funcionario.getEndereco();		
	}

	public static List<FuncionarioResponse> converter(List<Funcionario> funcionarios) {
		return funcionarios.stream()
				.map(FuncionarioResponse::new)
				.collect(Collectors.toList());
	}
}
