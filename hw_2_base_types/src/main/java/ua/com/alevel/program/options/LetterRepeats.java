package ua.com.alevel.program.options;

import ua.com.alevel.program.Program;

import java.io.BufferedReader;
import java.io.IOException;

import static ua.com.alevel.program.Program.REPEAT;

public class LetterRepeats {
    private LetterRepeats() {
    }

    public static void countRepeats(BufferedReader reader) throws IOException {
        System.out.println("Program 'Letter repeats'");
        System.out.println("Input something");
        String input = reader.readLine();
        input = input.replaceAll("[^A-Za-z_А-Яа-яІЇЄіїє]", "");
        int[] repeats = new int[1280];
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            repeats[letter] += 1;
        }
        for (int i = 0; i < repeats.length; i++) {
            if (repeats[i] > 0) {
                System.out.println((char) i + " - " + repeats[i]);
            }
        }
        System.out.println(REPEAT);
        input = reader.readLine();
        switch (input) {
            case "1" -> countRepeats(reader);
            default -> Program.run();
        }
    }
}
