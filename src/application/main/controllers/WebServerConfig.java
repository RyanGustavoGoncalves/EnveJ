package application.main.controllers;

import application.main.services.MyHandler;
import com.sun.net.httpserver.HttpServer;
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
