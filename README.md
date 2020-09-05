# lp2-projeto
Trabalho requisitado pelo professor Gabriel Baptista, na linguagem Java

## Utilizando a interface console :computer:


## Rodando a API localmente :book:

Para rodar a API localmente em `localhost:8080`

- Windows
  
  No diretório raíz do projeto api `cd api` e execute no terminal: `mvnw spring-boot:run`

- Linux/Mac
  
  No diretório raíz do projeto `cd api` e execute no terminal: `./mvnw spring-boot:run`
  
## API Docs :scroll:

### Resumo

  | Recurso       | Método                | Descrição                                                        |
  | ------------- | ----------------------| -----------------------------------------------------------------|
  | /produtos     | POST GET PATCH DELETE |  CRUD de um produto
  
### Produto
  
<details>
  <summary>Listar</summary>

  ### Retorna todos os produtos cadastrados no `estoque` 

  **URL**

    /produtos

  **Método**

   `GET`

  * **Exemplo de chamada:**

      ```shell
          curl -H "Content-type:application/json" \
          http://localhost:8080/produtos
      ```

  * **Success Response:**

    * **Code:** 200 <br />
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
  * **Error Response:**

  * **Code:** `400 Bad Request`   <br />
</details>

<details>
  <summary>Cadastrar</summary>

  ### Cadastra um produto no `estoque` 

  **URL**

    /produtos

  **Método**

   `POST`

  * **Exemplo de chamada:**

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

  * **Success Response:**

    * **Code:** 201 <br />

  * **Error Response:**

  * **Code:** `400 Bad Request`   <br />
</details>
