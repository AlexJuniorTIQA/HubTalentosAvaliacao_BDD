#language: pt
Funcionalidade: Cadastro de Usuario
	Contexto:
		Dado que eu estou na home do site
    Quando clico no icone de login e em nova conta
    E preencho todos os dados
    E clico no botão registar
    
@CadastroComSucesso   
  Cenário: Cadastro com Sucesso
    Então  consigo criar o meu usuário
    
 @CadastroComFalha   
  Cenário: Cadastro com Falha
    Então  não consigo criar meu usuario, pois já há um existente

