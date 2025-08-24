

# 📅 EventMark

**EventMark** é uma aplicação para gerenciamento de eventos, construída em **Java com Spring Boot**, seguindo princípios de arquitetura limpa e boas práticas de desenvolvimento.
O sistema permite **criar, listar, buscar e deletar eventos**, com suporte a diferentes **tipos de evento** (seminários, shows, feiras, etc.).

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot**
* **Spring Data JPA**
* **Lombok**
* **Docker & Docker Compose**
* **Maven**

---

## 📂 Estrutura do Projeto

```
src/main/java/dev/batist/EventMark
│── core
│   ├── entities (entidades de domínio)
│   │   └── enums (ex: Tipo.java)
│   ├── gateway (interfaces de persistência)
│   └── usecase (casos de uso: criar, buscar, atualizar, deletar eventos)
│
│── infrastructure
│   ├── config (configurações do projeto)
│   ├── controller (exposição via REST API)
│   ├── dtos (objetos de transferência de dados)
│   ├── exceptions (tratamento de exceções personalizadas)
│   ├── gateway (implementação dos repositórios)
│   ├── persistence (entidades JPA e mapeamentos)
│   └── repository (interfaces de repositórios Spring Data)
│
│── resources (arquivos de configuração)
│── EventMarkApplication.java (classe principal)
```

---

## 🗄️ Modelagem da Entidade

### **EventosEntity.java**

* `id` (Long) → Identificador único
* `nome` (String) → Nome do evento
* `descricao` (String) → Descrição do evento
* `inicio` / `fim` (LocalDateTime) → Período do evento
* `identificador` (String) → Código único
* `organizador` (String) → Responsável pelo evento
* `local` (String) → Local onde ocorrerá
* `capacidade` (Integer) → Número máximo de participantes
* `tipoEvento` (Enum) → Tipo (show, seminário, feira, networking...)

---

## 🌐 Endpoints da API

Base URL: `/api/v1/`

| Método     | Endpoint       | Descrição                        |
| ---------- | -------------- | -------------------------------- |
| **POST**   | `/criarevento` | Criar um novo evento             |
| **GET**    | `/listar`      | Listar todos os eventos          |
| **GET**    | `/{id}`        | Buscar evento pelo identificador |
| **DELETE** | `/{id}`        | Deletar evento pelo ID           |

---

## ▶️ Como Rodar o Projeto

### Pré-requisitos

* **Java 17+**
* **Maven**
* **Docker** (opcional para rodar em container)

### Rodando localmente

```bash
# Clone o repositório
git clone https://github.com/SEU_USUARIO/EventMark.git
cd EventMark

# Compile o projeto
mvn clean install

# Execute a aplicação
mvn spring-boot:run
```

A aplicação estará disponível em:
👉 `http://localhost:8080/api/v1`

### Rodando com Docker

```bash
# Build do container
docker-compose up --build
```

---

## ⚠️ Tratamento de Erros

O sistema possui **exceções personalizadas**:

* `EventoDuplicadoException` → Quando já existe evento com o mesmo identificador.
* `EventoNaoEncontrado` → Quando um evento não é localizado.
* `RestExceptionHandler` → Handler global para formatar erros.

---

## 📌 Futuras Melhorias

* Autenticação e autorização (JWT).
* Integração com banco relacional (MySQL/Postgres).
* Testes unitários e de integração.
* Documentação com Swagger/OpenAPI.

---

## 👨‍💻 Autor

Desenvolvido por **Felipe Batista** 👾

---
