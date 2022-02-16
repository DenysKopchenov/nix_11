package ua.com.alevel.program.options;

import ua.com.alevel.StringReverseUtil;

import java.io.BufferedReader;
import java.io.IOException;

import static ua.com.alevel.program.Program.*;

public class ReverseWords {
    public static void reverseFullString(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        String result = StringReverseUtil.reverse(input);
        System.out.println(REVERSED);
        System.out.println(result);

        System.out.println(REPEAT);
        input = reader.readLine();
        if ("1".equals(input)) {
            reverseFullString(reader);
        } else {
            run();
        }
    }

    public static void reverseEachWord(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println(REVERSED);
        System.out.println(StringReverseUtil.reverseEachWord(input));

        System.out.println(REPEAT);
        input = reader.readLine();
        if ("1".equals(input)) {
            reverseEachWord(reader);
        } else {
            run();
        }
    }

    public static void reverseFirstMatchedWord(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println("Input WORD you want to reverse (must be a single word)");
        String word = reader.readLine();
        try {
            String result = StringReverseUtil.reverseFirstMatchedWord(input, word);
            System.out.println(REVERSED);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(REPEAT);
            input = reader.readLine();
            if ("1".equals(input)) {
                reverseFirstMatchedWord(reader);
            } else {
                run();
            }
        }
    }

    public static void reverseAllMatchedWorlds(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println("Input WORD you want to reverse (must be a single word)");
        String word = reader.readLine();
        try {
            String result = StringReverseUtil.reverseAllMatchedWord(input, word);
            System.out.println(REVERSED);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(REPEAT);
            input = reader.readLine();
            if ("1".equals(input)) {
                reverseAllMatchedWorlds(reader);
            } else {
                run();
            }
        }
    }

    public static void reverseFromWord(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println("Input START WORD or SEQUENCE you want to reverse");
        String word = reader.readLine();

        try {
            String result = StringReverseUtil.reverseFromWord(input, word);
            System.out.println(REVERSED);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(REPEAT);
            input = reader.readLine();
            if ("1".equals(input)) {
                reverseFromWord(reader);
            } else {
                run();
            }
        }
    }

    public static void reverseFromToWord(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println("Input START WORD or SEQUENCE you want to reverse");
        String start = reader.readLine();
        System.out.println("Input START WORD or SEQUENCE you want to reverse");
        String end = reader.readLine();

        try {
            String result = StringReverseUtil.reverseFromToWord(input, start, end);
            System.out.println(REVERSED);
            System.out.println(result);
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        } finally {
            System.out.println(REPEAT);
            input = reader.readLine();
            if ("1".equals(input)) {
                reverseFromToWord(reader);
            } else {
                run();
            }
        }
    }
}
