package com.nick.javatest;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@RequiredArgsConstructor
@Service
public abstract class AbstractService {

    private final MyDependency myDependency;

//    @Autowired
//    protected AbstractService(MyDependency myDependency) {
//        this.myDependency = myDependency;
//    }

    @PostConstruct
    private void postConstruct() {
        myDependency.doSomething();
        initialize();
    }

    protected abstract void initialize();
}