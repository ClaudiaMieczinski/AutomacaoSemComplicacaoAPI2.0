# language: pt

   Funcionalidade: CRUD Filme

     @cadastroFilme
     Cenario: Cadastro Filme
       Dado que tenha realizado o login com dados validos
       E que tenha um payload valido da API de Filme
       Quando realizo uma requisicao do tipo POST de Filme
       Entao valido que recebo status 201 no response
       E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
       E armazeno o id que recebo do response de Filme



     



