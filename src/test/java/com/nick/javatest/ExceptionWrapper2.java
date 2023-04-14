package com.nick.javatest;

@FunctionalInterface
public interface ExceptionWrapper2<T> {
	T wrap() throws Exception;
}