package ua.com.alevel.program.options;

import ua.com.alevel.program.Program;

import java.io.BufferedReader;
import java.io.IOException;

import static ua.com.alevel.program.Program.REPEAT;

public class EndOfLessons {
    private EndOfLessons() {
    }

    public static void show(BufferedReader reader) throws IOException {
        System.out.println("Program 'End of lessons'");
        System.out.println("Input lesson number from 1 to 10");
        String input = reader.readLine();
        switch (input) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" -> System.out.printf("Lesson %s ends at %s%n", input, getLessonEndTime(Integer.parseInt(input)));
            default -> {
                System.out.println("Wrong input");
                show(reader);
            }
        }
        System.out.println(REPEAT);
        input = reader.readLine();
        switch (input) {
            case "1" -> show(reader);
            default -> Program.run();
        }
    }

    private static String getLessonEndTime(int lesson) {
        int lessonDuration = 45;
        int lessonsStart = 9;
        int smallBreak = 5;
        int longBreak = 15;

        int summaryDuration = (lessonDuration * lesson) + (lesson / 2 * smallBreak) + (((lesson - 1) / 2) * longBreak);
        int hours = summaryDuration / 60 + lessonsStart;
        int minutes = summaryDuration % 60;
        return String.format("%s : %s", hours, minutes);
    }

}
