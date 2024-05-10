package dev.joaojt.gestaofuncionario.funcionario.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class FuncionarioRepositoryException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    public FuncionarioRepositoryException(String message) {
        super(message);
    }
    
    @Override
    public String getMessage() {
        return super.getMessage();
    }    
    
}
