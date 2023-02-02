package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,String> {

    Optional<UserProfile> findOptionalByEmail(String email);

    Optional<UserProfile> findOptionalById(long id);

}
