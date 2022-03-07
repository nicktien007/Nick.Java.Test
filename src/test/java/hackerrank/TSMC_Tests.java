package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j

public class TSMC_Tests {


    private Map<String,Integer> map = initMap();

    @Test
    void test_1() {
//       log.info("AA");
//        System.out.println();




        test_1_processor("asdf");
    }

    private Map<String,Integer> initMap(){
        Map<String,Integer> m = new HashMap<>();
        m.put("ab",1);
        m.put("cde",2);
        m.put("fgh",3);
        m.put("ijk",4);
        m.put("lmn",5);
        m.put("opq",6);
        m.put("rst",7);
        m.put("uvw",8);
        m.put("xyz",9);

        return m;
    }


    void test_1_processor(String input_str){

        //總長
        int totalLength = input_str.length();

        //一開始取一個字
        int startLength = 1;

//        input_str.toCharArray(
//        String a = input_str.substring(1);
//        log.info(a);

        for (int i = startLength;i<=totalLength;i++){
            log.info(getStringByStartIndex(input_str,totalLength,i));
        }


        for (char c : input_str.toCharArray()) {

//            map.forEach((k, v) -> {
//                if (k.contains(String.valueOf(c))) {
//                    log.info(v.toString());
//                }
//
//            });

//            System.out.println(c);
        }

    }

    private String getStringByStartIndex(String input_str,int totalLength, int startLength ){

        return  reverseString(reverseString(input_str).substring(totalLength-startLength));

    }

    private String reverseString(String str){
        String nstr="";
        char ch;

        for (int i=0; i<str.length(); i++)
        {
            ch = str.charAt(i); //extracts each character
            nstr = ch+nstr; //adds each character in front of the existing string
        }

        return nstr;
    }
}
