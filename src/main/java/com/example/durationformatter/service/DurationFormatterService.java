package com.example.durationformatter.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DurationFormatterService {

    public String formatDuration(long seconds) {  // Change to long
        if (seconds == 0) {
            return "now";
        }

        // Define time units in a map
        Map<String, Long> timeUnits = new LinkedHashMap<>();  // Change to Long
        timeUnits.put("year", 365L * 24 * 60 * 60);  // Ensure long literals
        timeUnits.put("day", 24L * 60 * 60);  // Ensure long literals
        timeUnits.put("hour", 60L * 60);  // Ensure long literals
        timeUnits.put("minute", 60L);  // Ensure long literals
        timeUnits.put("second", 1L);  // Ensure long literals

        // Calculate the time components
        List<String> components = new ArrayList<>();
        for (Map.Entry<String, Long> entry : timeUnits.entrySet()) {
            String unitName = entry.getKey();
            long unitValue = entry.getValue();
            long value = seconds / unitValue;
            if (value > 0) {
                components.add(value + " " + unitName + (value > 1 ? "s" : ""));
                seconds %= unitValue;
            }
        }

        // Join components with proper formatting
        if (components.size() == 1) {
            return components.get(0);
        } else {
            String lastComponent = components.remove(components.size() - 1);
            return String.join(", ", components) + " and " + lastComponent;
        }
    }
}