package org.bsuir.lab8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Reader {

    public List<String> readFileToList(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }
}