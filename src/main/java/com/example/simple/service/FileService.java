package com.example.simple.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

@Service
public class FileService {

    private static final String BASE_DIR = "/tmp/reports/";

    public String readReport(String name) throws IOException {
      Path base = Paths.get(BASE_DIR).toRealPath();
      Path file = base.resolve(name).toRealPath();
      if (file.equals(base) || !file.startsWith(base)) {
          throw new IOException("Invalid file name: " + name);
      }
      return new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
  }
}
