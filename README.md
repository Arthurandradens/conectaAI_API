# ConectaAI

API para um aplicativo mobile de gerenciamento de ingressos institucionais. Este projeto, desenvolvido em **Spring Boot**, oferece funcionalidades como gerenciamento de usuários, criação de eventos, inscrições e desinscrições, além de permitir a consulta de eventos em que os usuários estão inscritos. O projeto utiliza **Docker** para simplificar a configuração e a execução.

---

## Funcionalidades Principais

- **Cadastro de Usuários**: Com diferentes papéis (INSTITUTE, TEACHER, STUDENT).
- **Login**: Implementado com Spring Security.
- **Gerenciamento de Eventos**:
  - Criação de eventos por INSTITUTE e TEACHER.
  - Inscrição e desinscrição de eventos para STUDENT.
  - Listagem de eventos inscritos por um usuário.
- **Modelagem de Entidades**:
  - Usuários (users).
  - Eventos (events).
  - Instituições (institutions).
  - Professores (teachers).
  - Estudantes (students).
  - Inscrições (enrollments).

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **MySQL 5.7** (rodando em container Docker)
- **Flyway** (migração de banco de dados)
- **Lombok**
- **JWT Authentication** (com `java-jwt`)
- **OpenAPI (Swagger UI)** para documentação de API
- **ModelMapper** para mapeamento de objetos

---

## Pré-requisitos

- **Docker** e **Docker Compose** instalados.

---

## Configuração do Projeto

1. **Clonar o repositório**:
   ```bash
   git clone https://github.com/Arthurandradens/conectaAI_API.git
   cd conectaAI
   ```

2. **Criar um arquivo `.env` na raiz do projeto** com as seguintes informações:
   ```env
   MYSQLDB_USER=root
   MYSQLDB_ROOT_PASSWORD=root
   MYSQLDB_DATABASE=conectaedu
   MYSQLDB_LOCAL_PORT=3307
   MYSQLDB_DOCKER_PORT=3306

   SPRING_LOCAL_PORT=8080
   SPRING_DOCKER_PORT=8080
   ```

---

## Rodando o Projeto

1. **Subir os containers Docker**:
   ```bash
   docker compose up
   ```

2. **Acessar a aplicação**:
    - API: [http://localhost:8080](http://localhost:8080)
    - Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

3. **Parar o projeto**:
   ```bash
   docker compose down
   ```
   Ou, alternativamente, parar containers específicos:
   ```bash
   docker stop {id_do_container}
   ```

---

## Estrutura do Banco de Dados

### Tabelas Principais

- **users**: Armazena informações dos usuários (INSTITUTE, TEACHER, STUDENT).
- **events**: Detalhes sobre os eventos criados.
- **institutions**, **teachers**, **students**: Relacionam os usuários aos seus papéis.
- **enrollments**: Controla as inscrições de estudantes nos eventos.

---

## Scripts de Migração (Flyway)

Os scripts de migração são executados automaticamente ao iniciar o projeto e criam as tabelas, além de inserir dados iniciais para testes.

---

## Contribuição

1. Fork este repositório.
2. Crie um branch para suas alterações:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça o commit:
   ```bash
   git commit -m "Adiciona minha feature"
   ```
4. Faça o push para o branch:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request.

---

## Licença

Este projeto está sob a licença [MIT](LICENSE).

---

## Contato

Para mais informações, entre em contato com o desenvolvedor.