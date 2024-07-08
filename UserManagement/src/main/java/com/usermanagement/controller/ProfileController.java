package com.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.usermanagement.dto.ProfileDto;
import com.usermanagement.service.ProfileService;

public class ProfileController {
	@Autowired
    private ProfileService profileService;

    @GetMapping
    public ProfileDto getProfile(@RequestParam Long userId) {
        return profileService.getProfile(userId);
    }

    @PutMapping
    public String updateProfile(@RequestParam Long userId, @RequestBody ProfileDto profileDto) {
        ProfileDto updatedProfile = profileService.updateProfile(userId, profileDto);
        if (updatedProfile != null) {
            return "Profile updated successfully.";
        }
        return "Unable to update profile. Please try again later.";
    }
}
