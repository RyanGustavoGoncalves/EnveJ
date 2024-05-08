package com.goncalves.api.enveJ.infra.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketHandler() {
                    @Override
                    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                        System.out.println("Conexão estabelecida: " + session.getId());
                    }

                    @Override
                    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
                        System.out.println("Mensagem recebida: " + message.getPayload());
                        // Aqui você pode adicionar lógica para processar a mensagem recebida
                    }

                    @Override
                    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
                        System.err.println("Erro de transporte para a sessão: " + session.getId());
                        exception.printStackTrace();
                    }

                    @Override
                    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
                        System.out.println("Conexão fechada: " + session.getId() + ", Status: " + closeStatus);
                    }

                    @Override
                    public boolean supportsPartialMessages() {
                        return false;
                    }
                }, "/socket")
                .setAllowedOrigins("*");
    }
}

