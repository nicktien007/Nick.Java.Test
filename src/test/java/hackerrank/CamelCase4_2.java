package hackerrank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j

public class CamelCase4_2 {

    @Test
    void testCase1() {

        //plastic cup
        String input = "S;M;plasticCup()";

        String[] inputSplits = input.split(";");

        String output = "";

        if (inputSplits[0].equals("S") && inputSplits[1].equals("M")) {
            output = inputSplits[2];
            String r = SM_Process(output);
            System.out.println(r);

        }
    }

    private String SM_Process(String str){
        StringBuilder result = new StringBuilder();

        int i = 0;
        while(i < str.length()){
            char chr = str.charAt(i);
            if(Character.isUpperCase(chr)){
                result.append(' ');
                result.append(Character.toLowerCase(chr));

                i++;
                continue;
            }



            result.append(chr);
            i++;
        }

        return result.toString().replace("()","");
    }

    @Test
    void testCase2() {

        //mobilePhone
        String input = "C;V;mobile phone";

        String[] inputSplits = input.split(";");

        String output = "";

        if (inputSplits[0].equals("C") && inputSplits[1].equals("V")) {

            output = inputSplits[2];
            String r = CV_Process(output);
            System.out.println(r);

        }
    }

    private String CV_Process(String str){
        StringBuilder result = new StringBuilder();

        int i = 0;
        boolean nextIsUpperCase = false;

        while(i < str.length()){
            char chr = str.charAt(i);
            if(chr == ' '){

                i++;
                nextIsUpperCase = true;
                continue;
            }

            if (nextIsUpperCase) {
                result.append(Character.toUpperCase(chr));

                i++;
                nextIsUpperCase = false;
                continue;
            }

            result.append(chr);
            i++;
        }

        return result.toString().replace("()","");
    }

    @Test
    void testCase3() {

        //CoffeeMachine
        String input = "C;C;coffee machine";

        String[] inputSplits = input.split(";");

        String output = "";

        if (inputSplits[0].equals("C") && inputSplits[1].equals("C")) {

            output = inputSplits[2];
            String r = CC_Process(output);
            System.out.println(r);

        }
    }

    private String CC_Process(String str){
        StringBuilder result = new StringBuilder();

        int i = 0;
        //第一個字大寫
        boolean nextIsUpperCase = true;

        while(i < str.length()){
            char chr = str.charAt(i);
            if(chr == ' '){

                i++;
                nextIsUpperCase = true;
                continue;
            }

            if (nextIsUpperCase) {
                result.append(Character.toUpperCase(chr));

                i++;
                nextIsUpperCase = false;
                continue;
            }

            result.append(chr);
            i++;
        }

        return result.toString().replace("()","");
    }

    @Test
    void testCase4() {

        //large software book
        String input = "S;C;LargeSoftwareBook";

        String[] inputSplits = input.split(";");

        String output = "";

        if (inputSplits[0].equals("S") && inputSplits[1].equals("C")) {

            output = inputSplits[2];
            String r = SC_Process(output);
            System.out.println(r);
        }
    }

    private String SC_Process(String str){
        StringBuilder result = new StringBuilder();

        int i = 0;

        while(i < str.length()){
            char chr = str.charAt(i);
            if(Character.isUpperCase(chr) && i != 0){

                result.append(' ');
                result.append(Character.toLowerCase(chr));

                i++;
                continue;
            }

            result.append(Character.toLowerCase(chr));
            i++;
        }

        return result.toString().replace("()","");
    }

    @Test
    void testCase5() {

        //whiteSheetOfPaper()
//        String input = "C;M;white sheet of paper";

        //mousePad()
        String input = "C;M;mouse pad";

        String[] inputSplits = input.split(";");

        String output = "";

        if (inputSplits[0].equals("C") && inputSplits[1].equals("M")) {

            output = inputSplits[2];
            String r = CM_Process(output);
            System.out.println(r);
        }
    }

    private String CM_Process(String str){
        StringBuilder result = new StringBuilder();

        int i = 0;
        //第一個字大寫
        boolean nextIsUpperCase = false;

        while(i < str.length()){
            char chr = str.charAt(i);
            if(chr == ' '){

                i++;
                nextIsUpperCase = true;
                continue;
            }

            if (nextIsUpperCase) {
                result.append(Character.toUpperCase(chr));

                i++;
                nextIsUpperCase = false;
                continue;
            }

            result.append(chr);
            i++;
        }

        return result.toString() + "()";
    }

    @Test
    void testCase6() {

        //picture frame
        String input = "S;V;pictureFrame";

        String[] inputSplits = input.split(";");

        String output = "";

        if (inputSplits[0].equals("S") && inputSplits[1].equals("V")) {

            output = inputSplits[2];
            String r = SV_Process(output);
            System.out.println(r);
        }
    }

    private String SV_Process(String str){
        StringBuilder result = new StringBuilder();

        int i = 0;

        while(i < str.length()){
            char chr = str.charAt(i);
            if(Character.isUpperCase(chr) && i != 0){

                result.append(' ');
                result.append(Character.toLowerCase(chr));

                i++;
                continue;
            }

            result.append(Character.toLowerCase(chr));
            i++;
        }

        return result.toString().replace("()","");
    }
}
