# API de Lista de Tarefas (Java 🚀 com Spring Boot 🍃)

Este é um projeto Java que implementa uma API CRUD para gerenciar uma lista de tarefas. A API permite a criação, leitura, atualização e exclusão de tarefas.

## Configuração

1. Clone o repositório para sua máquina local:

    ```bash
    git clone https://github.com/seu-usuario/nome-do-repositorio.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd ListaDeTarefas-CRUD
    ```

3. Instale as dependências com o maven


4. Execute a aplicação:

A aplicação estará rodando em `http://localhost:8080`.

## Uso

Você também pode acessar o Swagger UI que utilizei para documentar a API pelo seguinte link: `http://localhost:8080/swagger-ui/index.html`

### Endpoints

- `GET /tarefas`: Retorna todas as tarefas.
- `POST /tarefas`: Cria uma nova tarefa.
- `PUT /tarefas/{id}`: Atualiza uma tarefa existente com o ID fornecido.
- `DELETE /tarefas/{id}`: Exclui uma tarefa existente com o ID fornecido.

### Formato dos dados

As requisições e respostas são no formato JSON. Exemplo de uma como deve passar o JSON no POST:

```json
{
  "nome": "Fazer compras"
  "descricao": "Comprar leite e pão",
  "pendencia": true,
  "prioridade": 1
}
