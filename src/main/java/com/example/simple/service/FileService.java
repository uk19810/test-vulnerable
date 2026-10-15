package com.example.simple.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

@Service
public class FileService {

    private static final String BASE_DIR = "/tmp/reports/";

    public String readReport(String name) throws IOException {
        File file = new File(BASE_DIR + name);
        return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    }
}
 
