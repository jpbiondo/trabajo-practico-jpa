package org.example;


import javax.persistence.*;
import lombok.*;

//JPA Decorators
@Entity
//Lombok Decorators
@Builder
@Getter
@Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

}
