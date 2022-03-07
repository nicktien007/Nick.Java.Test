package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j

public class TSMC_FizzBuzz {

    @Test
    void test_1() {
        mainProcessor(15);
    }

    void mainProcessor(Integer n){
        for (int i = 1; i <= n; i++) {

            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println("FizzBuzz");
                continue;
            }

            if (i % 3 == 0) {
                System.out.println("Fizz");
                continue;
            }

            if (i % 5 == 0) {
                System.out.println("Buzz");
                continue;
            }

            System.out.println(i);
        }
    }
}
