class WebSocketClient {
    constructor(url) {
        this.url = url;
        this.websocket = null;
    }

    connect() {
        this.websocket = new WebSocket(this.url);

        this.websocket.onopen = () => {
            console.log("Conexão WebSocket estabelecida.");
        };

        this.websocket.onmessage = (event) => {
            console.log("Mensagem recebida:", event.data);
            // Lógica para lidar com a mensagem recebida do servidor
        };

        this.websocket.onclose = () => {
            console.log("Conexão WebSocket fechada.");
        };

        this.websocket.onerror = (error) => {
            console.error("Erro na conexão WebSocket:", error);
        };
    }

    send(message) {
        if (this.websocket.readyState === WebSocket.OPEN) {
            this.websocket.send(message);
        } else {
            console.error("A conexão WebSocket não está aberta.");
        }
    }

    disconnect() {
        if (this.websocket.readyState === WebSocket.OPEN) {
            this.websocket.close();
        }
    }
}

// Exemplo de uso:
const websocketClient = new WebSocketClient("ws://localhost:8080/socket");
websocketClient.connect();

// Enviar uma mensagem
websocketClient.send("Olá, servidor!");

// Desconectar
websocketClient.disconnect();
