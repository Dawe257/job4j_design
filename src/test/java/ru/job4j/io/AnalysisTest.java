package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    void unavailable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("200 11:02:02");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        List<String> result;
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            result = in.lines().toList();
        }
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo("10:57:01;11:02:02;");
    }
}