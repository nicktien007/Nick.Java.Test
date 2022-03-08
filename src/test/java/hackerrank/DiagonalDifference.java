package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j

public class DiagonalDifference {

    @Test
    void test_1() {

        List<List<Integer>> arr = new ArrayList<>();

        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        arr.add(a1);

        List<Integer> a2 = new ArrayList<>();
        a2.add(4);
        a2.add(5);
        a2.add(6);
        arr.add(a2);

        List<Integer> a3 = new ArrayList<>();
        a3.add(9);
        a3.add(8);
        a3.add(9);
        arr.add(a3);


        System.out.println(mainProcessor(arr));
    }

    private int mainProcessor(List<List<Integer>> arr) {

        Integer idx = 0;
        Integer total1 = 0;
        Integer total2 = 0;

        for (List<Integer> a : arr) {
            total1 += a.get(idx);
            idx++;
        }

        Collections.reverse(arr);
        idx = 0;
        for (List<Integer> a : arr) {
            total2 += a.get(idx);
            idx++;
        }

        return Math.abs(total1 - total2);
    }
}
