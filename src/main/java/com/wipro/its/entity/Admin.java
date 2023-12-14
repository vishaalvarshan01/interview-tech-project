package com.wipro.its.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "email cannot be null")
    private String email;
    @NotNull(message = "password cannot be null")
    private String password;
    @NotNull(message = "type cannot be null")
    private String type;

    @OneToMany(mappedBy = "admin")
    private List<Candidate> candidates;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
