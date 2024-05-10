package dev.joaojt.gestaofuncionario.funcionario.application.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FuncionarioNomeRequest {
	
    @Size(min = 3, max = 100)
    private final String nome;
    
    @JsonCreator
    public FuncionarioNomeRequest(@JsonProperty("nome") String nome) {
    	this.nome = nome;
	}
}
