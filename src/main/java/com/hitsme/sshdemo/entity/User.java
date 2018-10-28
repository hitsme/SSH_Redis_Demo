package com.hitsme.sshdemo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by mgl
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
