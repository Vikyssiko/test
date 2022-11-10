package com.example.test.entities;

import com.example.test.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @JsonProperty(value = "status")
    private Status status;
    private String name;
    private String image;

    public User(final String email,
                final String name) {
        this.email = email;
        this.name = name;;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
