package tech.investbuddy.userprofileservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.investbuddy.userprofileservice.dto.UserProfileRequest;
import tech.investbuddy.userprofileservice.dto.UserProfileResponse;
import tech.investbuddy.userprofileservice.service.UserProfileService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/api/v1/user-profile")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserProfile(
            @Valid @RequestBody UserProfileRequest userProfileRequest) {
        userProfileService.save(userProfileRequest);
    }

    @GetMapping("/api/v1/user-profile/{id}")
    public ResponseEntity<UserProfileResponse> getUserProfileById(@PathVariable UUID id) {
        return userProfileService.getUserProfile(id);
    }
}
