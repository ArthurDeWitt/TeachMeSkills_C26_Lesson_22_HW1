package by.tms.lesson22.hw.calcualtor.web;

import by.tms.lesson22.hw.calcualtor.Application;
import by.tms.lesson22.hw.calcualtor.service.OperationService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebApplication implements Application {

    @Override
    public void run() {
        HttpServer httpServer = null;
        try {
            httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), 1);
            httpServer.createContext("/calculate", new OperationHttpHandler());
            httpServer.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}