package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j

public class TSMC_Tests2 {


    @Test
    void test_2() {
//       log.info("AA");
//        System.out.println();


        List<Integer> score = new ArrayList<>();
        score.add(10);
        score.add(20);
        score.add(10);
        score.add(15);
        score.add(5);
        score.add(30);
        score.add(20);

        System.out.println(test_1_processor(score, 2, 3));
    }



    Integer test_1_processor(List<Integer> score, int team_size, int k) {

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= team_size; i++) {

            System.out.println();
            System.out.println("team_size.count = "+ i);

            System.out.println("列表成員：");
            showScores(score);

            int employees = score.size();

            //員工數少於等於k，直接選整個列表
            if (employees <= k) {
                Integer max = Collections.max(score);

                score.remove(max);
                result.add(max);
                System.out.println("整個列表選中:"+max);
                continue;
            }


            List<Integer> list1 = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                list1.add(score.get(j));
            }

            Integer max1 = Collections.max(list1);
            System.out.println("頭" + k + "個：" + max1);


            //反轉
            Collections.reverse(score);
            List<Integer> list2 = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                list2.add(score.get(j));
            }
            Integer max2 = Collections.max(list2);
            System.out.println("尾" + k + "個：" + max2);

            //轉回來
            Collections.reverse(score);

            if (max1 > max2 || max1.equals(max2)) {
                int removeIdx = score.indexOf(max1);
                score.remove(removeIdx);

//                System.out.println(removeIdx);
                System.out.println("選中:" + max1);
                result.add(max1);
            } else {
                int removeIdx = score.lastIndexOf(max2);
                score.remove(removeIdx);
//                System.out.println(removeIdx);
                System.out.println("選中:" + max2);
                result.add(max2);
            }

            System.out.println("列表剩下的成員：");
            showScores(score);
        }



        System.out.println("=====");

        System.out.print("result = ");
        result.forEach(x-> System.out.print(x+" "));
        System.out.println();

        return result.stream()
                .reduce(0, Integer::sum);
    }

    private void showScores(List<Integer> score){

        score.forEach(x->System.out.print(x + " "));
        System.out.println();
    }

}
