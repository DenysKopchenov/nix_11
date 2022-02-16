package ua.com.alevel.program.options;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.StringReverseUtil;

import java.io.BufferedReader;
import java.io.IOException;

import static ua.com.alevel.program.Program.*;

public class ReverseIndexOrSymbol {

    public static void reverseFromIndex(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println("Input START INDEX of reverse (must be numeric)");
        String start = reader.readLine();
        if (StringUtils.isNumeric(start)) {
            int from = Integer.parseInt(start);
            if (from < input.length() && from >= 0) {
                System.out.println(REVERSED);
                System.out.println(StringReverseUtil.reverseFromIndex(input, from));
                System.out.println(REPEAT);
                input = reader.readLine();
                if ("1".equals(input)) {
                    reverseFromIndex(reader);
                } else {
                    run();
                }
            } else {
                System.out.println("Index can not be negative or more then input string length");
                reverseFromIndex(reader);
            }
        } else {
            System.out.println("Wrong input");
            reverseFromIndex(reader);
        }
    }

    public static void reverseFromToIndex(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println("Input START INDEX of reverse (must be numeric)");
        String start = reader.readLine();
        System.out.println("Input END INDEX of reverse (must be numeric)");
        String end = reader.readLine();

        if (StringUtils.isNumeric(start) && StringUtils.isNumeric(end)) {
            int from = Integer.parseInt(start);
            int to = Integer.parseInt(end);
            if ((from < input.length() && from > 0) && (to < input.length() && to > from)) {
                System.out.println(REVERSED);
                System.out.println(StringReverseUtil.reverseFromToIndex(input, from, to));
                System.out.println(REPEAT);
                input = reader.readLine();
                if ("1".equals(input)) {
                    reverseFromToIndex(reader);
                } else {
                    run();
                }
            } else {
                System.out.println("START can not be negative or more then input string length, END can not be less than start");
                reverseFromToIndex(reader);
            }
        } else {
            System.out.println("Wrong input");
            reverseFromToIndex(reader);
        }
    }

    public static void reverseFromSymbol(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println("Input START SYMBOL of reverse (must be a single character)");
        String start = reader.readLine();

        if (start.length() == 1) {
            try {
                String result = StringReverseUtil.reverseFromSymbol(input, start);
                System.out.println(REVERSED);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(REPEAT);
                input = reader.readLine();
                if ("1".equals(input)) {
                    reverseFromSymbol(reader);
                } else {
                    run();
                }
            }
        } else {
            System.out.println("Wrong input");
            reverseFromSymbol(reader);
        }
    }


    public static void reverseFromToSymbol(BufferedReader reader) throws IOException {
        System.out.println(INPUT);
        String input = reader.readLine();
        System.out.println("Input START SYMBOL of reverse (must be a single character)");
        String start = reader.readLine();
        System.out.println("Input END SYMBOL of reverse (must be a single character)");
        String end = reader.readLine();

        if ((start.length() == 1) && (end.length() == 1)) {
            try {
                String result = StringReverseUtil.reverseFromToSymbol(input, start, end);
                System.out.println(REVERSED);
                System.out.println(result);
            } catch (Exception e) {
                System.out.printf("'%s' does not contains symbol '%s'%n", input, start);
            } finally {
                System.out.println(REPEAT);
                input = reader.readLine();
                if ("1".equals(input)) {
                    reverseFromToSymbol(reader);
                } else {
                    run();
                }
            }
        } else {
            System.out.println("Wrong input");
            reverseFromToSymbol(reader);
        }
    }
}
