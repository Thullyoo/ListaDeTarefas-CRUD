package br.thullyoo.ListaDeTarefas.repository;

import br.thullyoo.ListaDeTarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository  extends JpaRepository<Tarefa, Long> {
}
