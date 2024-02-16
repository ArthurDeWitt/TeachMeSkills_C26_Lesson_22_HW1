package by.tms.lesson22.hw.calcualtor.service;

import by.tms.lesson22.hw.calcualtor.console.ConsoleWriter;
import by.tms.lesson22.hw.calcualtor.model.Operation;

public class OperationService {

    public Operation calculate(Operation operation) {
        switch (operation.getOperation()) {
            case "SUM":
                operation.setResult(operation.getNum1() + operation.getNum2());
                break;
            case "SUB":
                operation.setResult(operation.getNum1() - operation.getNum2());
                break;
            case "MUL":
                operation.setResult(operation.getNum1() * operation.getNum2());
                break;
            case "SEP":
                operation.setResult(operation.getNum1() / operation.getNum2());
                break;
            default:
                throw new IllegalArgumentException("Wrong type of operation: " + operation.getOperation());
        }
        return operation;
    }
}

