package by.tms.lesson22.hw.calcualtor.console;

import by.tms.lesson22.hw.calcualtor.model.Operation;
import by.tms.lesson22.hw.calcualtor.service.OperationService;

public class ConsoleApplication {
    private final OperationService operationService = new OperationService();
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleReader reader = new ConsoleReader();

    public void run() {
        while (true) {
            writer.writer("Do you want to start yes/no ?");
            String start = reader.readOperationType();
            if (start.equals("no")) {
                break;
            }
            writer.writer("Enter first num");
            double num1 = reader.readNum();
            writer.writer("Enter second num");
            double num2 = reader.readNum();
            writer.writer("Enter type of operation");
            String type = reader.readOperationType();
            Operation operation = new Operation(num1, num2, type);
            Operation result = operationService.calculate(operation);
            writer.writer("Result: " + result);
            writer.writer("Do you want to continue yes/no ?");
            String continueInput = reader.readOperationType();
            if (continueInput.equals("no")) {
                break;
            }
        }
    }
}