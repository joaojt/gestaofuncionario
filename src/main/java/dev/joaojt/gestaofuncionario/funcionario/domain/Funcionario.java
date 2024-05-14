package dev.joaojt.gestaofuncionario.funcionario.domain;

import java.util.Optional;
import java.util.UUID;

import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioCustomRequest;
import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioNomeRequest;
import dev.joaojt.gestaofuncionario.funcionario.application.api.FuncionarioNovoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
    @Size(message = "O nome do funcionário deve ter entre 3 e 100 caracteres.", min = 3, max = 100)
    @NotBlank(message = "O nome do funcionário não pode ser nulo ou vazio.")
	private String nome;
	private String designacao;
	@NotNull(message = "É obrigatório informar o salário do funcionário.")
	private Double salario;
	private String telefone;
	private String endereco;

	public void editaFuncionario(FuncionarioCustomRequest funcionarioCustom) {
		Optional.ofNullable(funcionarioCustom.getNome()).ifPresent(nome -> this.nome = nome);	
		Optional.ofNullable(funcionarioCustom.getDesignacao()).ifPresent(designacao -> this.designacao = designacao);	
		Optional.ofNullable(funcionarioCustom.getSalario()).ifPresent(salario -> this.salario = salario);	
		Optional.ofNullable(funcionarioCustom.getTelefone()).ifPresent(telefone -> this.telefone = telefone);	
		Optional.ofNullable(funcionarioCustom.getEndereco()).ifPresent(endereco -> this.endereco = endereco);		
	}

	public void editaNomeFuncionario(FuncionarioNomeRequest nomeFuncionario) {
		this.nome = nomeFuncionario.getNome();
	}

	public void insereFuncionario(FuncionarioNovoRequest novoFuncionario) {
		this.id = UUID.randomUUID();
		this.nome = novoFuncionario.getNome();
		Optional.ofNullable(novoFuncionario.getDesignacao()).ifPresent(designacao -> this.designacao = designacao);	
		this.salario = novoFuncionario.getSalario();
		Optional.ofNullable(novoFuncionario.getTelefone()).ifPresent(telefone -> this.telefone = telefone);	
		Optional.ofNullable(novoFuncionario.getEndereco()).ifPresent(endereco -> this.endereco = endereco);	
	}

}
