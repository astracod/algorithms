package org.example.multithreading;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class MyAsync {

    private static class BankAccount {
        AtomicReference<Double> balance = new AtomicReference<>(100.0);

        public String getBalance() {
            return "На счете: " + balance.get();
        }

        public Double deposit(double amount) {
            Double result = balance.accumulateAndGet(amount, Double::sum);
            System.out.println("Пополнение счета: " + amount);
            System.out.println("Состояние счета после пополнения: " + result);
            return result;
        }

        public Double withdraw(double amount) {
            if (amount > balance.get()) {
                System.out.println("Ожидание пополнения счета. Недостаточно средств для снятия.");
                return 0.0;
            }
            Double result = balance.updateAndGet(b -> b - amount);
            System.out.println("Снятие суммы со счета: " + amount);
            System.out.println("Состояние счета после снятия: " + result);
            return result;
        }
    }

    public static void main(String[] args) {
        BankAccount dmitriy = new BankAccount();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<Double> firstWithdraw =
                CompletableFuture.supplyAsync(() -> dmitriy.withdraw(500), executor);

        CompletableFuture<Double> firstDeposit = firstWithdraw.thenCompose(
                res -> CompletableFuture.supplyAsync(() -> dmitriy.deposit(1000.0), executor));

        CompletableFuture<Double> secondWithdraw = firstDeposit.thenCompose(
                res -> CompletableFuture.supplyAsync(() -> dmitriy.withdraw(600), executor));

        CompletableFuture<String> getBalance = secondWithdraw.thenApply((result) -> dmitriy.getBalance());
        String balance = getBalance.join();

        System.out.println("Результат в конце: " + balance);
        executor.shutdown();

    }
}
