package com.cnielallen.javatraining.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamCollectorsExamples extends ExampleSupport{
    public static void main(String[] args) {
        var app = new StreamCollectorsExamples();
        app.doExample("Collect List Example: ", app::collectListExample);
        app.doExample("Sorted and Collect List Example: ", app::sortedAndCollectListExample);
        app.doExample("Distinct and Collect List Example: ", app::distinctAndCollectListExample);
        app.doExample("Sorted, Distinct and Collect List Example: ", app::sortedDistinctAndCollectListExample);
        app.doExample("Joining Example: ", app::joiningExample);
    }


    private void collectListExample(){
        var items =  new String[] {"bravo", "charlie", "foxtrot", "delta", "bravo"};
        System.out.println("items: " + Arrays.toString(items));

        var list = Arrays.stream(items)
                .collect(Collectors.toList());

        System.out.println("\n 1) Collected as List: " + list);
    }

    private void sortedAndCollectListExample(){
        var items =  new String[] {"bravo", "charlie", "foxtrot", "delta", "bravo"};
        System.out.println("items: " + Arrays.toString(items));

        var list = Arrays.stream(items)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\n 2) Collected as List: " + list);
    }



    private void distinctAndCollectListExample(){
        var items =  new String[] {"bravo", "charlie", "foxtrot", "delta", "bravo"};
        System.out.println("items: " + Arrays.toString(items));

        var list = Arrays.stream(items)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\n 3) Collected as List: " + list);
    }

    private void sortedDistinctAndCollectListExample(){
        var items =  new String[] {"bravo", "charlie", "foxtrot", "delta", "bravo"};
        System.out.println("items: " + Arrays.toString(items));

        var list = Arrays.stream(items)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\n 4) Collected as List: " + list);
    }

    private void joiningExample(){
        var items =  new String[] {"bravo", "charlie", "foxtrot", "delta", "bravo"};
        System.out.println("items: " + Arrays.toString(items));

        var joined = Arrays.stream(items)
                .sorted()
                .distinct()
                .collect(Collectors.joining("|"));

        System.out.println("\n 5) Joined as String: " + joined);
    }

}
