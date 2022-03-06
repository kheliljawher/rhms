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
@Table(name ="cv")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "competance")
    private String competance;

    @ManyToOne
    private Employee employee;

    @OneToMany (mappedBy = "cv")
    private List<Section> sections;
}
