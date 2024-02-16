package by.tms.lesson22.hw.calcualtor.storage;

import by.tms.lesson22.hw.calcualtor.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage {
    private final List<Operation> operationList = new ArrayList<>();
    public void save(Operation operation){
        operationList.add(operation);
    }
    public List<Operation> findAll() {
        return new ArrayList<>(operationList);
    }
}
