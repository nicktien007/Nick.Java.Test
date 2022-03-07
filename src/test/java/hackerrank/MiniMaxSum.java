package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j

public class MiniMaxSum {

    @Test
    void test_1() {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);


        mainProcessor(arr);
    }

    void mainProcessor(List<Integer> arr){

        List<Long> result = new ArrayList<Long>();
        arr.forEach(x->{
            long answer = arr.stream().mapToLong(y -> y).sum() - x;
            result.add(answer);
        });

        System.out.println(Collections.min(result) + " " + Collections.max(result));
    }
}
