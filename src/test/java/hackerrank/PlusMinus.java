package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

@Slf4j

public class PlusMinus {

    @Test
    void test_1() {
//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(1);
//        arr.add(0);
//        arr.add(-1);
//        arr.add(-1);

        List<Integer> arr = new ArrayList<>();
        arr.add(-4);
        arr.add(3);
        arr.add(-9);
        arr.add(0);
        arr.add(4);
        arr.add(1);

        mainProcessor(arr);
    }

    void mainProcessor(List<Integer> arr){
        long total = arr.stream().count();

        long positiveCount = arr.stream().filter(x -> x > 0).count();
        long negativeCount = arr.stream().filter(x -> x < 0).count();
        long zeroCount = arr.stream().filter(x -> x == 0).count();

        System.out.println(BigDecimal.valueOf(positiveCount).divide(BigDecimal.valueOf(total),6,ROUND_HALF_DOWN));
        System.out.println(BigDecimal.valueOf(negativeCount).divide(BigDecimal.valueOf(total),6,ROUND_HALF_DOWN));
        System.out.println(BigDecimal.valueOf(zeroCount).divide(BigDecimal.valueOf(total),6,ROUND_HALF_DOWN));

    }
}
