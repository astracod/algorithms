package org.example.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TryReduce {

    /**
     * Найдите сумму всех чисел в списке и выведите результат.
     */
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    static Integer sum = numbers.stream().reduce(0, Integer::sum);

    /**
     * Найдите произведение всех чисел в списке и выведите результат.
     */
    static List<Integer> multiplyingNumbers = Arrays.asList(1, 2, 3, 4);

    static Integer multi = multiplyingNumbers.stream().reduce(1, (x, y) -> x * y);

    /**
     * Найдите общую сумму транзакций и выведите результат
     */
    static class Transaction {
        double amount;

        Transaction(double amount) {
            this.amount = amount;
        }
    }

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(100.50),
            new Transaction(200.75),
            new Transaction(-50.25)
    );

    static Double result = transactions.stream()
            .map(transaction -> transaction.amount)
            .reduce((double) 0, Double::sum);

    static Double res2 = transactions.stream().mapToDouble(transaction -> transaction.amount).sum();
    static Double res3 = transactions.stream().collect(Collectors.summingDouble(transaction -> transaction.amount));

    public static void main(String[] args) {
//        System.out.println(sum);
//        System.out.println(res3);

    }
}
