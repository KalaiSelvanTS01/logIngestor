package com.log_ingestor;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/logs")
// public class LogController {

//     @PostMapping
//     public String ingestLog(@RequestBody String logData) {
//         // Implement log ingestion logic here
//         System.out.println("Received log data: " + logData);
//         return "Log ingested successfully!";
//     }
// }

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/logs")
public class LogController {

    private final ObjectMapper objectMapper;
    private final List<LogEntry> logEntryList;

    @Autowired
    public LogController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.logEntryList = new ArrayList<>();
    }

    @PostMapping
    public String ingestLog(@RequestBody String logData) {
        try {
            // Parse JSON into LogEntry object
            LogEntry log = objectMapper.readValue(logData, LogEntry.class);

            // Store log data (replace with database logic in a real project)
            logEntryList.add(log);

            // Example: print log details
            System.out.println("Received log data:");
            System.out.println("Level: " + log.getLevel());
            System.out.println("Message: " + log.getMessage());
            // Add more fields as needed

            return "Log ingested successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error ingesting log.";
        }
    }

    @GetMapping
    public List<LogEntry> getAllLogs() {
        // Return all logs
        return logEntryList;
    }

    // @GetMapping("/search")
    // public List<LogEntry> searchLogs(@RequestParam("level") String level) {
    //     // Search logs by level
    //     return logEntryList.stream()
    //             .filter(log -> log.getLevel().equalsIgnoreCase(level))
    //             .collect(Collectors.toList());
    // }
    public List<LogEntry> searchLogs(@RequestParam("level") String level) {
    final String finalLevel = level; // declare it as final
    return logEntryList.stream()
            .filter(log -> log.getLevel().equalsIgnoreCase(finalLevel))
            .collect(Collectors.toList());
}

}