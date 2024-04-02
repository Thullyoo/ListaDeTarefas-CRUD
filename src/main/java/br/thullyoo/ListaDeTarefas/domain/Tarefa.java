package br.thullyoo.ListaDeTarefas.domain;

import br.thullyoo.ListaDeTarefas.DTO.TarefaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TAREFAS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;

    private String descricao;

    private Boolean pedencia;

    private Integer prioridade;

    public Tarefa(TarefaDTO dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.pedencia = dto.pendencia();
        this.prioridade = dto.prioridade();
    }



}
