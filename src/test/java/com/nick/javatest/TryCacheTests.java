package com.nick.javatest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
class TryCacheTests {

    @Test
    void test1() {
        Optional<Integer> result = toTry((Supplier<Integer>) () -> testMethod(3), ex -> {
            throw new RuntimeException("bb");
//            return Optional.empty();
        });
    }

    private Integer testMethod(int a) {

//        return a;
//        throw new Exception("aa");
        throw new RuntimeException("aa");
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

    public static void toTry(Runnable act) {
        try {
            act.run();
        } catch (Exception ex) {
            log.error("ex error = ", ex);
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


