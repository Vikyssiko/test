package com.example.test.entities.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("offline") OFFLINE,
    @JsonProperty("online") ONLINE
}
