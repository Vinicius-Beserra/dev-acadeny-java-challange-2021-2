# CM Dev Academy - Java - Projeto Notas Fiscais

Guia inicial da aplicação:

A aplicação tem como base geral a implementação de dados em um crud referente a um corpo de nota fiscal.
Nela podemos inserir, gravar, deletar e buscar informações de um corpo de nota fiscal.
Para que possa acessá-la, basta colocar a seguinte url:

- localhost:{porta}/api/v1/Notas-Fiscais

Para realizar as consultas, é de preferencia, utilizar o app Postman

# Procedimentos para executar o app.

1 - Buscar toda a lista:
Acessar o link - localhost:{porta}/api/v1/Notas-Fiscais.

2 - Inserir um novo Registro:
Utilizando o app Postman, selecione o método (Post) e depois, selecione opção Body e clique no select Raw.
Logo após, digite o corpo com as informações a serem inseridas, exeto o campo id.
Clique no botao Enviar(Send).
Para teste, selecione o método (Get) para listar todos os registros.

3 - Para Alterar um Registro.
Acessar o link - localhost:{porta}/api/v1/Notas-Fiscais/{id que necessita alterar}
Utilizando o app Postman, selecione o método (Put) e depois, selecione opção Body e clique no select Raw.
Logo após, digite o corpo com as informações a serem inseridas, incluindo o id.
Clique no botao Enviar(Send).
Para teste, selecione o método (Get) para listar todos os registros.

4 - Para Deletar um Registro.
Acessar o link - localhost:{porta}/api/v1/Notas-Fiscais/{id que necessita deletar}
Utilizando o app Postman, selecione o método (Delete).
Clique no botao Enviar(Send).
Para teste, selecione o método (Get) para listar todos os registros.

# link para documentação Swagger

http://localhost:{id da porta utilizada}/swagger-ui/index.html?configUrl=/api-docs/swagger-config#/
