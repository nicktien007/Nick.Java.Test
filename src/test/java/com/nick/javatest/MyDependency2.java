package com.nick.javatest;

import org.springframework.stereotype.Component;

@Component
public class MyDependency2 {
    public void doSomething() {
        System.out.println("DependencyComponent2 is doing something.");
    }
}
