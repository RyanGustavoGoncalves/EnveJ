package application.main.services;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyHandler implements HttpHandler {

    private String mainFile;

    public MyHandler(String mainFile) {
        this.mainFile = mainFile;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Obtém o caminho do arquivo solicitado
        String requestedFile = exchange.getRequestURI().getPath();

        // Obtém o arquivo correspondente ao caminho solicitado
        File file = new File(mainFile + requestedFile);

        // Verifica se o arquivo existe
        if (file.exists() && !file.isDirectory()) {
            // Define o tipo de conteúdo da resposta
            String contentType;
            if (requestedFile.endsWith(".js")) {
                contentType = "text/javascript";
            } else {
                contentType = Files.probeContentType(Paths.get(file.getPath()));
            }
            exchange.getResponseHeaders().set("Content-Type", contentType);

            // Define o código de status da resposta como 200 (OK)
            exchange.sendResponseHeaders(200, file.length());

            // Obtém o fluxo de saída para escrever a resposta
            OutputStream os = exchange.getResponseBody();

            // Escreve o conteúdo do arquivo na resposta
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            // Fecha os fluxos
            fis.close();
            os.close();
        } else {
            // Se o arquivo não existir, retorna um código de status 404 (Not Found)
            String response = "Arquivo não encontrado";
            exchange.sendResponseHeaders(404, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
