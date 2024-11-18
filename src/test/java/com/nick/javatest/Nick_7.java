package com.nick.javatest;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
public class Nick_7 {

	@Test
	void test_case1() {

		GClass.printA();
		GClass.printResult();

		GClass.setA("BB");

		GClass.printA();
		GClass.printResult();

		Assert.assertEquals("aaBB",GClass.getResult());
	}
}
