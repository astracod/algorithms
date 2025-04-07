package org.example.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

    /**
     * В этом классе показана работа интерфейса Lock в реализации Reentrant с использованием интерфейса Condition.
     * Данная группа инструментов является аналогом synchronized,wait() и notify().
     * Но порядок выполнения всех потоков, без дополнительных флагов, не возможен.
     */
    private static class BankAccount {
        private Integer id;
        private double balance;
        private static Lock lock = new ReentrantLock();
        private static Condition canWithdraw = lock.newCondition();

        public BankAccount(Integer id) {
            this.id = id;
        }

        public BankAccount(Integer id, double balance) {
            this.id = id;
            this.balance = balance;

        }

        public void getBalance() throws InterruptedException {
            lock.lock();
            try {
                System.out.println("На счете: " + balance);
            } finally {
                lock.unlock();
            }
        }

        /**
         * Пополняем счет и используем снятие блокировки для метода withdraw.
         */
        public void deposit(double amount) throws InterruptedException {
            try {
                lock.lock();
                balance += amount;
                System.out.println("Пополнение счета: " + amount);
                canWithdraw.signal();
            } finally {
                lock.unlock();
            }
        }

        /**
         * Снятие со счета. Добавлено условие методом Condition для ожидания пока счет не будет выше снимаемой суммы.
         */
        public void withdraw(double amount) throws InterruptedException {
            try {
                lock.lock();
                if (amount > balance) {
                    System.out.println("Ожидание пополнения счета. Недостаточно средств для снятия.");
                    canWithdraw.await();
                }
                balance -= amount;
                System.out.println("Снятие суммы со счета: " + amount);
            } finally {
                lock.unlock();
            }
        }
    }

    private static class TransactionThread implements Runnable {

        private BankAccount account;
        private String operation;
        private double amount;

        public TransactionThread(BankAccount account, String operation) {
            this.account = account;
            this.operation = operation;
        }

        public TransactionThread(BankAccount account, String operation, double amount) {
            this.account = account;
            this.operation = operation;
            this.amount = amount;
        }

        @Override
        public void run() {
            System.out.println("Выполняется " + Thread.currentThread().getName());
            try {
                switch (operation) {
                    case "deposit" -> account.deposit(amount);
                    case "withdraw" -> account.withdraw(amount);
                    case "getBalance" -> account.getBalance();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount ivan = new BankAccount(1, 0.0);
        TransactionThread depositTask = new TransactionThread(
                ivan,
                "deposit",
                1000.0
        );
        TransactionThread withdrawTask = new TransactionThread(
                ivan, "withdraw", 550.0
        );
        TransactionThread getBalanceTask = new TransactionThread(ivan, "getBalance");

        Thread depositThread = new Thread(depositTask);
        Thread withdrawThread = new Thread(withdrawTask);
        Thread getBalanceThread = new Thread(getBalanceTask);

        withdrawThread.start();
        depositThread.start();
        getBalanceThread.start();
    }
}
