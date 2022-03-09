package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Locale;

@Slf4j

public class MarsExploration {

    @Test
    void test_1() {

        System.out.println(mainProcessor("SOSSPSSQSSOR"));
    }

    private int mainProcessor(String s) {

        int length = s.length();

//        int messageCount = length / 3;
        char[] chars = s.toUpperCase(Locale.ROOT).toCharArray();


        int total = 0;
        for (int i = 0; i < length; i = i+3) {
            if (chars[i] != 'S') {
                total++;
            }

            if (chars[i+1] != 'O') {
                total++;
            }

            if (chars[i+2] != 'S') {
                total++;
            }
        }

        return total;

    }
}
