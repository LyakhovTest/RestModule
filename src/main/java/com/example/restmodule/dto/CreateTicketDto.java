package com.example.restmodule.dto;

import com.example.restmodule.entity.Category;
import com.example.restmodule.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTicketDto {
    private int eventId;
    private int userId;
    private Category category;
    private int place;
    private int cost;
}
