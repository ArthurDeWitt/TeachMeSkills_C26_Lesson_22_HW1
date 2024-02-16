package by.tms.lesson22.hw.calcualtor.web;

import by.tms.lesson22.hw.calcualtor.model.Operation;
import by.tms.lesson22.hw.calcualtor.service.OperationService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class OperationHttpHandler implements HttpHandler {
    private final OperationService operationService = new OperationService();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Map<String, String> mapResult = new HashMap<>();
        URI requestUri = exchange.getRequestURI();
        String query = requestUri.getQuery();
        if (query != null) {
            String[] parameters = query.split("&");
            for (String string : parameters) {
                String[] pair = string.split("=");
                mapResult.put(pair[0], pair[1]);
            }
        }
        double num1 = Double.parseDouble(mapResult.get("num1"));
        double num2 = Double.parseDouble(mapResult.get("num2"));
        String type = mapResult.get("type");
        Operation operation = new Operation(num1, num2, type);
        operationService.calculate(operation);
        String result = "result = " + operation.getResult();

        exchange.sendResponseHeaders(200, result.length());
        PrintWriter printWriter = new PrintWriter(exchange.getResponseBody());
        printWriter.print(result);
        printWriter.flush();
    }
}