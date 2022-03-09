package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class DividedMatrix {

    @Test
    void test_1() {

        List<List<Long>> arr = new ArrayList<>();

        List<Long> a1 = new ArrayList<>();
        a1.add(7L);
        a1.add(11L);
        a1.add(9L);
        a1.add(9L);
        a1.add(11L);
        a1.add(3L);
        arr.add(a1);

        List<Long> a2 = new ArrayList<>();
        a2.add(8L);
        a2.add(9L);
        a2.add(3L);
        a2.add(4L);
        a2.add(0L);
        a2.add(13L);
        arr.add(a2);

        List<Long> a3 = new ArrayList<>();
        a3.add(3L);
        a3.add(10L);
        a3.add(4L);
        a3.add(14L);
        a3.add(3L);
        a3.add(7L);
        arr.add(a3);

        List<Long> a4 = new ArrayList<>();
        a4.add(4L);
        a4.add(15L);
        a4.add(5L);
        a4.add(6L);
        a4.add(3L);
        a4.add(9L);
        arr.add(a4);

        List<Long> a5 = new ArrayList<>();
        a5.add(3L);
        a5.add(12L);
        a5.add(3L);
        a5.add(12L);
        a5.add(8L);
        a5.add(0L);
        arr.add(a5);

        List<Long> a6 = new ArrayList<>();
        a6.add(17L);
        a6.add(4L);
        a6.add(2L);
        a6.add(4L);
        a6.add(14L);
        a6.add(3L);
        arr.add(a6);

        System.out.println(mainProcessor(arr));
    }

    private List<Long> mainProcessor(List<List<Long>> arr) {


        return new ArrayList<>();
    }
}
