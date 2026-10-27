package com.example.simple.controller;

import com.example.simple.model.ReportSettings;
import com.example.simple.service.SettingsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @PostMapping("/import")
    public String importSettings(@RequestBody String yaml) {
        ReportSettings settings = settingsService.importSettings(yaml);
        return settings.getTitle();
    }
}
