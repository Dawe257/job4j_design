package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            printTable(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printTable(OutputStream out) throws IOException {
        for (int i = 1; i < 10; i++) {
            out.write(("1 * " + i + " = " + (1 * i) + System.lineSeparator()).getBytes());
        }
    }
}