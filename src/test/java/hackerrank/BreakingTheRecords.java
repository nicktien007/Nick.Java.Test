package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class BreakingTheRecords {

    @Test
    void test_1() {

        List<Integer> arr = new ArrayList<>();
//        arr.add(12);
//        arr.add(24);
//        arr.add(10);
//        arr.add(24);

//        arr.add(10);
//        arr.add(5);
//        arr.add(20);
//        arr.add(20);
//        arr.add(4);
//        arr.add(5);
//        arr.add(2);
//        arr.add(25);
//        arr.add(1);

//        arr.add(0);
//        arr.add(9);
//        arr.add(3);
//        arr.add(10);
//        arr.add(2);
//        arr.add(20);


        //17 45 41 60 17 41 76 43 51 40 89 92 34 6 64 7 37 81 32 50
        arr.add(17);
        arr.add(45);
        arr.add(41);
        arr.add(60);
        arr.add(17);
        arr.add(41);
        arr.add(76);
        arr.add(43);
        arr.add(51);
        arr.add(40);
        arr.add(89);
        arr.add(92);
        arr.add(34);
        arr.add(6);
        arr.add(64);
        arr.add(7);
        arr.add(37);
        arr.add(81);
        arr.add(32);
        arr.add(50);



        mainProcessor(arr);
    }

    List<Integer> mainProcessor(List<Integer> scores) {

        int min = 0;
        int minCount = 0;

        int max = 0;
        int maxCount = 0;

        boolean isInit = false;

        for (Integer s : scores) {
            //init
            if (!isInit) {
                min = s;
                max = s;

                isInit = true;
                continue;
            }


            if (s > max) {
                max = s;
                maxCount++;
                continue;
            }

            if (s < min) {
                min = s;
                minCount++;
            }

        }

        List<Integer> result = new ArrayList<>();

        result.add(maxCount);
        result.add(minCount);

        return result;
    }

}
