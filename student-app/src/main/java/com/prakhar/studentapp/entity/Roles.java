package com.prakhar.studentapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "roles")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Roles {

    @Id
    @GeneratedValue
    private Long id;
    private String role;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> user;
}
