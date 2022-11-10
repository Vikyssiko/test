package com.example.test.dto;

import com.example.test.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
public class StatusDto {
    @Getter
    @JsonProperty(value = "status")
    private Status status;
}
