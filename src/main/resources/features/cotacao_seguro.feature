#language: pt
#encoding: utf-8

@cadastro @regressivo
Funcionalidade: Cadastro

  Cenario: Realizar cadastro com sucesso no sistema
    Dado que eu acesso o site
    E preencher dados do veiculo
    E preencher dados do seguro
    E preencher dados do produto
    E selecionar opcao de precos
    Quando enviar a cotacao
    Então validar a mensagem "Sending e-mail success!" esta sendo exibida