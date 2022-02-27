package io.saslab.spring.rhms.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nom")
    private String nom;


    @OneToMany (mappedBy = "equipe")
    private List<Employee> employees;

    @OneToMany (mappedBy = "equipe")
    private List<Planning> plannings;

}
