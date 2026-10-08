package com.example.simple.service;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class PingService {

    public String ping(String host) throws IOException {
        if (host == null || !host.matches("[A-Za-z0-9.\\-]+")) {
            throw new IllegalArgumentException("Invalid host: " + host);
        }
        Process process = Runtime.getRuntime().exec(new String[] {"ping", "-c", "1", host});
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
