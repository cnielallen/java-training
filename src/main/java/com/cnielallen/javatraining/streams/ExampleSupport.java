package com.cnielallen.javatraining.streams;

public abstract  class ExampleSupport {
    protected void doExample(String description, Runnable action){
        System.out.println("==============================");
        System.out.println("START:   "   + description);
        System.out.println("==============================");
        action.run();
        System.out.println("\n\n");
    }

    protected void printItem(Object object){
        var text = new StringBuilder(" - ");
        if( object == null) {
            text.append("NULL");
        } else  {
            text.append(object.getClass().getName()).append(": ").append(object);
        }
        System.out.println(text);
    }
}
