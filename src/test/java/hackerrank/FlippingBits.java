package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

@Slf4j

public class FlippingBits {

    @Test
    void test_1() {

        System.out.println(mainProcessor(1));
    }

    private long mainProcessor(long n) {

        String s = toBinary(n);
        System.out.println(s);

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()){
            if (c == '1') {
                sb.append(0);
            }else {
                sb.append(1);
            }
//            System.out.println(c);
        }

        return Long.parseLong(sb.toString(), 2);
    }

    public static String toBinary(long x) {
        return StringUtils.leftPad(Long.toBinaryString(x), 32, '0');
    }
}
