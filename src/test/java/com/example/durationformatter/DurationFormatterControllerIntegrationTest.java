package com.example.durationformatter;


import com.example.durationformatter.service.DurationFormatterService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class DurationFormatterControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DurationFormatterService formatterService;

    @Test
    public void testGetFormattedDuration_validInput() throws Exception {
        long seconds = 3662L;
        String expectedOutput = "1 hour, 1 minute and 2 seconds";

        when(formatterService.formatDuration(seconds)).thenReturn(expectedOutput);

        mockMvc.perform(get("/api/duration/{seconds}", seconds))
                .andExpect(status().isOk()) // HTTP status 200
                .andExpect(content().string(expectedOutput)); // Response body
    }

    @Test
    public void testGetFormattedDuration_invalidInput() throws Exception {
        mockMvc.perform(get("/api/duration/{seconds}", "invalid"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid input: Please provide a valid number within the range of a long integer."));
    }

    @Test
    public void testGetFormattedDuration_zeroSeconds() throws Exception {
        long seconds = 0L;
        String expectedOutput = "now";

        when(formatterService.formatDuration(seconds)).thenReturn(expectedOutput);

        mockMvc.perform(get("/api/duration/{seconds}", seconds))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }
}