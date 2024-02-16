package by.tms.lesson22.hw.calcualtor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Operation {
    private final double num1;
    private final double num2;
    private final String operation;
    private double result;
}

