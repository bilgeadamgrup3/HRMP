package com.bilgeadam.service;

import com.bilgeadam.dto.request.UpdateRequestDto;
import com.bilgeadam.dto.response.SummaryResponseDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.UserProfileException;
import com.bilgeadam.repository.UserProfileRepository;
import com.bilgeadam.repository.entity.UserProfile;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public boolean updateRequest(UpdateRequestDto request) {
        Optional<UserProfile> profile = userProfileRepository.findOptionalById(request.getId());
        if(!profile.isPresent()){
            throw new UserProfileException(ErrorType.USER_NOT_FOUND);
        }
        profile.get().setProfileImage(request.getProfileImage());
        profile.get().setAddress(request.getAddress());
        profile.get().setTelephone(request.getTelephone());
        return true;
    }
}
