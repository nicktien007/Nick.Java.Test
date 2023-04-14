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
import java.util.*;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class Nick_3 {

	@Test
	@SneakyThrows
	void test1() {

		AConfigHandler aClassHandler = new AConfigHandler();
		BConfigHandler bClassHandler = new BConfigHandler();


		AConfig aConfig = new AConfig();
		BConfig bConfig = new BConfig();

		MapHandler aMapHandler = AnnotationUtils.findAnnotation(aConfig.getClass(), MapHandler.class);
		Class<?> value = aMapHandler.value();
		value.newInstance();


		MapHandler bMapHandler = AnnotationUtils.findAnnotation(bConfig.getClass(), MapHandler.class);
		bMapHandler.value().newInstance();

		Map<Class<? extends IConfig>, IConfigHandler> handlers = new HashMap<>();


		handlers.putIfAbsent(aConfig.getClass(), aMapHandler.value().newInstance());
		handlers.putIfAbsent(bConfig.getClass(), bMapHandler.value().newInstance());


		List<IConfig> configs = new ArrayList<>();

		configs.add(new AConfig());
		configs.add(new BConfig());
		configs.add(new AConfig());
		configs.add(new BConfig());
		configs.add(new BConfig());



		configs.forEach(config-> handlers.get(config.getClass()).doShowId(config));
		configs.forEach(config-> handlers.get(config.getClass()).doShowId(config));

		AAConfig aaConfig = new AAConfig();

		AConfigHandler a = new AConfigHandler();
		a.doShowId(aaConfig);

	}

	public void a(List<IConfig> list){

	}


	interface IConfig<T> {
		void showId();

		T getInstance();
	}

	interface IAConfig extends IConfig {
	}

	interface IBConfig extends IConfig {
	}

	@MapHandler(AConfigHandler.class)
	public static class AConfig implements IConfig<List<Integer>> {

		@Override
		public void showId(){
			log.info("AClass");
		}

		@Override
		public List<Integer> getInstance() {
//			return 1;
			List<Integer> list = new ArrayList<>();
			list.add(1);
			list.add(2);
			list.add(3);
			return list;
		}
	}

	public static class AAConfig extends AConfig{

	}

	@MapHandler(BConfigHandler.class)
	public static class BConfig implements IConfig<List<String>> {

		@Override
		public void showId(){
			log.info("BClass");
		}

		@Override
		public List<String> getInstance() {
			return Collections.emptyList();
		}
	}


	interface IConfigHandler {
		void doShowId(IConfig<?> config);
	}


//	@need("aa")
	public static class AConfigHandler implements IConfigHandler {
		@Override
		public void doShowId(IConfig<?> config) {
			config.showId();
			List<Integer> instance = (List<Integer>)config.getInstance();
		}
	}

	public static class BConfigHandler implements IConfigHandler {
		@Override
		public void doShowId(IConfig<?> config){
			config.showId();
		}

	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface MapHandler {

		Class<? extends IConfigHandler> value();
	}
}
