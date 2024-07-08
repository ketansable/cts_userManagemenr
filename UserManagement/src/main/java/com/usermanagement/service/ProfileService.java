package com.usermanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.usermanagement.dto.ProfileDto;
import com.usermanagement.entity.UserProfile;
import com.usermanagement.entity.repository.ProfileRepository;

public class ProfileService {
	@Autowired
    private ProfileRepository profileRepository;

    public ProfileDto getProfile(Long id) {
        Optional<UserProfile> profileOptional = profileRepository.findById(id);
        if (profileOptional.isPresent()) {
        	UserProfile profile = profileOptional.get();
            return convertToDto(profile);
        }
        return null;
    }

    public ProfileDto updateProfile(Long id, ProfileDto profileDto) {
        Optional<UserProfile> profileOptional = profileRepository.findById(id);
        if (profileOptional.isPresent()) {
        	UserProfile profile = profileOptional.get();
            profile.setName(profileDto.getName());
            profile.setAddress(profileDto.getAddress());
            profile.setPhone(profileDto.getPhone());
            profile.setEmail(profileDto.getEmail());
            profileRepository.save(profile);
            return convertToDto(profile);
        }
        return null;
    }

    private ProfileDto convertToDto(UserProfile profile) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setName(profile.getName());
        profileDto.setAddress(profile.getAddress());
        profileDto.setPhone(profile.getPhone());
        profileDto.setEmail(profile.getEmail());
        return profileDto;
    }
}
