package io.saslab.spring.rhms.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="planning")
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "plan_Jour")
    private Date plan_Jour;

    @Column(name = "plan_Semaine")
    private Date plan_Semaine;

    @Column(name = "plan_Mois")
    private Date plan_Mois;

    @Column(name = "plan_Annee")
    private Date plan_Annee;

    @Column(name = "horaire_Plan")
    private Date horaire_Plan;

    @ManyToOne
    private Employee employee;

    @OneToMany (mappedBy = "planning")
    private List<Departement> departements;

    @ManyToOne
    private Equipe equipe;

}
