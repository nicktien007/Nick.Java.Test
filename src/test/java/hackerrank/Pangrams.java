package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Slf4j

public class Pangrams {

    @Test
    void test_1() {

        System.out.println(mainProcessor("We promptly judged antique ivory buckles for the next prize"));
    }

    private String mainProcessor(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 0);
        map.put("c", 0);
        map.put("d", 0);
        map.put("e", 0);
        map.put("f", 0);
        map.put("g", 0);
        map.put("h", 0);
        map.put("i", 0);
        map.put("j", 0);
        map.put("k", 0);
        map.put("l", 0);
        map.put("m", 0);
        map.put("n", 0);
        map.put("o", 0);
        map.put("p", 0);
        map.put("q", 0);
        map.put("r", 0);
        map.put("s", 0);
        map.put("t", 0);
        map.put("u", 0);
        map.put("v", 0);
        map.put("w", 0);
        map.put("x", 0);
        map.put("y", 0);
        map.put("z", 0);

        for (char c : s.toLowerCase(Locale.ROOT).toCharArray()) {
            if (c == ' ') {
                continue;
            }

            Integer total = map.get(String.valueOf(c));
            map.put(String.valueOf(c), ++total);
        }

        long result = map.values().stream().filter(x -> x.equals(0)).count();

        return result == 0 ? "pangram" : "not pangram";
    }
}
