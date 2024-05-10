package dev.joaojt.gestaofuncionario.funcionario.domain;

import java.util.UUID;

import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioNovoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {

	@Id
	private UUID id;
	@Size(min = 3, max = 100)
	private String nome;
	private String designacao;
	@NotNull(message = "É obrigatório informar o salário do funcionário.")
	private Double salario;
	private String telefone;
	private String endereco;
	
	public Funcionario(FuncionarioNovoRequest novoFuncionario) {
		this.id = UUID.randomUUID();
		if (novoFuncionario.getNome() != null) {
			this.nome = novoFuncionario.getNome();
		}
		if (novoFuncionario.getDesignacao() != null) {
			this.designacao = novoFuncionario.getDesignacao();
		}
		if (novoFuncionario.getSalario() != null) {
			this.salario = novoFuncionario.getSalario();
		}
		if (novoFuncionario.getTelefone() != null) {
			this.telefone = novoFuncionario.getTelefone();
		}
		if (novoFuncionario.getEndereco() != null) {
			this.endereco = novoFuncionario.getEndereco();
		}
	}

}
