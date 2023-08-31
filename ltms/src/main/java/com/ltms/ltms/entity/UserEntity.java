package com.ltms.ltms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//ORM
@Table(name= "user-entity")
@Data //getter setter
@AllArgsConstructor //no need write constructors
@NoArgsConstructor //default constructors
@Builder
public class UserEntity {

    @Id
    private Long id;
    private String name;
    private String password;
    private String email;
    private double balance;
}
