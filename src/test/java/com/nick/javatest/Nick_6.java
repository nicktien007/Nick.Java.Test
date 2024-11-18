package com.nick.javatest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Nick_6 {


	@Autowired
	private ConcreteService concreteService;

	@Test
	void test_case1() {
		concreteService.printMessage();

		User bClass_1 = new User("name");
		User bClass_2 = new User("name");

		boolean a = bClass_1 == bClass_1;
	}



	public static class User{
		private final String name;

		public String getName() {
			return name;
		}

		public User(String name) {
            this.name = name;
        }
    }



	abstract class AClass{
		public Integer  getV(){
			return 1;
		};

		public void print(){
			log.info("print--------  "+this.getV().toString());
		}
	}

	class BClass extends AClass{
		@Override
		public Integer getV() {
			return 2;
		}
	}




}
