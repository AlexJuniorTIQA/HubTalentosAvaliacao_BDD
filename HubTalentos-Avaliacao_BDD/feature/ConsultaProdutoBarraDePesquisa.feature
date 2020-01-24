#language: pt
Funcionalidade: Consultar Produto pela Barra de Pesquisa

Contexto:
Dado que estou na homepage do site
E clico na barra de pesquisa

@ConsultaNaBarraDePesquisaComSucesso
Cenário: Consulta na barra de pesquisa com sucesso
Quando pesquiso um produto válido no site
Então o site me retorna o produto pesquisado

@ConsultaNaBarraDePesquisaComFalha
Cenário: Consulta na barra de pesquisa com falha
Quando pesquiso um produto inválido no site
Então o site me retorna que o produto não foi encontrado

