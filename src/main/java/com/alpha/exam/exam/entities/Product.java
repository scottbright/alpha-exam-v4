package com.alpha.exam.exam.entities;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private String continent;

    @Column(nullable = false)
    private String multiplier;

    @Column(nullable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

}
