#language: pt
Funcionalidade: Consultar Produto pela Tela Inicial

Contexto:
Dado que estou na pagina inicial do site


@ConsultaNaTelaInicialComSucesso
Cenário: Consulta na tela inicial com sucesso
Quando clico em um dos produtos
Então acesso a página do produto


@ConsultaNaTelaInicialComFalha
Cenário: Consulta na tela inicial com falha
Quando clico no item HP elitebook Folio
Então acesso a página de outro produto