package com.cnielallen.javatraining.streams;

import java.util.stream.IntStream;

public class IntStreamExamples extends ExampleSupport{
    public static void main(String[] args) {
        var app = new IntStreamExamples();
        app.doExample("IntStream reverse range", app::intStreamRangeReveres);
        app.doExample("Reduce as Factorial Example", app::factorialExample);
        app.doExample("Check If Prime NumberExample", app::checkIfPrimeExample);
        app.doExample("Count Prime Numbers Example", app::countPrimeNumbersBelow20);

    }


    private void intStreamRangeReveres(){
        var from = 3;
        var to = 10;

        IntStream.rangeClosed(from, to)
                .map(v -> to - (v - from))
                .forEach(System.out::println);

    }

    private void factorialExample(){
        var factorialOf = 4;

        var factorial = IntStream.rangeClosed(1, factorialOf)
                .peek(v -> System.out.println("Next Value:" + v))
                .reduce((v1, v2) -> v1 * v2)
                .orElse(0);

    }

    private boolean isPrime(int n){
        return  IntStream.rangeClosed(2, n)
                .noneMatch(d -> n % d == 0);

    }

    private void checkIfPrimeExample(){
        var n = 37;
        System.out.println("The value is " + n + (isPrime(n) ? " a" : " not a") + " prime number");
        n = 24;
        System.out.println("The value is " + n + (isPrime(n) ? " a" : " not a") + " prime number");
    }

    private void countPrimeNumbersBelow20(){
        var n = 20;
        var primeNumbersBelowN = IntStream
                .rangeClosed(2,n)
                .filter(this::isPrime)
                .peek(v -> System.out.println("Next prime number: " + v))
                .count();
        System.out.println("There are " +primeNumbersBelowN + " prime numbers below " + n + ".") ;
    }


}
