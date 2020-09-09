# LP2-Projeto

Trabalho requisitado pelo professor Gabriel Baptista, na linguagem Java.

**Informaçes sobre o projeto**:

- Versão do Java: `1.8`
- Gerenciador de pacotes: `Maven`
- Ambiente de desenvolvimento: `NetBeans v12.0`

## Rodando a API localmente :book:

Para rodar a API localmente em **`localhost:8080`**

- Windows

  No diretório raíz do projeto `cd api` e execute : `mvnw spring-boot:run`

- Linux/Mac

  No diretório raíz do projeto `cd api` e execute : `./mvnw spring-boot:run`

## Console Docs :scroll:

Para utilizar o console, primeiro é necessario subir a API localmente utilizando o comando "mvnw spring-boot:run" na pasta raiz da API, depois faça o build da aplicação utilizando a classe frontend.java como classe Main e selecione uma das opções do Menu.

As opções de exclusão e edição só funcionarão se ja existir um produto cadastrado.

## API Docs :scroll:

### Resumo

| Recurso     | Método                        | Descrição                                |
| ----------- | ----------------------------- | ---------------------------------------- |
| `/produtos` | `POST` `GET` `PATCH` `DELETE` | Recurso responsável pelo CRUD do produto |

### Produto

<details>
  <summary>Listar</summary>

### Retorna todos os produtos cadastrados no estoque

**URL**

    /produtos

**Método**

`GET`

- **Exemplo de chamada:**

  ```shell
      curl http://localhost:8080/produtos
  ```

- **Success Response:**

  - **Code:** 200 <br />
    **Body:**

    ```json
        [{
            "id": "123e4567-e89b-12d3-a456-556642440000",
            "categoria":"test",
            "marca": "marca",
            "tamanho": "M",
            "descricao": "description",
            "cor":"Laranja",
            "valorPago": 232.2,
            "valorEtiqueta": 233.2,
            "valorSugerido": 233.2,
            "localCompra": "Estados test",
            "dataEntrega": 2020-09-05T22:33:07
        },...]
    ```

- **Error Response:**

- **Code:** `400 Bad Request` <br />
</details>

<details>
  <summary>Cadastrar</summary>

### Cadastra um produto no estoque

**URL**

    /produtos

**Método**

`POST`

- **Exemplo de chamada:**

  **Body:**

  ```json
      {
          "categoria":"test",
          "marca": "marca",
          "tamanho": "M",
          "descricao": "description",
          "cor":"Laranja",
          "valorPago": 232.2,
          "valorEtiqueta": 233.2,
          "valorSugerido": 233.2,
          "localCompra": "Estados test",
          "dataEntrega": 23/04/1994 23:00:01
      }
  ```

- **Success Response:**

  - **Code:** 201 <br />

- **Error Response:**

- **Code:** `400 Bad Request` <br />
</details>

<details>
  <summary>Pesquisar</summary>

### Pesquisa um produto no estoque

**URL**

    /produtos/[id]

**Método**

`GET`

- **Exemplo de chamada:**

  ```shell
        curl http://localhost:8080/produtos/1234-abc
  ```

- **Success Response:**

  **Body:**

  ```json
      {
          "categoria":"test",
          "marca": "marca",
          "tamanho": "M",
          "descricao": "description",
          "cor":"Laranja",
          "valorPago": 232.2,
          "valorEtiqueta": 233.2,
          "valorSugerido": 233.2,
          "localCompra": "Estados test",
          "dataEntrega": 23/04/1994 23:00:01
      }
  ```

  - **Code:** 204 <br />

- **Error Response:**

- **Code:** `404 Not Found` <br />
</details>

<details>
  <summary>Deletar</summary>

### Deleta um produto do estoque

**URL**

    /produtos/[id]

**Método**

`DELETE`

- **Exemplo de chamada:**

  ```shell
        curl http://localhost:8080/produtos/1234-abc
  ```

- **Success Response:**

  - **Code:** 204 <br />

- **Error Response:**

- **Code:** `404 Not Found` <br />
</details>

<details>
  <summary>Editar</summary>

### Edita um produto do estoque

**URL**

    /produtos/[id]

**Método**

`PATCH`

- **Exemplo de chamada:**
  ```shell
          curl -H "Content-type:application/json" \
               http://localhost:8080/produtos/ae123-123ase \
               -d '{ "categoria": "Novo Campo", "marca": "Nova Marca" }'
  ```
- **Success Response:**

  - **Code:** 204 <br />

- **Error Response:**

- **Code:** `404 Not Found` <br />
</details>

## Console Docs :scroll:

Para utilizar o console, primeiro é necessario subir a API localmente utilizando o comando "mvnw spring-boot:run" na pasta raiz da API, depois faça o build da aplicação utilizando a classe frontend.java como classe Main e selecione uma das opções do Menu.

As opções de exclusão e edição só funcionarão se ja existir um produto previamente cadastrado .
