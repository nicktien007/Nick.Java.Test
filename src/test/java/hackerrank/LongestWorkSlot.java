package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j

public class LongestWorkSlot {

    @Test
    void test_1() {

        List<List<Integer>> arr = new ArrayList<>();

//        List<Integer> a1 = new ArrayList<>();
//        a1.add(0);
//        a1.add(3);
//        arr.add(a1);
//
//        List<Integer> a2 = new ArrayList<>();
//        a2.add(2);
//        a2.add(5);
//        arr.add(a2);
//
//        List<Integer> a3 = new ArrayList<>();
//        a3.add(0);
//        a3.add(9);
//        arr.add(a3);
//
//        List<Integer> a4 = new ArrayList<>();
//        a4.add(1);
//        a4.add(15);
//        arr.add(a4);


        List<Integer> a1 = new ArrayList<>();
        a1.add(0);
        a1.add(3);
        arr.add(a1);

        List<Integer> a2 = new ArrayList<>();
        a2.add(20);
        a2.add(5);
        arr.add(a2);

        List<Integer> a3 = new ArrayList<>();
        a3.add(2);
        a3.add(6);
        arr.add(a3);

        List<Integer> a4 = new ArrayList<>();
        a4.add(15);
        a4.add(7);
        arr.add(a4);

        List<Integer> a5 = new ArrayList<>();
        a5.add(9);
        a5.add(8);
        arr.add(a5);

        List<Integer> a6 = new ArrayList<>();
        a6.add(19);
        a6.add(9);
        arr.add(a6);

        List<Integer> a7 = new ArrayList<>();
        a7.add(24);
        a7.add(10);
        arr.add(a7);

        List<Integer> a8 = new ArrayList<>();
        a8.add(4);
        a8.add(12);
        arr.add(a8);

        List<Integer> a9 = new ArrayList<>();
        a9.add(3);
        a9.add(13);
        arr.add(a9);

        System.out.println(mainProcessor(arr));
    }

    private char mainProcessor(List<List<Integer>> leaveTimes) {

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "a");
        map.put(1, "b");
        map.put(2, "c");
        map.put(3, "d");
        map.put(4, "e");
        map.put(5, "f");
        map.put(6, "g");
        map.put(7, "h");
        map.put(8, "i");
        map.put(9, "j");
        map.put(10, "k");
        map.put(11, "l");
        map.put(12, "m");
        map.put(13, "n");
        map.put(14, "o");
        map.put(15, "p");
        map.put(16, "q");
        map.put(17, "r");
        map.put(18, "s");
        map.put(19, "t");
        map.put(20, "u");
        map.put(21, "v");
        map.put(22, "w");
        map.put(23, "x");
        map.put(24, "y");
        map.put(25, "z");


        int prevTime = 0;
        int maxTime = 0;
        int id = 0;

        for (int i = 0; i < leaveTimes.size(); i++) {
            Integer time = leaveTimes.get(i).get(1);
            if (i != 0) {
                prevTime = leaveTimes.get(i-1).get(1);
            }
            Integer totalTime = time - prevTime;

            if (totalTime > maxTime) {
                maxTime = totalTime;
                id = leaveTimes.get(i).get(0);
            }

            //System.out.println(totalTime);

        }


        return map.get(id).toCharArray()[0];
    }
}
