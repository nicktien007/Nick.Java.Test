package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Slf4j

public class CountingSort_1 {

    @Test
    void test_1() {

        List<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(1);


        System.out.println(mainProcessor(arr));
    }

    private List<Integer> mainProcessor(List<Integer> arr) {

        Integer max = arr.stream().max(Integer::compareTo).get();


//        Map<Integer, Integer> map = new HashMap<>();
//
//        IntStream.range(0, 100).forEach(x->{
//            map.put(x, 0);
//        });


        Map<Integer, Integer> map = new HashMap<>();

        IntStream.range(0, max + 1).forEach(x->{
            map.put(x, 0);
        });


        arr.forEach(x->{
            if(map.containsKey(x)){
                Integer k = map.get(x);

                map.put(x, ++k);
            }
        });

        return new ArrayList<>(map.values());
    }
}
