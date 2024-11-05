package org.example.stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class TryFlatMap {

    /**
     * Используйте flatMap, чтобы создать один плоский список всех фруктов и выведите его.
     */
    static List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("apple", "banana"),
            Arrays.asList("cherry", "date"),
            Arrays.asList("fig", "grape")
    );

    static List<String> oneList = listOfLists.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    static class Student {
        String name;
        List<String> subjects;

        Student(String name, List<String> subjects) {
            this.name = name;
            this.subjects = subjects;
        }
    }

    static List<Student> students = Arrays.asList(
            new Student("Alice", Arrays.asList("Math", "Science")),
            new Student("Bob", Arrays.asList("History")),
            new Student("Charlie", Arrays.asList("Math", "Art"))
    );

    static List<String> educationalSubjects = students.stream()
            .flatMap(student -> student.subjects.stream())
            .collect(Collectors.toList());

    /**
     * Используйте flatMap, чтобы получить список всех имен сотрудников из всех компаний и выведите его.
     */
    static class Company {
        String name;
        List<Employee> employees;

        Company(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
        }
    }

    static class Employee {
        String name;

        Employee(String name) {
            this.name = name;
        }
    }

    static List<Company> companies = Arrays.asList(
            new Company("TechCorp", Arrays.asList(new Employee("Alice"), new Employee("Bob"))),
            new Company("BizInc", Arrays.asList(new Employee("Charlie"), new Employee("David")))
    );

    static List<String> names = companies.stream()
            .flatMap(company -> company.employees.stream().map(employee -> employee.name))
            .collect(Collectors.toList());

    static class Employee2 {
        int id;               // Идентификатор сотрудника
        String name;         // Имя сотрудника
        String department;    // Отдел, в котором работает сотрудник
        double salary;       // Зарплата сотрудника

        // Конструктор класса
        Employee2(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    static List<Employee2> employees = Arrays.asList(
            new Employee2(1, "Alice", "Engineering", 75000),
            new Employee2(2, "Bob", "Engineering", 80000),
            new Employee2(3, "Charlie", "HR", 60000),
            new Employee2(4, "David", "Marketing", 65000),
            new Employee2(5, "Eve", "HR", 70000)
    );

    static Map<String, Double> people = employees.stream()
            .filter(employee2 -> !employee2.department.equals("HR"))
            .filter(employee2 -> employee2.salary > 65000)
            .collect(Collectors.toMap(employee2 -> employee2.name, employee2 -> employee2.salary));

    /**
     * Используйте flatMap, чтобы получить список всех предметов, изучаемых студентами с именем,
     * начинающимся на "A", и выведите его.
     */
    static class Student2 {
        String name;
        List<String> subjects;

        Student2(String name, List<String> subjects) {
            this.name = name;
            this.subjects = subjects;
        }
    }

    static List<Student2> students2 = Arrays.asList(
            new Student2("Alice", Arrays.asList("Math", "Science")),
            new Student2("Bob", Arrays.asList("History")),
            new Student2("Charlie", Arrays.asList("Math", "Art")),
            new Student2("David", Arrays.asList("Biology", "Math"))
    );

    static List<String> beganA = students2.stream()
            .filter(student2 -> student2.name.indexOf("A") == 0)
            .flatMap(student2 -> student2.subjects.stream())
            .collect(Collectors.toList());

    /**
     * получить список всех телефонных номеров сотрудников из отдела "Engineering".
     */
    static class Employee3 {
        String name;
        String department;
        List<String> phoneNumbers;

        Employee3(String name, String department, List<String> phoneNumbers) {
            this.name = name;
            this.department = department;
            this.phoneNumbers = phoneNumbers;
        }
    }

    static List<Employee3> employees3 = Arrays.asList(
            new Employee3("Alice", "Engineering", Arrays.asList("123", "456")),
            new Employee3("Bob", "Engineering", Arrays.asList("789")),
            new Employee3("Charlie", "HR", Arrays.asList("101", "112")),
            new Employee3("David", "HR", Arrays.asList("131"))
    );

    static List<String> phoneNumbers = employees3.stream()
            .filter(employee3 -> employee3.department.equals("Engineering"))
            .flatMap(employee3 -> employee3.phoneNumbers.stream())
            .collect(Collectors.toList());

    /**
     * получить список всех книг, взятых читателями, у которых более одной книги.
     */
    static class Reader {
        String name;
        List<String> books;

        Reader(String name, List<String> books) {
            this.name = name;
            this.books = books;
        }
    }

    static List<Reader> readers = Arrays.asList(
            new Reader("Alice", Arrays.asList("Book1", "Book2")),
            new Reader("Bob", Arrays.asList("Book3")),
            new Reader("Charlie", Arrays.asList("Book1", "Book4")),
            new Reader("David", Arrays.asList("Book5", "Book6"))
    );

    static List<String> allBooks = readers.stream()
            .filter(reader -> reader.books.size() > 1)
            .flatMap(reader -> reader.books.stream())
            .collect(Collectors.toList());

    /**
     * получить список всех навыков сотрудников с зарплатой выше 70000
     */
    static class Skill {
        String name;

        Skill(String name) {
            this.name = name;
        }
    }

    static class Employee4 {
        String name;
        double salary;
        List<Skill> skills;

        Employee4(String name, double salary, List<Skill> skills) {
            this.name = name;
            this.salary = salary;
            this.skills = skills;
        }
    }

    static List<Employee4> employees4 = Arrays.asList(
            new Employee4("Alice", 75000, Arrays.asList(new Skill("Java"), new Skill("SQL"))),
            new Employee4("Bob", 80000, Arrays.asList(new Skill("Python"))),
            new Employee4("Charlie", 60000, Arrays.asList(new Skill("Java"), new Skill("JavaScript"))),
            new Employee4("David", 90000, Arrays.asList(new Skill("C#")))
    );

    static List<String> allSkills = employees4.stream()
            .filter(employee4 -> employee4.salary > 70000)
            .flatMap(employee4 -> employee4.skills.stream().map(skill -> skill.name))
            .collect(Collectors.toList());


    /**
     * получить список всех городов, в которых живут клиенты из города "New York"
     */
    static class Address {
        String city;

        Address(String city) {
            this.city = city;
        }

    }

    static class Customer {
        String name;
        List<Address> addresses;

        Customer(String name, List<Address> addresses) {
            this.name = name;
            this.addresses = addresses;
        }
    }

    static List<Customer> customers = Arrays.asList(
            new Customer("Alice", Arrays.asList(new Address("New York"), new Address("Los Angeles"))),
            new Customer("Bob", Arrays.asList(new Address("Chicago"))),
            new Customer("Charlie", Arrays.asList(new Address("New York"), new Address("Miami"))),
            new Customer("David", Arrays.asList(new Address("Los Angeles")))
    );

    static List<String> cities = customers.stream()
            .filter(customer -> customer.addresses.stream().anyMatch(address -> address.city.equals("New York")))
            .flatMap(customer -> customer.addresses.stream())
            .map(address -> address.city)
            .collect(Collectors.toList());

    /**
     * Извлечение продуктов из заказов с фильтрацией по категории
     */
    static class Product {
        String name;
        String category;

        Product(String name, String category) {
            this.name = name;
            this.category = category;
        }
    }

    static class Order {
        List<Product> products;

        Order(List<Product> products) {
            this.products = products;
        }
    }

    static List<Order> orders = Arrays.asList(
            new Order(Arrays.asList(new Product("Laptop", "Electronics"),
                    new Product("Mouse", "Electronics"))),
            new Order(Arrays.asList(new Product("Keyboard", "Electronics"))),
            new Order(Arrays.asList(new Product("Monitor", "Electronics"),
                    new Product("HDMI Cable", "Accessories")))
    );

    static List<String> allProducts = orders.stream()
            .flatMap(order -> order.products.stream())
            .filter(product -> product.category.equals("Electronics"))
            .map(product -> product.name)
            .collect(Collectors.toList());

    /**
     * Получить список всех комментариев из постов, содержащих слово "learned"
     */
    static class Comment {
        String text;

        Comment(String text) {
            this.text = text;
        }
    }

    static class Post {
        List<Comment> comments;

        Post(List<Comment> comments) {
            this.comments = comments;
        }
    }

    static List<Post> posts = Arrays.asList(
            new Post(Arrays.asList(new Comment("Great post!"), new Comment("Thanks for sharing!"))),
            new Post(Arrays.asList(new Comment("Interesting read."))),
            new Post(Arrays.asList(new Comment("I learned something new!"), new Comment("Well written!")))
    );

    static List<String> comments = posts.stream()
            .flatMap(post -> post.comments.stream())
            .filter(comment -> comment.text.contains("learned"))
            .map(comment -> comment.text)
            .collect(Collectors.toList());

    /**
     * получить список всех тегов из статей, содержащих "#Java"
     */
    static class Tag {
        String name;

        Tag(String name) {
            this.name = name;
        }

    }

    static class Article {
        List<Tag> tags;

        Article(List<Tag> tags) {
            this.tags = tags;
        }

    }

    static List<Article> articles = Arrays.asList(
            new Article(Arrays.asList(new Tag("#Java"), new Tag("#Programming"))),
            new Article(Arrays.asList(new Tag("#Tech"))),
            new Article(Arrays.asList(new Tag("#Java"), new Tag("#Learning")))
    );

    static List<String> articlesWithJava = articles.stream()
            .flatMap(article -> article.tags.stream())
            .filter(tag -> tag.name.equals("#Java"))
            .map(tag -> tag.name)
            .collect(Collectors.toList());

    public static void main(String[] args) {
        //oneList.forEach(System.out::println);
        //educationalSubjects.forEach(System.out::println);
        //names.forEach(System.out::println);

        // создание карты после фильтрации листа с классами
        //people.forEach((name, age) -> System.out.println(name + " : " + age));

        //beganA.forEach(System.out::println);
        //phoneNumbers.forEach(System.out::println);
        //allBooks.forEach(System.out::println);

//        allSkills.forEach(System.out::println);
        // cities.forEach(System.out::println);
        // allProducts.forEach(System.out::println);
        //comments.forEach(System.out::println);
        //articlesWithJava.forEach(System.out::println);
    }
}
