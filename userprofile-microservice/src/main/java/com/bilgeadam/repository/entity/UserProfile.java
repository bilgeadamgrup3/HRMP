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
    long id;
    long authid;
    String name;
    String middleName;
    String lastName;
    String profileImage;
    String identificationNumber;
    String birthplace;
    String birthDate;
    String job;
    String department;
    String email;
    String address;
    String telephone;
}
