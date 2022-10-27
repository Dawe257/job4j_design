package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private final Random r;
    private boolean flag = true;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        r = new Random();
    }

    public void run() {
        String command = null;
        Scanner scanner = new Scanner(System.in);
        List<String> phrases = readPhrases();
        List<String> log = new ArrayList<>();
        while (!OUT.equals(command)) {
            command = scanner.nextLine();
            if (STOP.equals(command)) {
                flag = false;
            } else if (CONTINUE.equals(command)) {
                flag = true;
            }
            log.add(command);
            if (flag) {
                String answer = phrases.get(r.nextInt(0, 3));
                System.out.println(answer);
                log.add(answer);
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> result;
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            result = reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            for (String s : log) {
                writer.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("log.txt", "/home/dzhenetl/IdeaProjects/job4j_design/src/main/java/ru/job4j/io/answers.txt");
        cc.run();
    }
}