package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path file : sources) {
                zip.putNextEntry(new ZipEntry(file.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName jvm = ArgsName.of(args);
        Zip zip = new Zip();
        Path start = Paths.get(jvm.get("d"));
        String exclude = jvm.get("e");
        String target = jvm.get("o");
        List<Path> filesToZip = Search.search(start, p -> !p.toFile().getName().endsWith(exclude));
        zip.packFiles(filesToZip, new File(target));
    }
}