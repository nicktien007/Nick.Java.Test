package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class DivisibleSumPairs {

    @Test
    void test_1() {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);


        mainProcessor(6, 5, arr);
    }

    void mainProcessor(int n, int k, List<Integer> arr){

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j == i) {
                    continue;
                }
                Integer total = arr.get(i) + arr.get(j);
                if(total % k ==0){
                    count++;
                }
            }
        }

        System.out.println(count/2);
    }
}
