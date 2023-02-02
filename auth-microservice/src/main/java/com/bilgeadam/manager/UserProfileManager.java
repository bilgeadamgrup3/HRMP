package com.bilgeadam.manager;

import com.bilgeadam.dto.request.CreateProfileRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(url = "http://localhost:9092/v1/dev/userprofile",name = "user-profile-manager",decode404 = true)
public interface UserProfileManager {

    @PostMapping("/create")
    ResponseEntity<Boolean> createProfile(@RequestBody @Valid CreateProfileRequestDto dto);

}