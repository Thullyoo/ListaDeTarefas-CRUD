package br.thullyoo.ListaDeTarefas.service;

import br.thullyoo.ListaDeTarefas.DTO.TarefaDTO;
import br.thullyoo.ListaDeTarefas.domain.Tarefa;
import br.thullyoo.ListaDeTarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }


    //CREATE
    public Tarefa criarTarefa(TarefaDTO dto) {
        Tarefa tarefa = new Tarefa(dto);
        tarefaRepository.save(tarefa);
        return tarefa;
    }


    //READ
    public List<Tarefa> verTarefas(){
        return tarefaRepository.findAll();
    }

    //UPDATE
    public Tarefa atualizarTarefa(Long id, TarefaDTO dto){
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
        if (optionalTarefa.isPresent()){
            Tarefa tarefaAtualizada = optionalTarefa.get();

            if (dto.descricao() != null ){
                tarefaAtualizada.setDescricao(dto.descricao());
            }
            if (dto.nome() != null  ){
                tarefaAtualizada.setNome(dto.nome());
            }
            if (dto.pendencia() != null){
                tarefaAtualizada.setPedencia(dto.pendencia());
            }
            if (dto.prioridade() != null){
                tarefaAtualizada.setPrioridade(dto.prioridade());
            }
            tarefaRepository.save(tarefaAtualizada);
            return tarefaAtualizada;
        }
        return null;
    }

    //DELETE
    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }




}
