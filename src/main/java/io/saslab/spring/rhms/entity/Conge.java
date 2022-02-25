package io.saslab.spring.rhms.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="conge")
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "date_fin")
    private Date date_fin;

    @Column(name = "Type")
    private String Type;

    @Column(name = "Description")
    private String Description;

    @ManyToOne
    private Employee employee;
}
