package com.cnielallen.javatraining.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamBasicsExamples extends ExampleSupport{
    public static void main(String[] args) {
        var app = new StreamBasicsExamples();
        app.doExample("Simple Stream Example: ", app::simpleStream);
        app.doExample("Stream#flatMap() Example:  ", app::flatMapExample);
        app.doExample("Stream#torrayExample: ", app::toArrayExample);
        app.doExample("Map Strings into Integers Example: ", app::mapExample);
        app.doExample("Peek Example:  ", app::peekExample);
        app.doExample("Filter Example:  ", app::filterExample);
        app.doExample("Find First Example:  ", app::findFirstExample);
        app.doExample("Find Any Example:  ", app::findAnyExample);
    }


    private void simpleStream() {
        var items = Arrays.asList( "String #1", "String #2", "String #3");
        System.out.println("items: " +  items);
        System.out.println("\n1) Print each Object in the stream: ");
        items.stream()
                .forEach(value-> System.out.println(value));
        System.out.println("\n2) Print each Object in the stream: ");
        items.stream()
                .forEach(System.out::println);
        System.out.println("\n3) PrintItem each Object in the stream: ");
        items.stream()
                .forEach(value -> printItem(value));

        System.out.println("\n4) PrintItem each Object in the stream: ");
        items.stream()
                .forEach(this::printItem);
    }


    private void flatMapExample() {
        List<List<String>> items = new ArrayList<>();;
        items.add(Arrays.asList("one", "two", "three"));
        items.add(Arrays.asList("four"));
        items.add(Arrays.asList("five", "six"));
        System.out.println("items: " +  items);
        System.out.println("\n1) Stream over items: ");
        items.stream()
                .forEach(this::printItem);

        System.out.println("\n1) Stream over flatMap items: ");

        items.stream()
                .flatMap(List::stream)
                .forEach(this::printItem);
    }

    private void toArrayExample() {
        var items = Arrays.asList( "String #1", "String #2", "String #3");
        System.out.println("items: " +  items);
        System.out.println("\n1) Store stream items into an array: ");
        var array1 = items.stream().toArray(size -> new String[size]);
        System.out.println("Array: " + Arrays.toString(array1));

        System.out.println("\n2) Store stream items into an array: ");
        var array2 = items.stream().toArray(String[]::new);
        System.out.println("Array: " + Arrays.toString(array2));
    }

    private void mapExample() {
        var strings = Arrays.asList( "1", "1", "2", "3", "5", "8", "13", "21");
        System.out.println("Strings: " +  strings);
        System.out.println("\n1) Map strings into integers: ");
        strings.stream()
              .map(string -> Integer.valueOf(string))
              .forEach(this::printItem);
        System.out.println("\n2) Map strings into integers: ");
        strings.stream()
                .map(Integer::valueOf)
                .forEach(this::printItem);
    }

    private void peekExample() {
        var strings = Arrays.asList( "1", "1", "2", "3", "5", "8", "13", "21");
        System.out.println("Strings: " +  strings);
        System.out.println("\n1) #peek #map and #forEach ");
        strings.stream()
                .peek(this::printItem)
                .map(Integer::valueOf)
                .forEach(this::printItem);

    }

    private void filterExample() {
        var integers = Arrays.asList(3,8,1,2,21,5,13);
        System.out.println("Integers: " +  integers);
        System.out.println("\n1) #filter value over 5: ");
        integers.stream()
                .filter(value -> value > 5)
                .forEach(this::printItem);

    }

    private void findFirstExample() {
        var integers = Arrays.asList(3,8,1,2,21,5,13);
        System.out.println("Integers: " +  integers);
        var first = integers.stream()
                .filter(value -> value > 5)
                .findFirst();

        System.out.println("\n1) #FindFirst value over 5: " + first.orElse(null));

         first = integers.stream()
                .filter(value -> value < 5)
                .findFirst();

        System.out.println("\n1) #FindFirst value under 5: " + first.orElse(null));

    }


    private void findAnyExample() {
        var integers = Arrays.asList(3,8,1,2,21,5,13);
        System.out.println("Integers: " +  integers);
        var any = integers.stream()
                .filter(value -> value > 5)
                .findAny();

        System.out.println("\n1) #FindAny value over 5: " + any.orElse(null));

        any = integers.stream()
                .filter(value -> value < 5)
                .findAny();

        System.out.println("\n1) #FindAny value under 5: " + any.orElse(null));

    }
}
