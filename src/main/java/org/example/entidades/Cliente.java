package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity // le digo a JPA que se trata de una entidad a persistir
@Table(name = "cliente") //le digo al JPA el nombre de la tabla - por defecto el nombre clase
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre") //por defecto nombre del atributo
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni", unique = true) //clave negocio, es única
    private int dni;

    @OneToOne(cascade = CascadeType.ALL) //acopla operaciones con domicilio CRUD
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente")
    @Builder.Default
    private Set<Factura> facturas = new HashSet<Factura>();

}
