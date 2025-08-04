package com.aiman.bloodapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "donor")
@Data
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Long donorId;

    private String name;
    private String email;
    private String phone;

    @Column(name = "blood_group")
    private String bloodGroup;

    private String city;

    @Column(name = "is_available")
    private Boolean isAvailable;
}
