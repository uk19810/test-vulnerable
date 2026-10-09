package com.example.simple.service;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class PingService {

    public String ping(String host) throws IOException {
        String target = host.trim();
        if (target.startsWith("-")) {
            throw new IllegalArgumentException("Invalid host");
        }
        String[] command = {"ping", "-c", "1", target};
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append(System.lineSeparator());
        }
        reader.close();
        return output.toString();
    }
}
