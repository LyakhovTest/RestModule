package com.example.restmodule.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

@Data
@AllArgsConstructor
public class CreateEventDto {
    private String title;
    private String place;
    private String speaker;
    private String eventType;
    private Instant dateTime;
}
