package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), duplicatesVisitor);
        Map<FileProperty, List<Path>> duplicates = duplicatesVisitor.getDuplicates();
        duplicates.forEach((key, value) -> {
            System.out.printf("%s - %d\n", key.getName(), key.getSize());
            value.forEach(p -> System.out.printf("\t%s\n", p));
        });
    }
}