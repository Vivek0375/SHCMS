package com.vivek.shcms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // ✅ This generates getters/setters for all fields
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

}


