package com.ltms.ltms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//ORM
@Table(name= "bus-entity")
@Data //getter setter
@AllArgsConstructor //no need write constructors
@NoArgsConstructor //default constructors
@Builder
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//ID generator
    private Long id;
    private String name;
    private Double price;
    private String route;
}
