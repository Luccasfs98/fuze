Aplicativo para consultas de partidas de CSGO


A aplicação segue a arquitetura MVVM somada a conceitos do SOLID. 
Também utiliza as principais bibliotecas do Jetpack, que é a recomendação da Google para aplicativos sustentáveis e escaláveis. 

O projeto é modularizado, onde o módulo app somente tem a responsabilidade de inicializar a aplicação, na MainActivity também foi utilizada a nova splash screen nativa do Android, porém somente para o Android 12 ou superior. 

Módulos:
	Core: Responsável por fornecer recursos essenciais para o funcionamento do app, como configurações de injeção de dependência e de requisições para api.
	Comom: Auxilia no fornecimento de classes utilitárias de comum acesso.
	UI: Modulo responsável pela componentização dos layouts  cujo objetivo seria a reutilização de código e fácil manutenção.
	matches: Módulo da funcionalidade, separado por pacotes, data, di, presentation e Domain. Com o objetivo de separar responsabilidades por camadas, seguindo o princípio de responsabilidade única e também facilitando nos futuros testes unitários e integrados.
	
