package com.example.simple.service;

import com.example.simple.model.ReportSettings;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

@Service
public class SettingsService {

    public ReportSettings importSettings(String yaml) {
        Yaml parser = new Yaml(new Constructor(ReportSettings.class));
        return parser.load(yaml);
    }
}
