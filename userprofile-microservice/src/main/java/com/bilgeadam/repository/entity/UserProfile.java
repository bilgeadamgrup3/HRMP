package com.bilgeadam.repository.entity;

import com.bilgeadam.utility.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Table(name = "user_profiles")
@Entity
public class UserProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long authid;
    private String name;
    private String middleName;
    private String lastName;
    private String lastName2;
    private String profileImage;
    private String identificationNumber;
    private String birthplace;
    private String birthDate;
    private String job;
    private String department;
    private String email;
    private String address;
    private String telephone;
}
