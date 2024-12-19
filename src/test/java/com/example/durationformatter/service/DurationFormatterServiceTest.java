package com.example.durationformatter.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurationFormatterServiceTest {

    private final DurationFormatterService formatterService = new DurationFormatterService();

    @Test
    public void testFormatDuration_zeroSeconds() {
        assertEquals("now", formatterService.formatDuration(0L));
    }

    @Test
    public void testFormatDuration_oneYear() {
        assertEquals("1 year", formatterService.formatDuration(365L * 24 * 60 * 60));
    }

    @Test
    public void testFormatDuration_multipleTimeUnits() {
        long seconds = 3662L;
        assertEquals("1 hour, 1 minute and 2 seconds", formatterService.formatDuration(seconds));
    }

    @Test
    public void testFormatDuration_onlyDays() {
        long seconds = 86400L;
        assertEquals("1 day", formatterService.formatDuration(seconds));
    }

    @Test
    public void testFormatDuration_multipleDays() {
        long seconds = 90000L;
        assertEquals("1 day and 1 hour", formatterService.formatDuration(seconds));
    }

    @Test
    public void testFormatDuration_largeDuration() {
        long seconds = 60L * 60L * 24L * 365L * 10L;
        assertEquals("10 years", formatterService.formatDuration(seconds));
    }
}
