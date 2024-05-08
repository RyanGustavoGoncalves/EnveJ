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
            Runtime.getRuntime()
                    .exec("rundll32 url.dll,FileProtocolHandler http://localhost:" + webPort + "/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verifyFile() {
        if (mainFile == null || mainFile.isEmpty()) {
            return;
        }

        File file = new File(mainFile);

        if (!file.exists()) {
            try {
                file.createNewFile();

                FileWriter writer = new FileWriter(file);
                writer.write("<!DOCTYPE html>\n");
                writer.write("<html lang=\"en\">\n");
                writer.write("<head>\n");
                writer.write("    <meta charset=\"UTF-8\">\n");
                writer.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
                writer.write("    <title>EnveJ</title>\n");
                writer.write("    <style>\n");
                writer.write("        body {\n");
                writer.write("            font-family: Arial, sans-serif;\n");
                writer.write("            margin: 0;\n");
                writer.write("            padding: 0;\n");
                writer.write("            box-sizing: border-box;\n");
                writer.write("            background-color: #222;\n");
                writer.write("            color: #fff;\n");
                writer.write("        }\n");
                writer.write("        header {\n");
                writer.write("            background-color: #333;\n");
                writer.write("            color: #fff;\n");
                writer.write("            padding: 10px 0;\n");
                writer.write("            text-align: center;\n");
                writer.write("        }\n");
                writer.write("        .container {\n");
                writer.write("            max-width: 800px;\n");
                writer.write("            margin: 20px auto;\n");
                writer.write("            padding: 0 20px;\n");
                writer.write("        }\n");
                writer.write("        .card {\n");
                writer.write("            background-color: #333;\n");
                writer.write("            padding: 20px;\n");
                writer.write("            margin-bottom: 20px;\n");
                writer.write("            border-radius: 5px;\n");
                writer.write("        }\n");
                writer.write("        .card h3 {\n");
                writer.write("            color: #fff;\n");
                writer.write("            font-size: 24px;\n");
                writer.write("            margin-bottom: 10px;\n");
                writer.write("        }\n");
                writer.write("        .card p {\n");
                writer.write("            color: #ccc;\n");
                writer.write("            font-size: 16px;\n");
                writer.write("        }\n");
                writer.write("    </style>\n");
                writer.write("</head>\n");
                writer.write("<body>\n");
                writer.write("    <header>\n");
                writer.write("        <h1>EnveJ</h1>\n");
                writer.write("    </header>\n");
                writer.write("    <div class=\"container\">\n");
                writer.write("        <h2>Bem-vindo ao EnveJ!</h2>\n");
                writer.write("        <p>Este é um template básico para começar a construir sua aplicação web em Java.</p>\n");
                writer.write("        <div class=\"card\">\n");
                writer.write("            <h3>Tecnologia 1</h3>\n");
                writer.write("            <p>Descrição da Tecnologia 1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum nec mi quis sapien ultricies porta.</p>\n");
                writer.write("        </div>\n");
                writer.write("        <div class=\"card\">\n");
                writer.write("            <h3>Tecnologia 2</h3>\n");
                writer.write("            <p>Descrição da Tecnologia 2 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum nec mi quis sapien ultricies porta.</p>\n");
                writer.write("        </div>\n");
                writer.write("        <div class=\"card\">\n");
                writer.write("            <h3>Tecnologia 3</h3>\n");
                writer.write("            <p>Descrição da Tecnologia 3 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum nec mi quis sapien ultricies porta.</p>\n");
                writer.write("        </div>\n");
                writer.write("    </div>\n");
                writer.write("</body>\n");
                writer.write("</html>\n");

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
