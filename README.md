# Alura Fake

Implementação do desafio técnico conforme a [especificação](README.md).

## Funcionalidades implementadas

### Tarefas

- `POST/ task/new/opentext`: Adicionar nova tarefa com campo aberto
- `POST/ task/new/singlechoice`: Adicionar nova tarefa com uma alternativa correta
- `POST/ task/new/multiplechoice`: Adicionar nova tarefa com multiplas alternativas corretas

A criação de uma nova tarefa só será possível se ela respeitar as [validações](src/main/java/br/com/alura/AluraFake/task/TaskValidator.java)

### Cursos

- `PUT/ course/{courseId}/publish`: Publica um curso já cadastrado na base

A publicação será realizada caso o curso cadastrado respeite as [validações](src/main/java/br/com/alura/AluraFake/course/PublishCourseValidator.java)


## Relatório

- `GET/ instructor/{userId}/courses`

Retorna um relatório do instrutor com os seus cursos criados e quantidade de cursos publicados

## Executando o projeto

Para levantar os serviços (aplicação e banco de dados) execute os comandos abaixo
```bash
docker-compose up --build -d
```
Para para-los e remover os containers execute o comando
```bash
docker-compose down
```