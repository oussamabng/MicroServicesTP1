package com.example.interlogicieltp1.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
    private String rue;
    private Integer numero;
    private String  ville;
}
