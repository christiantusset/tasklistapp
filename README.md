# taskList-app

App construído seguindo modelo UML, com as tecnologias:

- Backend em Java.
- Frontend em AngularJS.

##Previews

![ContentRoot](https://github.com/christiantusset/tasklistapp/blob/master/src/main/resources/imagens/1.png)
![ContentRoot](https://github.com/christiantusset/tasklistapp/blob/master/src/main/resources/imagens/2.png)

## API RESTful

#### Level 0
Expor serviço Web **HTTP**no Estilo REST

- http://localhost:8080/

#### Level 1
Expor recurso com URI utilizando**HTTP**para retornar Tarefa(s)

- GET - http://localhost:8080/tarefas
- GET - http://localhost:8080/tarefa/{id}

#### Level 2
Expor recursos com URI com os restantes **métodos HTTP**utilizados

- POST - http://localhost:8080/salvar
- PUT - http://localhost:8080/atualizar/{id}
- DELETE - http://localhost:8080/remover/{id}
