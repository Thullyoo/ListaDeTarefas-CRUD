package br.thullyoo.ListaDeTarefas.DTO;


public record TarefaDTO(
        String nome,

        String descricao,

        Boolean pendencia,

        Integer prioridade
) {
}
