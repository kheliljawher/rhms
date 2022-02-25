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
@Table(name ="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "num_cin")
    private String num_cin;

    @Column(name = "num_tel")
    private String num_tel;

    @OneToMany (mappedBy = "employee")
    private List<Conge> conges;

    @OneToMany (mappedBy = "employee")
    private List<Cv> cvs;

    @ManyToOne
    private Equipe equipe;

}
