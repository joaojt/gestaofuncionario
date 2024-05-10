package dev.joaojt.gestaofuncionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dev.joaojt.gestaofuncionario")
public class GestaofuncionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaofuncionarioApplication.class, args);
	}

}
