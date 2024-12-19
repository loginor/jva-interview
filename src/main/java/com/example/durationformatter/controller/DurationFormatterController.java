package com.example.durationformatter.controller;

import com.example.durationformatter.service.DurationFormatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/duration")
public class DurationFormatterController {

    @Autowired
    private DurationFormatterService formatterService;

    @GetMapping("/{seconds}")
    public String getFormattedDuration(@PathVariable long seconds) {
        return formatterService.formatDuration(seconds);
    }
}
