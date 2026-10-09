package com.example.simple.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

@Service
public class FileService {

    private static final String BASE_DIR = "/tmp/reports/";

    public String readReport(String name) throws IOException {
        File base = new File(BASE_DIR).getCanonicalFile();
        File file = new File(base, name).getCanonicalFile();
        if (file.equals(base) || !file.toPath().startsWith(base.toPath())) {
            throw new IOException("Invalid file name: " + name);
        }
        return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    }
}
 
