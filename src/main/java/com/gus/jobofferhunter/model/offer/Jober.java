package com.gus.jobofferhunter.model.offer;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
public class Jober extends JobOffer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
