package br.thullyoo.ListaDeTarefas.controller;

import br.thullyoo.ListaDeTarefas.DTO.TarefaDTO;
import br.thullyoo.ListaDeTarefas.domain.Tarefa;
import br.thullyoo.ListaDeTarefas.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Lista de Tarefas API")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService service){
        this.tarefaService = service;
    }

    @Operation(summary = "Realiza a criação da tarefa", method = "POST")
    @PostMapping()
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody TarefaDTO dto){
        Tarefa tarefa = tarefaService.criarTarefa(dto);
        return new ResponseEntity<>(tarefa, HttpStatus.OK);
    }

    @Operation(summary = "Busca todas as tarefas", method = "GET")
    @GetMapping
    public ResponseEntity<List<Tarefa>> verTarefas(){
        List<Tarefa> listaDeTarefas = tarefaService.verTarefas();
        return new ResponseEntity<>(listaDeTarefas, HttpStatus.OK);
    }

    @Operation(summary = "Atualiza uma tarefa", method = "PUT")
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO dto){
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, dto);
        return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
    }

    @Operation(summary = "Remove uma tarefa", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return new ResponseEntity<>("Tarefa deletado com sucesso!", HttpStatus.OK);
    }



}
