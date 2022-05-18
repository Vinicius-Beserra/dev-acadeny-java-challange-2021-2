# Desafio CM Dev Academy - Java

Fala, galera!!! 

Gostaríamos de agradecer sua presença no  **CM Dev Academy - Java**. Abaixo vamos explicar os detalhes do desafio proposto. 


## O que vamos avaliar? O que buscamos?

O principal objetivo do desafio é analisarmos como entende, modela, resolve o problema e testa, de maneira clara e objetiva, adotando boas práticas de programação. Seja criativo!! Seja ousado!!!!

Enviar uma aplicação funcionando é o ideal, mas mesmo que não esteja 100 % envie o código para que possamos analisar até onde você chegou.

O problema que vamos apresentar não tem uma lógica complexa, mas implemente seu código pensando em um sistema extensível e de alta concorrência no uso, é muito importante que você aplique SOLID em tudo que fizer.

Seja criativo!



## Tecnologias

1. Nossa stack de desenvolvimento é Java, então nossa sugestão é que você utilize Spring.

2. Teste seu código, crie Unit tests e/ou Integration tests.

3. A aplicação deve ser self contained, use um database em memória, por exemplo o H2.

## O Desafio

O desafio proposto é de construir uma API que terá dois endpoints:
  
### Endpoint – Nota Fiscal

  Sua aplicação deve expor em `http://localhost:{porta}/api/v1/notas-fiscais` uma API REST. (GET, POST, PUT, DELETE)

O conteúdo de um Nota Fiscal possui o seguinte payload:

```json
{
"id":"123456",
"nomeCliente":"JOSE FRANCISCO",
"endereco":"Rua A, 500",
"telefone":"8532795578",
"valorTotalProdutos":13.50,
"frete":2.50,
"valorTotal":16.00,
"itens": 
    [{
        "descricao": "Refri",
        "precoUnitario": 5.5,
        "quantidade": 1,
        "valorTotal": 5.5
   },
   {
        "descricao": "Coxinha",
        "precoUnitario": 3.00,
        "quantidade": 1,
        "valorTotal": 3.00
   },
   {
        "descricao": "Batatinha",
        "precoUnitario": 5.00,
        "quantidade": 1,
        "valorTotal": 5.50
   }]
}
```

O conteúdo dessa Nota Fiscal e seus Itens deverão ser persistidos em banco de dados. Fique à vontade para criar as validações que você considerar necessárias.

O Nota Fiscal poderá ter os seguintes status:

 - PENDENTE
 - EM_PROCESSAMENTO
 - APROVADA
 - COM_ERRO
 - CANCELADA

### Regra de Negócio

- Todo nova nota fiscal terá que ter o status inicial **PENDENTE**;
- O **valor total** do Item deve ser multiplicação do **preco unitário** pela **quantidade**;
-  O **valor total dos produtos** na Nota Fiscal deve ser o somátorios **valor total** dos Itens;
-  O **valor total** da Nota Fiscal deve ser a soma do **valor total dos produtos** e  **frete**.


O endpoint não deve permitir:

 - Nota Fiscal sem item;
 - Item sem quantidade;
 - Item sem valor;
 - Item sem nome.
 
### Endpoint – Mudança de Status de Nota Fiscal

Sua aplicação deve receber um PATCH em `http://localhost:{porta}/api/v1/notas-fiscais/{id}/status` com o seguinte payload, onde {id} contido no path será o código da nota e body o status que a nota irá receber:

```json
{
"status": "PENDENTE"
}
```  

A função desse endpoint é alterar o status da Nota Fiscal a medida em que ele for passando pelo seu ciclo de vida

#### Regras de STATUS para os Endpoints:

 - **Não permitir** alterar o status para CANCELADO caso o status atual seja EM_PROCESSAMENTO ou CANCELADO;
 - **Permitir** alterar o status para EM_PROCESSAMENTO caso o status atual seja PENDENTE ou COM_ERRO;
 - **Permitir** alterar o status para APROVADA caso o status atual seja EM_PROCESSAMENTO.

Para cada ação de sucesso de alteração do status a API deve de retornar a seguinte resposta:

```log
 HTTP 200 OK
```

Em caso de alguma regra de negócio não antendida, API deve de retornar a seguinte resposta:
```log
HTTP 422 - Unprocessable Entity
```
```
{
"mesagem": "status não pode ser alterado...."
}
```


#### Informações finais

Uma tentativa de mudança de status deverá passar por todas essas regras descritas e a API deverá retornar todos os status gerados, observe que as validações são compartilhadas entre as regras, reutilize código.

## Entrega
- É **obrigatório** fazer o fork do projeto.
- Todos os commits realizados após o final do prazo (às 23:59 do dia 03 de outubro de 2021) não serão considerados.
- No arquivo chamado `step-by-step.md` descreva todo o processo que é preciso para executar sua aplicação.
- O projeto deverá possuir a documentação SWAGGER da API.
