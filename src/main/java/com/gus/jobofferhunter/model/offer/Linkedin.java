package com.gus.jobofferhunter.model.offer;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("linkedin")
public class Linkedin extends JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String branch;
    private String formOfEmployment;
    private String experience;
    private String duties;
    @Lob
    private String description;

    public Linkedin() {
    }
}
