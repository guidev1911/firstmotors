# FirstMotors API

A **FirstMotors** é uma API RESTful desenvolvida em **Java Spring** para gerenciar uma loja de carros. O sistema implementa um CRUD completo com persistência de dados, documentação interativa, testes automatizados, e suporte a múltiplos formatos de entrada e saída.

---

## 📚 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Web**
- **Flyway** (para migrations do banco de dados)
- **MySQL**
- **Swagger / OpenAPI** (documentação)
- **DozerMapper** (mapeamento de DTOs)
- **JUnit + Mockito** (testes unitários)
- **Docker + Docker Compose**

---

## ✅ Funcionalidades

- CRUD de veículos (Create, Read, Update, Delete)
- Respostas em **JSON**, **XML** ou **YML**
- Migrations automáticas com criação e **população inicial** do banco de dados
- Tratamento de exceções com mensagens customizadas
- Documentação interativa com Swagger UI
- Testes unitários com cobertura de lógica de negócio e serviço
- Projeto completamente **dockerizado**

---

## 📂 Formatos Suportados

A API aceita e responde em:
- `application/json`
- `application/xml`
- `application/x-yaml`

Basta definir os headers `Content-Type` e/ou `Accept` na requisição.

---

## 📌 Como Executar o Projeto

### Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

### Passos para execução

```bash
# 1. Subir os containers e construir a aplicação (é necessário docker estar em execussão)
docker-compose up --build
```

A aplicação estará disponível em:

```
http://localhost:8080
```

Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

---

## 📖 Exemplo de Endpoint

### 🔍 Buscar carro por ID

**GET** `/api/cars/v1/{id}`

**Exemplo de resposta (JSON):**

```json
{
  "id": 1,
  "brand": "Lamborghini",
  "model": "Aventador SVJ",
  "year": 2021,
  "power": 759,
  "price": 517000,
  "color": "Verde Alcantara",
  "units": 963,
  "speed": 350,
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/car/v1/1"
    }
  }
}
```

---

## 🧪 Testes

Os testes unitários são escritos com:

- **JUnit**
- **Mockito**

> ⚙️ Os testes são executados automaticamente durante o build da imagem Docker.

---

## 📄 Migrations

- Gerenciadas com **Flyway**
- Estrutura do banco de dados criada automaticamente
- População inicial de dados na primeira execução

---

## 🐳 Docker

O projeto é executado totalmente com Docker:

- Container da aplicação Spring Boot
- Container de banco de dados (MySQL)

Arquivos principais:

- `Dockerfile`
- `docker-compose.yml`

---

## 👨‍💻 Autor

Desenvolvido por **[Guilherme Brito Souza Santos]**
