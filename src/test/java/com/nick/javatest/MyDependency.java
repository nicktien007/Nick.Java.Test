package com.nick.javatest;

import org.springframework.stereotype.Component;

@Component
public class MyDependency {
    public void doSomething() {
        System.out.println("DependencyComponent is doing something.");
    }
}
