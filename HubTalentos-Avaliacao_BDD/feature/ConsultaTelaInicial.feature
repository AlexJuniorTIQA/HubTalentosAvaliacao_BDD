#language: pt
Funcionalidade: Consultar Produto pela Tela Inicial

Contexto:
Dado que estou na pagina inicial do site


@ConsultaNaTelaInicialComSucesso
Cenário: Consulta na tela inicial com sucesso
Quando clico em um dos produtos
Então acesso á página do produto


@ConsultaNaTelaInicialComFalha
Cenário: Consulta na tela inicial com falha
Quando clico no item HP elitebook Folio
Então acesso á página de outro produto