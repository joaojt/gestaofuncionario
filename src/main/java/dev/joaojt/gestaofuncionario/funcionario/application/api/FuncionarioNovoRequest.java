package dev.joaojt.gestaofuncionario.funcionario.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FuncionarioNovoRequest {
	
    @Size(message = "O nome do funcionário deve ter entre 3 e 100 caracteres.", min = 3, max = 100)
    @NotBlank(message = "O nome do funcionário não pode ser nulo ou vazio.")
	private String nome;
	private String designacao;
	@NotNull(message = "É obrigatório informar o salário do funcionário.")
	private Double salario;
	private String telefone;
	private String endereco;
	
}
