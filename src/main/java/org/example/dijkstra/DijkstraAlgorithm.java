package org.example.dijkstra;

import java.util.Stack;

public class DijkstraAlgorithm {

    private int performOperation(int num1, int num2, char operation) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new IllegalArgumentException("Неверная операция");
        };
    }

    // Работает только если в скобках 2 числа и числа должны быть < 9, иначе надо адаптировать
    public int TwoStackDijkstraAlgorithm(String exp) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*' || exp.charAt(i) == '/')
                operations.push(exp.charAt(i));

            if (Character.isDigit(exp.charAt(i)))
                numbers.push(Character.getNumericValue(exp.charAt(i)));


            if (exp.charAt(i) == ')' && !operations.isEmpty())
                numbers.add(performOperation(numbers.pop(), numbers.pop(), operations.pop()));

        }

        return numbers.pop();
    }
}

class Solutions {
    public static void main(String[] args) {
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        String exp = "(1+((2 + 3 ) * ( 4 * 5 ) ) ))";
        int res = algorithm.TwoStackDijkstraAlgorithm(exp);
        System.out.println(res);
    }
}