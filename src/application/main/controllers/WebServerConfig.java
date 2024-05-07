package application.main.controllers;

import application.main.services.MyHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServerConfig {

    private String mainFile;
    private int webPort;

    public WebServerConfig(String mainFile, int webPort) {
        this.mainFile = mainFile;
        this.webPort = webPort;
    }

    public void startServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(webPort), 0);

            server.createContext("/", new MyHandler(mainFile));

            server.start();

            System.out.println("Servidor iniciado na porta " + webPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openBrowser() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://localhost:" + webPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verifyFile() {
        if (mainFile == null || mainFile.isEmpty()) {
            return; // Não há arquivo especificado
        }

        File file = new File(mainFile);

        if (!file.exists()) {
            try {
                // Cria um novo arquivo se ele não existir
                file.createNewFile();

                // Escreve o conteúdo no arquivo
                FileWriter writer = new FileWriter(file);
                writer.write("<!DOCTYPE html>\n");
                writer.write("<html lang=\"en\">\n");
                writer.write("<head>\n");
                writer.write("    <meta charset=\"UTF-8\">\n");
                writer.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
                writer.write("    <title>EnveJ</title>\n");
                writer.write("</head>\n");
                writer.write("<body>\n");
                writer.write("<h2>Isso é um teste</h2>\n");
                writer.write("</body>\n");
                writer.write("</html>\n");

                // Fecha o FileWriter
                writer.close();

                System.out.println("Arquivo criado: " + mainFile);
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }


    public String getMainFile() {
        return mainFile;
    }

    public void setMainFile(String mainFile) {
        this.mainFile = mainFile;
    }

    public int getWebPort() {
        return webPort;
    }

    public void setWebPort(int webPort) {
        this.webPort = webPort;
    }
}
