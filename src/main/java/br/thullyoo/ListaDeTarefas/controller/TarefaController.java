package br.thullyoo.ListaDeTarefas.controller;

import br.thullyoo.ListaDeTarefas.DTO.TarefaDTO;
import br.thullyoo.ListaDeTarefas.domain.Tarefa;
import br.thullyoo.ListaDeTarefas.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefas", produces = {"application/json"})
@Tag(name = "Lista de Tarefas API")
public class TarefaController {

    Logger logger = LoggerFactory.getLogger(TarefaController.class);
    private final TarefaService tarefaService;

    public TarefaController(TarefaService service){
        this.tarefaService = service;
    }

    @Operation(summary = "Realiza a criação da tarefa", method = "POST")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Tarefa criada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar tarefa")
    })
    @PostMapping()
    public ResponseEntity criarTarefa(@RequestBody TarefaDTO dto){
        Tarefa tarefa = tarefaService.criarTarefa(dto);
        return new ResponseEntity<>(tarefa, HttpStatus.OK);
    }

    @Operation(summary = "Busca todas as tarefas", method = "GET")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Lista de tarefas buscada com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Url de lista de tarefas não encontrada!"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar lista de tarefas")
    })
    @GetMapping
    public ResponseEntity verTarefas() throws Exception{
        try{
            List<Tarefa> listaDeTarefas = tarefaService.verTarefas();
            return new ResponseEntity<>(listaDeTarefas, HttpStatus.OK);
        } catch (Exception exception){
            logger.error("Ocorreu um erro ao buscar as tarefas: ", exception);
            return new ResponseEntity<>("Ocorreu um erro ao buscar as tarefas", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Operation(summary = "Atualiza uma tarefa", method = "PUT")
    @ApiResponses(value ={
        @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso!"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar tarefa")
    })
    @PutMapping( "/{id}")
    public ResponseEntity atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO dto){
        try {
            Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, dto);
            return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
        } catch (Exception exception){
            logger.error("Ocorreu um erro ao atualizar a tarefa: ", exception);
            return new ResponseEntity<>("Ocorreu um erro ao atualizar a tarefa ", HttpStatus.BAD_REQUEST);
        }

    }


    @Operation(summary = "Remove uma tarefa", method = "DELETE")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Tarefa removida com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao remover tarefa")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return new ResponseEntity<>("Tarefa deletado com sucesso!", HttpStatus.OK);
    }



}
