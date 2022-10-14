package ru.job4j.io;

import java.io.*;

public class Analysis {
    public static void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            boolean down = false;
            StringBuilder downTime = new StringBuilder();
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String status = line.split(" ")[0];
                String time = line.split(" ")[1];
                if (!status.equals("200") && !down || status.equals("200") && down) {
                    downTime.append(time).append(";");
                    down = !down;
                    if (!down) {
                        out.write(downTime + System.lineSeparator());
                        downTime = new StringBuilder();
                    }
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