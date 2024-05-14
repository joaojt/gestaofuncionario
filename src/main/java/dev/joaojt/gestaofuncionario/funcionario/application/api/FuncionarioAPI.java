package dev.joaojt.gestaofuncionario.funcionario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/funcionario")
public interface FuncionarioAPI {
	
	@PostMapping(value = "/insere")
	@ResponseStatus(code = HttpStatus.CREATED)
	FuncionarioResponse insereFuncionario(@RequestBody @Valid FuncionarioNovoRequest novoFuncionario);
	
	@DeleteMapping(value = "/deleta/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaFuncionario(@PathVariable UUID idFuncionario);
	
	@DeleteMapping(value = "/deletatodos")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaTodosFuncionarios();
	
	@GetMapping(value = "/busca/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.OK)
	FuncionarioResponse buscaFuncionarioPorId(@PathVariable UUID idFuncionario);
	
	@GetMapping(value = "/buscatodos")
	@ResponseStatus(code = HttpStatus.OK)
	List<FuncionarioResponse> buscaTodosFuncionarios();
	
	@PatchMapping(value = "/edita/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void editaFuncionario(@PathVariable UUID idFuncionario,@RequestBody @Valid FuncionarioCustomRequest funcionarioCustom);	

	@PatchMapping(value = "/editanome/{idFuncionario}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void editaNomeFuncionario(@PathVariable UUID idFuncionario,@RequestBody @Valid FuncionarioNomeRequest nomeFuncionario);
	
}
