package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class SparseArrays {

    @Test
    void test_1() {

        List<String> strings = new ArrayList<>();
        strings.add("aba");
        strings.add("baba");
        strings.add("aba");
        strings.add("xzxb");


        List<String> queries = new ArrayList<>();
        queries.add("aba");
        queries.add("xzxb");
        queries.add("ab");


        mainProcessor(strings, queries);
    }

    List<Integer> mainProcessor(List<String> strings, List<String> queries) {

        List<Integer> result = new ArrayList<>();

        queries.forEach(q->{
            Integer count = ((int) strings.stream().filter(s -> s.equals(q)).count());
            result.add(count);
        });

        return result;
    }

}
