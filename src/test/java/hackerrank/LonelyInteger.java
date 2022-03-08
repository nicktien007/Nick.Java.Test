package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class LonelyInteger {

    @Test
    void test_1() {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(1);


        System.out.println(mainProcessor(arr));
    }

    int mainProcessor(List<Integer> a) {

        for (int i : a) {
            if (a.stream().filter(aa->aa.equals(i)).count()==1) {
                return i;
            }
        }

        return 0;
    }

}
