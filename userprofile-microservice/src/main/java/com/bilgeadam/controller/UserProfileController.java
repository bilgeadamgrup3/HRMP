package com.bilgeadam.controller;

import com.bilgeadam.dto.request.CreateProfileRequestDto;
import com.bilgeadam.dto.request.UpdateRequestDto;
import com.bilgeadam.dto.response.SummaryResponseDto;
import com.bilgeadam.repository.entity.UserProfile;
import com.bilgeadam.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.bilgeadam.constants.RestApi.*;

@RestController
@RequestMapping(USERPROFILE)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(CREATE)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> createProfile(@RequestBody @Valid CreateProfileRequestDto dto) {

        userProfileService.save(UserProfile.builder()
                .authid(dto.getAuthid())
                .email(dto.getEmail())
                .build());
        return ResponseEntity.ok(true);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateRequest(UpdateRequestDto request){
        return ResponseEntity.ok(userProfileService.updateRequest(request));
    }
}
