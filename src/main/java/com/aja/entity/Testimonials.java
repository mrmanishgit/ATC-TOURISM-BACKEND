package com.aja.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Testimonials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer rating;

    private String review;

    private String packageName;   // ✅ ONLY THIS

    private String image;

    private boolean isFlag = true;

    // -------- Relationships --------
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
