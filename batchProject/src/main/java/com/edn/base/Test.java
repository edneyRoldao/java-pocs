package com.edn.base;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException {
        write();
//        read();
    }

    private static void read() throws IOException {
        Set<String> lines = new HashSet<>();
        Set<Path> paths = getFiles("/home/edney/Downloads/dootax");
        System.out.println(paths.size());
        for (Path p : paths) {
            BufferedReader reader = Files.newBufferedReader(p);
            Set<String> linesRead = reader.lines().collect(Collectors.toSet());
            lines.addAll(linesRead);
            System.out.println(lines.size());
        }
    }

    private static Set<Path> getFiles(String directoryPath) throws IOException {
        try(Stream<Path> stream = Files.walk(Paths.get(directoryPath), 1)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .collect(Collectors.toSet());
        }
    }


    private static void write() throws IOException {
        for (int m = 0; m < 1500; m++) {
            String fileName = String.format("/home/edney/Downloads/dootax/teste%s.txt", m);
            StringBuilder value = new StringBuilder("");

            Random r = new Random();
            for (int i = 0; i < 9_000; i++) {
                for (int j = 0; j < 48; j++) {
                    if (j == 4) {
                        value.append(";");
                    }
                    value.append(r.nextInt(10));
                }
                value.append("\n");
            }

            FileOutputStream outputStream = new FileOutputStream(fileName);
            byte[] strToBytes = value.toString().getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        }
    }

}
