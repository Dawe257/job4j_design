package ru.job4j.io;

import java.io.*;

public class Analysis {
    public static void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            boolean down = false;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] arr = line.split(" ");
                if (("200").equals(arr[0]) == down) {
                    out.append(arr[1]).append(";").append(down ? System.lineSeparator() : "");
                    down = !down;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        unavailable("server.log", "result.log");
    }
}