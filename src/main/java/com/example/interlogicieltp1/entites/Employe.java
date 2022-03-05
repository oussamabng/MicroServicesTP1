package com.example.interlogicieltp1.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeId;

    @Column(nullable = false,length = 20)
    private String employeName;

    @Enumerated(EnumType.STRING)
    private Genre employeGender;

    private Date employeDate;

    @Column(unique = true)
    private String employeEmail;

    @ElementCollection(fetch = FetchType.LAZY)
    private Collection<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;


    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;
}
