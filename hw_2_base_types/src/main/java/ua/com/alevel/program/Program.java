package ua.com.alevel.program;

import ua.com.alevel.program.options.EndOfLessons;
import ua.com.alevel.program.options.LetterRepeats;
import ua.com.alevel.program.options.SumOfDigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    public static final String REPEAT = "\nRepeat input 1\nChoose an another program input something";

    private Program() {
    }

    public static void run() {
        showPrograms();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String program;
            while (true) {
                program = reader.readLine().toLowerCase();
                switch (program) {
                    case "1" -> SumOfDigits.sum(reader);
                    case "2" -> LetterRepeats.countRepeats(reader);
                    case "3" -> EndOfLessons.show(reader);
                    case "exit" -> System.exit(0);
                    default -> {
                        System.out.println("Wrong input");
                        showPrograms();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showPrograms() {
        System.out.println("Choose program");
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("Sum of digits - input 1");
        System.out.println("Letter repeats - input 2");
        System.out.println("End of lessons - input 3");
        System.out.println("Exit - input exit");
        System.out.println("~~~~~~~~~~~~~~");
    }
}
