package com.nick.javatest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Person {

    private String id;
    private String name;
    private int age;
    private String address;
}
