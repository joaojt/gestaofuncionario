package dev.joaojt.gestaofuncionario.funcionario.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.joaojt.gestaofuncionario.funcionario.domain.Funcionario;

public interface FuncionarioRepositoryJpa extends JpaRepository<Funcionario, UUID>{

}
