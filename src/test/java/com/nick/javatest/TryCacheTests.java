package com.nick.javatest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
class TryCacheTests {

    private final ObjectMapper objectMapper = new ObjectMapper();



    @Test
    @SneakyThrows
    void test1() {

        List<AClass> list = new ArrayList<>();

        list.add(new AClass("1", "name1"));
        list.add(new AClass("2", "name2"));
        list.add(new AClass("3", "name3"));

        String s = objectMapper.writeValueAsString(list);
        log.info(s);
    }



    public static void readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        // ...
    }

    private Integer testMethod(int a) throws IOException {

//        return a;
//        throw new Exception("aa");
        throw new RuntimeException("aa");
    }

    private void method1(String v) throws Exception {
        log.error("method1 error");
    }

    public static void toTry(Runnable act, Consumer<Exception> errorCallback) {
        try {
            act.run();
        } catch (Exception ex) {
            log.error("ex error = ", ex);
            if (errorCallback != null) {
                errorCallback.accept(ex);
            }
        }
    }

//    public static void toTry(Runnable act) {
//        try {
//            act.run();
//        } catch (Exception ex) {
//            log.error("ex error = ", ex);
//        }
//    }


    public static void toTestTry(ExceptionWrapper wrapper) {
        try {
//            return wrapper.wrap();
//            return wrapper.wrap();
            wrapper.wrap();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toTestTry2(ExceptionWrapper2<T> wrapper) {
        try {
            return wrapper.wrap();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Optional<T> toTry(Supplier<T> func, Function<Exception, Optional<T>> errorCallback) {
        try {
            return Optional.ofNullable(func.get());
        } catch (Exception ex) {

            log.error("ex error = ", ex);

            if (errorCallback != null) {
                return errorCallback.apply(ex);
            }

            return Optional.empty();
        }
    }

    public static <T> Optional<T> toTry(Supplier<T> func) {
        try {
            return Optional.ofNullable(func.get());
        } catch (Exception ex) {

            log.error("ex error = ", ex);
            return Optional.empty();
        }
    }


}


