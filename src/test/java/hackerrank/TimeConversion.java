package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j

public class TimeConversion {

    @Test
    void test_1() {

        mainProcessor("12:40:22AM");
    }

    String mainProcessor(String s){

        String[] timeSplit = s.split(":");

        if (timeSplit[2].contains("AM")) {

            if (Integer.parseInt(timeSplit[0]) == 12) {
                String r = "00" + ":" + timeSplit[1] + ":" + timeSplit[2].replace("AM", "");
                System.out.println(r);
                return r;
            }

            String r = timeSplit[0] + ":" + timeSplit[1] + ":" + timeSplit[2].replace("AM", "");
            System.out.println(r);
            return r;
        }

        //PM
        int hour = Integer.parseInt(timeSplit[0]) >= 12 ? Integer.parseInt(timeSplit[0]):Integer.parseInt(timeSplit[0])+12;
        String r = hour + ":" + timeSplit[1] + ":" + timeSplit[2].replace("PM", "");
        System.out.println(r);
        return r;
    }
}
