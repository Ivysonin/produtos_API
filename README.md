# API de Produtos

API simples para gerenciar produtos, desenvolvida em Java 21 com Spring Boot, usando MySQL como banco de dados.

## 🚀 Tecnologias utilizadas

-   Java 21
    
-   Spring Boot 4
    
-   Maven
    
-   Spring Data JPA
    
-   Lombok
    
-   MySQL
    
-   YAML para configuração
    

## 📦 Estrutura do projeto

```markdown
src/main/java/com/example/curso/
├── controllers/
├── dtos/
├── models/
├── repositorys/
└── services/impl/

```

## ⚡ Como rodar o projeto

1.  Clone o repositório:
    

```bash
git clone https://github.com/Ivysonin/produtos_API.git

```

2.  Entre no diretório do projeto:
    

```bash
cd produtos_API

```

3.  Execute com Maven:
    

```bash
mvn spring-boot:run

```

4.  Acesse a API pelo Postman:
    

-   GET `/produtos`
    
-   POST `/produtos`
    
-   PUT `/produtos/{id}`
    
-   PATCH `/produtos/{id}/status?ativo=true`
    
-   DELETE `/produtos/{id}`
    

## 📌 Endpoints disponíveis

| Método | URL                    | Descrição                    |
| ------ | ------------           | ----------------------       |
| POST   | /produtos              | Criar um novo produto        |
| GET    | /produtos              | Listar todos os produtos     |
| GET    | /produtos/{id}         | Buscar produto por ID        |
| PUT    | /produtos/{id}         | Atualizar um produto         |
| PATCH  | /produtos/{id}/status  | Ativar/Desativar um produto  |
| DELETE | /produtos/{id}         | Deletar um produto           |


## 🧪 Testando no Postman

### 1. Criar um novo produto

-   Método: POST
    
-   URL: `http://localhost:8080/produtos`
    
-   Body (JSON):
    

```json
{
  "nome": "Notebook Gamer",
  "descricao": "Notebook RTX 4060",
  "preco": 5999.90
}

```

### 2. Listar todos os produtos

-   Método: GET
    
-   URL: `http://localhost:8080/produtos`
    

### 3. Buscar por ID

-   Método: GET
    
-   URL: `http://localhost:8080/produtos/1`
    

### 4. Atualizar produto

-   Método: PUT
    
-   URL: `http://localhost:8080/produtos/1`
    
-   Body (JSON):
    

```json
{
  "nome": "Notebook Gamer",
  "descricao": "Notebook RTX 4070",
  "preco": 6999.90
}

```

### 5. Alterar status (Ativar/Desativar)

-   Método: PATCH
    
-   URL: `http://localhost:8080/produtos/1/status?ativo=false`
    

### 6. Deletar produto

-   Método: DELETE
    
-   URL: `http://localhost:8080/produtos/1`
    

## 🔧 Observações

-   Essa API foi desenvolvida como atividade do curso TI Criativa Full-Stack.  
    Repositório da trilha: https://github.com/Ivysonin/Trilha_TI-Criativa_Full-Stack
