package com.nick.javatest;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class Nick_1 {

	@Test
	@SneakyThrows
	void test1() {

		AConfigHandler aClassHandler = new AConfigHandler();
		BConfigHandler bClassHandler = new BConfigHandler();

//		List<IConfigHandler> handlers = new ArrayList<>();
//		handlers.add(aClassHandler);
//		handlers.add(bClassHandler);


		AConfig aConfig = new AConfig();
		BConfig bConfig = new BConfig();

		MapHandler aMapHandler = AnnotationUtils.findAnnotation(aConfig.getClass(), MapHandler.class);
		Class<?> value = aMapHandler.value();
		value.newInstance();


		MapHandler bMapHandler = AnnotationUtils.findAnnotation(bConfig.getClass(), MapHandler.class);
		bMapHandler.value().newInstance();

//		Map<Class<? extends IConfig>, IConfigHandler> handlers = new HashMap<>();
		Map<Class<? extends IConfig>, IConfigHandler> handlers = new HashMap<>();
//		handlers.putIfAbsent(AConfig.class, aClassHandler);
//		handlers.putIfAbsent(BConfig.class, bClassHandler);

		handlers.putIfAbsent(aConfig.getClass(), aMapHandler.value().newInstance());
		handlers.putIfAbsent(bConfig.getClass(), bMapHandler.value().newInstance());


		List<IConfig> configs = new ArrayList<>();

		configs.add(new AConfig());
		configs.add(new BConfig());
		configs.add(new AConfig());
		configs.add(new BConfig());
		configs.add(new BConfig());

//		doing.forEach(ITest::showId);

//		handlers.forEach(h->h.doShowId());

		configs.forEach(config-> handlers.get(config.getClass()).doShowId(config));


//		a(configs);
	}

	public void a(List<IConfig> list){

	}


	interface IConfig {
		void showId();
	}

	interface IAConfig extends IConfig {
	}

	interface IBConfig extends IConfig {
	}

	@MapHandler(AConfigHandler.class)
	public class AConfig implements IAConfig {

		@Override
		public void showId(){
			log.info("AClass");
		}
	}

	@MapHandler(BConfigHandler.class)
	public class BConfig implements IBConfig {

		@Override
		public void showId(){
			log.info("BClass");
		}
	}


	interface IConfigHandler {
		void doShowId(IConfig config);
	}


//	@need("aa")
	public static class AConfigHandler implements IConfigHandler {
		@Override
		public void doShowId(IConfig config) {
			config.showId();
		}
	}

	public static class BConfigHandler implements IConfigHandler {
		@Override
		public void doShowId(IConfig config){
			config.showId();
		}

	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface MapHandler {

		Class<? extends IConfigHandler> value();
	}
}
