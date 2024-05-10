package dev.joaojt.gestaofuncionario.funcionario.application.api;

import java.util.Map;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioCustomRequest {
	
	@Size(min = 3, max = 100)
    private String nome;
    private String designacao;
    private Double salario;
    private String telefone;
    private String endereco;

    public FuncionarioCustomRequest(Map<String, Object> funcionario) {

        if (funcionario.containsKey("nome")) {
            this.nome = (String) funcionario.get("nome");
        }
        if (funcionario.containsKey("designacao")) {
            this.designacao = (String) funcionario.get("designacao");
        }
        if (funcionario.containsKey("salario")) {
            this.salario = (Double) funcionario.get("salario");
        }
        if (funcionario.containsKey("telefone")) {
            this.telefone = (String) funcionario.get("telefone");
        }
        if (funcionario.containsKey("endereco")) {
            this.endereco = (String) funcionario.get("endereco");
        }
    }

}
