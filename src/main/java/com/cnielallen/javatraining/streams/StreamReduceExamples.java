package com.cnielallen.javatraining.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamReduceExamples extends ExampleSupport{
    public static void main(String[] args) {
        var app = new StreamReduceExamples();
        app.doExample("Sum Example: ", app::sumExample);
        app.doExample("Min/Max Example: ", app::minMaxExample);
        app.doExample("Reduce as Total Example #1: ", app::reduceAsTotalExample1);
        app.doExample("Reduce as Total Example #2 ", app::reduceAsTotalExample2);
        app.doExample("Reduce as Total Detailed Example: ", app::reduceAsTotalDetailedExample);
    }

    private void sumExample() {
        var integers = Arrays.asList(3, 8, 1, 2, 21, 5, 13);
        System.out.println("Integer: " + integers);
        var sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("\n #Sum(): " + sum);
    }
    private void minMaxExample() {
        var integers = Arrays.asList(3, 8, 1, 2, 21, 5, 13);
        System.out.println("Integer: " + integers);
        var min = integers.stream().min(Integer::compare);
        var max = integers.stream().max(Integer::compare);
        System.out.println("\n#Min(): " + min.orElse(null) + " #Max(): " + max.orElse(null));
    }

    private void reduceAsTotalExample1() {
        var items = Arrays.asList(1,3,5,7);
        System.out.println("items " + items);
        var total = items.stream()
                .reduce((v1, v2) -> v1 + v2)
                .orElse(0);
    }

    private void reduceAsTotalExample2() {
        var items = Arrays.asList(1,3,5,7);
        System.out.println("items " + items);
        var total = items.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    private void reduceAsTotalDetailedExample() {
        var items = Arrays.asList(1,3,5,7);
        System.out.println("items " + items);
        var total = items.stream()
                .peek(v -> System.out.println("Next value: " + v))
                .reduce((v1,v2) -> {
                    var sum = v1+ v2;
                    System.out.println("Reducing " + v1 + " & " + v2 + " into "  + sum);
                    return sum;
                })
                .orElse(0);
        System.out.println("\n1) Reduce as total: " + total);
    }




}
