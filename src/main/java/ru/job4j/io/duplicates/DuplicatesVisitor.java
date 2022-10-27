package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, Path> visitedFiles = new HashMap<>();
    private final Map<FileProperty, List<Path>> allFiles = new HashMap<>();

        @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
            if (!visitedFiles.containsKey(fileProperty)) {
                List<Path> filePaths = new ArrayList<>();
                filePaths.add(file);
                visitedFiles.put(fileProperty, file);
                allFiles.put(fileProperty, filePaths);
            } else {
                allFiles.get(fileProperty).add(file);
            }
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, List<Path>> getDuplicates() {
            return allFiles.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().size() > 1)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}