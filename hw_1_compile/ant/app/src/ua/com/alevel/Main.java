package ua.com.alevel;

import ua.com.alevel.imports.CollectionsIo;
import ua.com.alevel.imports.LangText;
import ua.com.alevel.imports.MathPool;

public class Main {
    public static void main(String[] args) {
        System.out.println("ANT build");
        new CollectionsIo().start();
        new LangText().start();
        new MathPool().start();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
