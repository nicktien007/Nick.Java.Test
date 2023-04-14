package com.nick.javatest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class Nick_2 {

	@Test
	void test1() {
//		AConfigHandler aClassHandler = new AConfigHandler();
//		BConfigHandler bClassHandler = new BConfigHandler();
//
//
//		Map<Class<? extends IConfig<?>>, IConfigHandler> handlers = new HashMap<>();
//
//
//		handlers.putIfAbsent(AConfig.class, aClassHandler);
//		handlers.putIfAbsent(BConfig.class, bClassHandler);
//
//
//		List<IConfig<?>> configs = new ArrayList<>();
//
//		configs.add(new AConfig());
//		configs.add(new BConfig());
//		configs.add(new AConfig());
//		configs.add(new BConfig());
//		configs.add(new BConfig());
//
//		configs.forEach(config-> handlers.get(config.getClass()).doShowId(config));


		test(TransportType.Activity);
	}

	private void test(TransportType type){
		if (TransportType.RESOURCE.equals(type)) {
			log.info("RESOURCE");
		}
	}


	interface IConfig<T extends AInfo> {
		void showId();

		T getInstance();
	}


	public class AConfig implements IConfig<AInfo> {

		@Override
		public void showId(){
			log.info("AClass");
		}

		@Override
		public AInfo getInstance() {
			return null;
		}
	}

	public class BConfig implements IConfig<AInfo> {

		@Override
		public void showId(){
			log.info("BClass");
		}

		@Override
		public AInfo getInstance() {
			return null;
		}
	}

	class InfoBase{

	}
	@RequiredArgsConstructor
	class AInfo extends InfoBase{
		@Getter
		private final Integer id;
	}

	@RequiredArgsConstructor
	class BInfo extends InfoBase{
		@Getter
		private final Integer id;
	}


//	interface IConfigHandler<T extends IConfig> {
	interface IConfigHandler {
		void doShowId(IConfig<?> config);
	}


//	@need("aa")
	public class AConfigHandler implements IConfigHandler {
		@Override
		public void doShowId(IConfig<? extends InfoBase> config) {
			config.showId();
			AInfo instance = config.getInstance();

//			instance.getId()
		}

}

	public class BConfigHandler implements IConfigHandler {
		@Override
		public void doShowId(IConfig<? extends InfoBase> config){
			config.showId();
		}

	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.SOURCE)
	public @interface need {

		String value() default "";
	}

	public enum TransportType {
		RESOURCE,
		ZIP,
		Activity
	}
}
