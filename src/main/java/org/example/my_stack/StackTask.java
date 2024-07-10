package org.example.my_stack;

import java.util.Stack;

public class StackTask {
    private char[] a;
    private int top;

    public int size;

    public StackTask() {
        a = new char[10000];
        top = -1;    //индекс при пустом стеке
    }

    public void push(char x) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        top++;
        a[top] = x;
        size++;
    }

    public boolean isFull() {
        return top == a.length - 1;
    }

    public void pop() {        //удаляется только последний (верхний)
        if (isEmpty())
            System.out.println("error");
        else {
            System.out.println(a[top]);
            top--;
            size--;
        }
    }

    public char back() {
        if (isEmpty()) return 0;
        else return a[top];
    }

    public String clear() {
        top = -1;
        size = 0;
        return "OK";
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void exit() {
        System.out.println("buy");
    }
}

class Solutions {

    public boolean isValid(String s) {
        StackTask stackTask = new StackTask();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') stackTask.push(s.charAt(i));
            else {
                if (stackTask.isEmpty()) return false;
                char res = stackTask.back();
                stackTask.pop();
                if (!(s.charAt(i) == ')' && res == '(' || s.charAt(i) == ']' && res == '[' || s.charAt(i) == '}' && res == '{'))
                    return false;
            }
        }
        return stackTask.isEmpty();
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    public int postfixNotation(String notation) {
        Stack<Integer> stack = new Stack<>();
        String[] a = notation.split(" ");
        for (int i = 0; i < a.length; i++) {
            String symbol = a[i];
            if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                int result = switch (symbol) {
                    case "+" -> first + second;
                    case "-" -> first - second;
                    case "*" -> first * second;
                    default -> 0;
                };
                stack.push(result);
            }
            if ((isNumeric(symbol))) stack.push(Integer.parseInt(symbol));
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String s = "8 9 + 1 7 - * ";
        String a = "123 7 +";
        Solutions solutions = new Solutions();
        System.out.println(solutions.postfixNotation(s));
    }


}