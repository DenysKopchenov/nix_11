package ua.com.alevel.program;

import ua.com.alevel.program.options.ReverseIndexOrSymbol;
import ua.com.alevel.program.options.ReverseWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    public static final String REPEAT = "\nRepeat input 1\nChoose an another reverse input something";
    public static final String INPUT = "Input STRING you want to reverse";
    public static final String REVERSED = "Reversed string:";

    private Program() {
    }

    public static void run() {
        showPrograms();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String program;
            while (true) {
                program = reader.readLine().toLowerCase();
                switch (program) {
                    case "1" -> {
                        System.out.println("Full string - input 1");
                        ReverseWords.reverseFullString(reader);
                    }
                    case "2" -> {
                        System.out.println("All words in string separated by whitespace - input 2");
                        ReverseWords.reverseEachWord(reader);
                    }
                    case "3" -> {
                        System.out.println("First matched word in string - input 3");
                        ReverseWords.reverseFirstMatchedWord(reader);
                    }
                    case "4" -> {
                        System.out.println("Each matched word in string - input 4");
                        ReverseWords.reverseAllMatchedWorlds(reader);
                    }
                    case "5" -> {
                        System.out.println("Start index to end of string - 5");
                        ReverseIndexOrSymbol.reverseFromIndex(reader);
                    }
                    case "6" -> {
                        System.out.println("From start to end index - 6");
                        ReverseIndexOrSymbol.reverseFromToIndex(reader);
                    }
                    case "7" -> {
                        System.out.println("From start symbol to end of string - 7");
                        ReverseIndexOrSymbol.reverseFromSymbol(reader);
                    }
                    case "8" -> {
                        System.out.println("From start symbol to end symbol - 8");
                        ReverseIndexOrSymbol.reverseFromToSymbol(reader);
                    }
                    case "9" -> {
                        System.out.println("From start word (sequence) to end of string - 9");
                        ReverseWords.reverseFromWord(reader);
                    }
                    case "10" -> {
                        System.out.println("Reverse from start word (sequence) to end word (sequence) - 10");
                        ReverseWords.reverseFromToWord(reader);
                    }
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
        System.out.println("Choose reverse");
        System.out.println("~~~~~~~~~~~~~~");
        System.out.println("Full string - input 1");
        System.out.println("All words in string separated by whitespace - input 2");
        System.out.println("First matched word in string - input 3");
        System.out.println("Each matched word in string - input 4");
        System.out.println("Start index to end of string - 5");
        System.out.println("From start to end index - 6");
        System.out.println("From start symbol to end of string - 7");
        System.out.println("From start symbol to end symbol - 8");
        System.out.println("From start word (sequence) to end of string - 9");
        System.out.println("Reverse from start word (sequence) to end word (sequence) - 10");
        System.out.println("Exit - input exit");
        System.out.println("~~~~~~~~~~~~~~");
    }
}
