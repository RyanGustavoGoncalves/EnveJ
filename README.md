**Projeto EnveJ com Spring usando WebSocket** 🌐🚀

Este projeto exemplifica a configuração e utilização do WebSocket no Spring Boot para comunicação em tempo real entre cliente e servidor. O WebSocket é uma tecnologia que permite a comunicação bidirecional e em tempo real entre um cliente (navegador da web, por exemplo) e um servidor.

### Funcionalidades

- Estabelecimento de uma conexão WebSocket entre cliente e servidor.
- Envio de mensagens do cliente para o servidor e vice-versa.
- Tratamento de eventos de abertura, fechamento e erro da conexão WebSocket.

### Pré-requisitos

- Java Development Kit (JDK) instalado.
- Maven instalado.
- IDE (recomendado: IntelliJ IDEA, Eclipse, VSCode).
- Navegador web compatível com WebSocket (Chrome, Firefox, etc.).

### Como executar

1. Clone o repositório do projeto.

```
git clone https://github.com/RyanGustavoGoncalves/EnveJ.git
```

2. Importe o projeto na sua IDE de escolha.
3. Execute o projeto Spring Boot.
4. Abra um navegador web e acesse a aplicação em `http://localhost:8080`.

### Como usar

- Na página inicial, você verá uma interface simples.
- Abra o console do navegador para ver as mensagens WebSocket.
- Digite uma mensagem no campo de entrada e pressione Enter para enviá-la para o servidor.
- O servidor irá responder automaticamente com uma mensagem de confirmação.

### Estrutura do Projeto

- **WebSocketConfig.java**: Classe de configuração do WebSocket.
- **WebSocketHandler.java**: Manipulador de WebSocket para lidar com eventos de conexão e mensagens.
- **index.html**: Página HTML para interface de usuário.
- **scripts/main.js**: Script JavaScript para interação com o WebSocket.
- **pom.xml**: Arquivo de configuração do Maven.

### Tecnologias Utilizadas

- Spring Boot
- WebSocket
- HTML
- JavaScript

### Contribuindo

Sinta-se à vontade para contribuir com novas funcionalidades, correções de bugs ou melhorias. Basta abrir uma issue ou enviar um pull request.

### Licença

Este projeto é licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

### Contato

Para mais informações, entre em contato pelo e-mail: ryan.ggoncalves@gmail.com.
