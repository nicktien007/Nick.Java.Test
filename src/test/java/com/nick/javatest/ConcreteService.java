package com.nick.javatest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@RequiredArgsConstructor
public class ConcreteService extends AbstractService {


    private final MyDependency2 myDependency2;

//    @Autowired
    public ConcreteService(MyDependency myDependency, MyDependency2 myDependency2) {
        super(myDependency);
        this.myDependency2 = myDependency2;
    }

    @Override
    protected void initialize() {
        // 具體初始化邏輯
//        System.out.println("ConcreteService initialized with " + myDependency);
        System.out.println("ConcreteService initialized");
    }

    public void printMessage() {
        myDependency2.doSomething();
        System.out.println("ConcreteService printMessage");
    }
}