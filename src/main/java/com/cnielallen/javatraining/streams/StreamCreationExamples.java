package com.cnielallen.javatraining.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationExamples extends ExampleSupport{
    public static void main(String[] args) {
        var app = new StreamCreationExamples();
        app.doExample("Fixed Stream Creation Example: ", app::fixedStreamCreation);
        app.doExample("Stream Builder Example: ", app::streamBuilder);
        app.doExample("Stream from a collection Example: ", app::streamFromCollection);
        app.doExample("Stream from an array Example: ", app::streamFromArray);
        app.doExample("Stream from generated values Example: ", app::streamFromGeneratedValues);
        app.doExample("Stream.iterate Example: ", app::streamIterate);
        app.doExample("IntStream Example: ", app::intStream);


    }

    private void fixedStreamCreation() {
       Stream.of("value1", "value2", "value3")
               .forEach(this::printItem);
    }
    private void streamBuilder() {
        var builder =  Stream.builder();
        builder.add("value1");
        builder.add("value2");
        builder.add("value3");
        builder.build().forEach(this::printItem);

    }
    private void streamFromCollection() {
        var items = Arrays.asList("value1", "value2", "value3");
        items.stream()
                .forEach(this::printItem);
    }

    private void streamFromArray() {
        var items = new String [] {"value1", "value2", "value3"};
        Arrays.stream(items)
                .forEach(this::printItem);
    }

    private void streamFromGeneratedValues() {
        Stream.generate(()-> Math.random())
                .limit(10)
                .forEach(this::printItem);
    }

    private void streamIterate() {
       var seed = 1;
       Stream.iterate(seed, previous -> previous + 2)
               .limit(10)
               .forEach(this::printItem);
    }

    private void intStream() {
        IntStream.range(5,10)
                .forEach(this::printItem);
    }

}
