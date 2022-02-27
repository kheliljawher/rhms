package io.saslab.spring.rhms.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nom_dep")
    private String nom_dep;

    @ManyToOne
    private Employee employee;

}