package dev.joaojt.gestaofuncionario.funcionario.application.api;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FuncionarioCustomRequest {
	
    @Size(message = "O nome do funcionário deve ter entre 5 e 50 caracteres.", min = 5, max = 50)
    private String nome;
    private String designacao;
    private Double salario;
    private String telefone;
    private String endereco;

}