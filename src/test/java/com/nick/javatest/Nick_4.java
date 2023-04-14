package com.nick.javatest;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class Nick_4 {
	@Test
	void test_1() {

		log.info(TransportTypeA.HTML.name().toLowerCase());
	}

	private void method2(TransportTypeA  a){

	}



	private void method(List<?> list){
		list.forEach(x->log.info(x.toString()));
	}

	@Data
	@RequiredArgsConstructor
	public static class AClass{
		private final String id;

		@ToString.Exclude
		private final String name;
	}

	@Builder()
	@ToString
	static class BClass{
		private  String id;

		@lombok.NonNull
		private  String name;
	}

	public enum TransportTypeA {
		HTML,
		RESOURCE
	}

	public enum TransportTypeB {
		ZIP,
		ACTIVITY,
	}
}
