package application.main;


import application.main.controllers.WebServerConfig;

public class Main {
    public static void main(String[] args) {
        WebServerConfig server = new WebServerConfig("src/application/resource/index.html", 8080);

        server.startServer();
        server.verifyFile();
        server.openBrowser();

    }
}