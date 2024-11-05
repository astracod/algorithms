package org.example.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TryFilter {
    /**
     * Отфильтруйте четные числа из списка и выведите их.
     */
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    static List<Integer> evenNumbers = numbers.stream()
            .filter(number -> number % 2 == 0)
            .collect(Collectors.toList());
    /**
     * Отфильтруйте строки, содержащие букву 'a', и выведите их.
     */
    static List<String> strings = Arrays.asList("Apple", "banana", "cherry", "date");
    static List<String> isLetterA = strings.stream()
            .filter(word -> word.toLowerCase().contains("a"))
            .collect(Collectors.toList());

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * Отфильтруйте людей старше 30 лет и выведите их имена.
     */
    static List<Person> people = Arrays.asList(
            new Person("Alice", 28),
            new Person("Bob", 35),
            new Person("Charlie", 30),
            new Person("David", 40)
    );

    static List<String> overThirty = people.stream()
            .filter(person -> person.age > 30)
            .map(person -> person.name)
            .collect(Collectors.toList());

    public static void main(String[] args) {
//        evenNumbers.forEach(System.out::println);
//        isLetterA.forEach(System.out::println);
        overThirty.forEach(System.out::println);
    }
}
