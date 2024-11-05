package org.example.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TryCollect {

    /**
     * Соберите все числа в массив и выведите его
     */
    static List<Integer> numbers = Arrays.asList(1, 2, 3);

    static Integer[] array = numbers.stream().toArray(Integer[]::new);

    /**
     * Соберите уникальные строки в Set и выведите его.
     */
    static List<String> strings = Arrays.asList("apple", "banana", "apple", "cherry");

    static Set<String> uniqueNames = strings.stream().collect(Collectors.toSet());

    /**
     * Соберите имена людей в Map, где ключ — это имя, а значение — возраст.
     */
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
                    '}';
        }
    }

    static List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
    );

    static Map<String, Integer> persons = people.stream()
            .collect(Collectors.toMap(person -> person.name, person -> person.age));

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(array));
        //uniqueNames.forEach(System.out::println);
//        persons.forEach((name ,age) -> System.out.println(name + " : "+ age));

        // метод findFirst
        //System.out.println(people.stream().filter(person -> person.age > 30).findFirst().get());

        // метод anyMatch(пишем условие поиска) возвращает true/false
        //System.out.println(strings.stream().anyMatch(word -> word.length() > 5));

        // проверяет на соответствие условию всю структуру
        System.out.println(people.stream().allMatch(person -> person.age > 20));

    }
}
