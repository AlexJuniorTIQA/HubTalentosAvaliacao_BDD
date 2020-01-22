#language: pt
Funcionalidade: Cadastro de Usuario
	Contexto:
		
    
@CadastroComSucesso   
  Cenário: Cadastro com Sucesso  
  	Dado que eu estou na home do site
    Quando clico no icone de login e em nova conta
    E preencho todos os dados
    E clico no botão registar
    Então eu consigo criar o meu usuário
    
 @CadastroComFalha   
  Cenário: Cadastro com Falha  
 		 Dado que eu estou na home do site
    Quando clico no icone de login e em nova conta
    E preencho todos os dados
    E clico no botão registar
    Então eu não consigo criar meu usuario pois já há um existente

