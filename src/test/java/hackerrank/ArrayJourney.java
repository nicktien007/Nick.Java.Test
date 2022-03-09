package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class ArrayJourney {

    @Test
    void test_1() {

        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(2);
        arr.add(-10);
        arr.add(5);
        arr.add(20);


        System.out.println(mainProcessor(arr,2));
    }

    long mainProcessor(List<Integer> path, int maxStep) {

        int step = 1;
//        for (int i = 0; i < path.size(); i++) {
//            System.out.println(path.get(i));
//        }

        for (int s = 0; s < maxStep; s++) {
            for (int i = 0; i <= s; i++) {
                System.out.println(path.get(i));
//                System.out.println(s+","+i);
            }
            System.out.println();
        }



        return 0;
    }

}
