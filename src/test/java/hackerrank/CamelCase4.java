package hackerrank;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Slf4j

public class CamelCase4 {

    private Scanner scanner;
    private PrintStream printStream;

    public CamelCase4(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Enter:");

        while (scanner.hasNext()){
            String input = scanner.nextLine();


            String[] inputSplits = input.split(";");
            String output = "";
            if (inputSplits[0].equals("S") && inputSplits[1].equals("M")) {
                output = inputSplits[2];
                String r = SM_Process(output);
                System.out.println(r);

            }

//            printStream.println("output: " + (input));
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

    public static void main(String[] args) {
        CamelCase4 camelCase4 = new CamelCase4(System.in, System.out);
        camelCase4.start();
    }
}
