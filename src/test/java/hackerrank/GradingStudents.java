package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class GradingStudents {

    @Test
    void test_1() {

        List<Integer> arr = new ArrayList<>();
//        arr.add(84);
//        arr.add(29);
//        arr.add(57);
        arr.add(10);


        System.out.println(mainProcessor(arr));
    }

    List<Integer> mainProcessor(List<Integer> grades) {

        List<Integer> result = new ArrayList<>();

        grades.forEach(g -> {

            if (g <= 40) {

                if (g >= 38) {
                    result.add(40);
                    return;
                }

                result.add(g);
                return;
            }

            if (g == 100 || g == 99 || g == 98) {
                result.add(100);
                return;
            }

            if (g % 10 == 0) {
                result.add(g);
                return;
            }

            if (g % 10 == 1) {
                Integer roundGrade = g + 4;

                if (roundGrade - g < 3) {
                    result.add(roundGrade);
                    return;
                }

                result.add(g);
            }

            if (g % 10 == 2) {
                Integer roundGrade = g + 3;

                if (roundGrade - g < 3) {
                    result.add(roundGrade);
                    return;
                }

                result.add(g);
            }

            if (g % 10 == 3) {
                Integer roundGrade = g + 2;

                if (roundGrade - g < 3) {
                    result.add(roundGrade);
                    return;
                }

                result.add(g);
            }

            if (g % 10 == 4) {
                Integer roundGrade = g + 1;

                if (roundGrade - g < 3) {
                    result.add(roundGrade);
                    return;
                }

                result.add(g);
            }

            if (g % 10 == 5) {
                result.add(g);
            }

            if (g % 10 == 6) {
                Integer roundGrade = g + 4;

                if (roundGrade - g < 3) {
                    result.add(roundGrade);
                    return;
                }

                result.add(g);
            }

            if (g % 10 == 7) {
                Integer roundGrade = g + 3;

                if (roundGrade - g < 3) {
                    result.add(roundGrade);
                    return;
                }

                result.add(g);
            }

            if (g % 10 == 8) {
                Integer roundGrade = g + 2;

                if (roundGrade - g < 3) {
                    result.add(roundGrade);
                    return;
                }

                result.add(g);
            }

            if (g % 10 == 9) {
                Integer roundGrade = g + 1;

                if (roundGrade - g < 3) {
                    result.add(roundGrade);
                    return;
                }

                result.add(g);
            }
        });

        return result;
    }

}
