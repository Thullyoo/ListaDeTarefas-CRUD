package br.thullyoo.ListaDeTarefas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Lista de Tarefas API", version = "1.0", description = "API para um sistema de criação de lista de tarefas"))
public class ListaDeTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaDeTarefasApplication.class, args);
	}

}
