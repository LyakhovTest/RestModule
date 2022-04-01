package com.example.restmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;

@Data
@AllArgsConstructor
public class CreateUserDto {
        private String name;
        private String email;
        private int account;
}
