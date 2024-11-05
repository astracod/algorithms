package org.example.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TryMap {
    /**
     * Преобразуйте список целых чисел в список их квадратов и выведите результат.
     */
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
    static List<Integer> squaresOfValues = numbers.stream()
            .map(number -> number * number)
            .collect(Collectors.toList());

    /**
     * Преобразуйте список строк в список их длин и выведите результат.
     */
    static List<String> strings = Arrays.asList("apple", "banana", "cherry");
    static List<Integer> wordLengths = strings.stream()
            .map(String::length)
            .collect(Collectors.toList());

    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    /**
     * Преобразуйте объекты Product в строки формата "название: цена" и выведите результат.
     */
    static List<Product> products = Arrays.asList(
            new Product("Laptop", 999.99),
            new Product("Smartphone", 499.99),
            new Product("Tablet", 299.99)
    );

    static List<String> formatProduct = products.stream()
            .map(product -> String.format("%s : %.2f", product.name, product.price))
            .collect(Collectors.toList());

    public static void main(String[] args) {
        // squaresOfValues.forEach(System.out::println);
       // wordLengths.forEach(System.out::println);
        formatProduct.forEach(System.out::println);
    }
}
