package com.bilgeadam.mapper;

import com.bilgeadam.dto.response.DetailResponseDto;
import com.bilgeadam.dto.response.SummaryResponseDto;
import com.bilgeadam.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T16:44:39+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class UserProfileMapperImpl implements UserProfileMapper {

    @Override
    public DetailResponseDto fromUserProfileToDetailResponseDto(UserProfile profile) {
        if ( profile == null ) {
            return null;
        }

        DetailResponseDto.DetailResponseDtoBuilder detailResponseDto = DetailResponseDto.builder();

        detailResponseDto.name( profile.getName() );
        detailResponseDto.middleName( profile.getMiddleName() );
        detailResponseDto.lastName( profile.getLastName() );
        detailResponseDto.profileImage( profile.getProfileImage() );
        detailResponseDto.identificationNumber( profile.getIdentificationNumber() );
        detailResponseDto.birthplace( profile.getBirthplace() );
        detailResponseDto.birthDate( profile.getBirthDate() );
        detailResponseDto.job( profile.getJob() );
        detailResponseDto.department( profile.getDepartment() );
        detailResponseDto.email( profile.getEmail() );
        detailResponseDto.address( profile.getAddress() );
        detailResponseDto.telephone( profile.getTelephone() );

        return detailResponseDto.build();
    }

    @Override
    public SummaryResponseDto fromUserProfileToSummaryResponseDto(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        SummaryResponseDto.SummaryResponseDtoBuilder summaryResponseDto = SummaryResponseDto.builder();

        summaryResponseDto.profileImage( userProfile.getProfileImage() );
        summaryResponseDto.name( userProfile.getName() );
        summaryResponseDto.middleName( userProfile.getMiddleName() );
        summaryResponseDto.lastName( userProfile.getLastName() );
        summaryResponseDto.email( userProfile.getEmail() );
        summaryResponseDto.address( userProfile.getAddress() );
        summaryResponseDto.telephone( userProfile.getTelephone() );
        summaryResponseDto.job( userProfile.getJob() );
        summaryResponseDto.department( userProfile.getDepartment() );

        return summaryResponseDto.build();
    }
}
