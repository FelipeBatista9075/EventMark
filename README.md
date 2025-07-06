
# EventMark

EventMark é uma aplicação Java para **criação e gerenciamento de eventos**, construída seguindo os princípios da **Arquitetura Limpa (Clean Architecture)**, com deploy configurado para servidores Linux via GitHub Actions.

## ✨ Funcionalidades

- Cadastro de eventos com:
  - Nome, descrição, data e hora de início/fim
  - Local, capacidade, organizador
  - Tipo de evento
- Identificador único para cada evento
- Separação clara entre regras de negócio e infraestrutura
- Pronta para integração com APIs, bancos de dados e UIs

## 🏛️ Arquitetura

A estrutura segue os princípios da **Arquitetura Limpa**, com separação em camadas bem definidas:

```

src/
└── main/
└── java/dev/batist/EventMark/
├── core/
│   ├── entities/        # Entidades do domínio (ex: Evento)
│   ├── gateway/         # Interfaces para acesso externo (ex: persistência, API)
│   └── usecase/         # Casos de uso (regras de negócio)
└── infrastructure/
├── config/          # Configurações do Spring Boot
├── controller/      # Camada de entrada (ex: REST API)
├── dtos/            # Objetos de transferência de dados
├── exceptions/      # Exceções da aplicação
├── gateway/         # Implementações das interfaces do core
├── persistence/     # Entidades JPA, mapeamentos e adaptadores
├── repository/      # Repositórios Spring Data
└── Mapper/          # Mapeamento entre entidades e DTOs

````

### 📦 Entidade principal

```
public record Evento(
    Long id,
    String nome,
    String descricao,
    LocalDateTime inicio,
    LocalDateTime fim,
    String identificador,
    String organizador,
    String local,
    Integer capacidade,
    Tipo tipoEvento
) {}
````

---

## 🚀 Deploy

O deploy é realizado via **GitHub Actions** para uma instância EC2 da AWS.

### Exemplo de etapa de deploy:

```
yaml
- name: Deploy to EC2
  run: |
    scp -o StrictHostKeyChecking=no -i ~/.ssh/id_rsa target/eventmark-*.jar ec2-user@${{ secrets.EC2_HOST }}:/app/eventmark.jar
    ssh -o StrictHostKeyChecking=no -i ~/.ssh/id_rsa ec2-user@${{ secrets.EC2_HOST }} "sudo systemctl restart eventmark-service"
```

## 🔧 Tecnologias

* Java 17
* Spring Boot
* Maven
* GitHub Actions
* AWS EC2
* Arquitetura Limpa
* 
