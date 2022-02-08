package ua.com.alevel.program.options;

import ua.com.alevel.program.Program;

import java.io.BufferedReader;
import java.io.IOException;

import static ua.com.alevel.program.Program.REPEAT;

public class SumOfDigits {
    private SumOfDigits() {
    }

    public static void sum(BufferedReader reader) throws IOException {
        System.out.println("Program 'Sum of digits'");
        System.out.println("Input something");
        String input = reader.readLine();
        input = input.replaceAll("\\D",
                "");
        int sum = 0;
        for (Character digit : input.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        System.out.println("Sum = " + sum);
        System.out.println(REPEAT);
        input = reader.readLine();
        switch (input) {
            case "1" -> sum(reader);
            default -> Program.run();
        }
    }

}
