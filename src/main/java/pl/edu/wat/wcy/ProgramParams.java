package pl.edu.wat.wcy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProgramParams {

    private Map<String, Integer> operators;

    private Map<String, Integer> operands;

    public ProgramParams() {
        operators = new HashMap<>();
        operands = new HashMap<>();
    }

    public void addOperator(String key) {
        operators.merge(key, 1, Integer::sum);
    }

    public void addOperand(String key) {
        operands.merge(key, 1, Integer::sum);
    }

    public int getDistinctOperators() {
        return operators.size();
    }

    public int getDistinctOperands() {
        return operands.size();
    }

    public int getTotalOperators() {
        int totalOperators = 0;
        for (Map.Entry<String, Integer> entry : operators.entrySet()) {
            totalOperators += entry.getValue();
        }
        return totalOperators;
    }

    public int getTotalOperands() {
        int totalOperands = 0;
        for (Map.Entry<String, Integer> entry : operands.entrySet()) {
            totalOperands += entry.getValue();
        }
        return totalOperands;
    }

    public void print() {
        System.out.println("Distinct operators: " + getDistinctOperators());
        System.out.println("Total operators: " + getTotalOperators());
        printSortedMap(operators);
        System.out.println("Distinct operands: " + getDistinctOperands());
        System.out.println("Total operands: " + getTotalOperands());
        printSortedMap(operands);

    }

    private void printSortedMap(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

}
