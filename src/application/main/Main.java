package application.main;

import application.main.controllers.WebOpenFunc;

public class Main {
    public static void main(String[] args) {

        WebOpenFunc server = new WebOpenFunc("src/application/resource/index.html", 8080);

        server.startServer();
    }
}