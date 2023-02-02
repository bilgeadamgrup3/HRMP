package com.bilgeadam.service;

import com.bilgeadam.dto.request.UpdateRequestDto;
import com.bilgeadam.dto.response.DetailResponseDto;
import com.bilgeadam.dto.response.SummaryResponseDto;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.exception.UserProfileException;
import com.bilgeadam.mapper.UserProfileMapper;
import com.bilgeadam.repository.UserProfileRepository;
import com.bilgeadam.repository.entity.UserProfile;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;

    public UserProfileService(UserProfileRepository userProfileRepository, UserProfileMapper userProfileMapper) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.userProfileMapper = userProfileMapper;
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

    public DetailResponseDto detailRequest(Long id) {
        Optional<UserProfile> profile = userProfileRepository.findOptionalById(id);
        if(!profile.isPresent()){
            throw new UserProfileException(ErrorType.USER_NOT_FOUND);
        }
        return userProfileMapper.INSTANCE.fromUserProfileToDetailResponseDto(profile.get());
    }

    public SummaryResponseDto summaryRequest(Long id) {
        Optional<UserProfile> profile = userProfileRepository.findOptionalById(id);
        if(!profile.isPresent()){
            throw new UserProfileException(ErrorType.USER_NOT_FOUND);
        }
        return userProfileMapper.INSTANCE.fromUserProfileToSummaryResponseDto(profile.get());
    }
}
