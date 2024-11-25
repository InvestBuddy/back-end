package tech.investbuddy.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.investbuddy.userservice.dto.UserLoginRequest;
import tech.investbuddy.userservice.dto.UserRequest;
import tech.investbuddy.userservice.model.User;
import tech.investbuddy.userservice.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    //private final MailgunProperties mailgunProperties;
    //private final MailgunEmailService mailgunEmailService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UUID authenticateUser(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        return userService.authenticate(userLoginRequest);
    }

    @GetMapping("/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        // Recherchez l'utilisateur par token
        User user = userService.findByVerificationToken(token);

        // Marquez l'email comme vérifié
        //user.setIsEmailVerified(true);
        user.setEmailVerified(true);
        user.setVerificationToken(null); // Supprimez le token après vérification
        userService.save(user);
        return ResponseEntity.ok("Email verified successfully!");
    }

//    @GetMapping("/test")
//    public ResponseEntity<String> test() {
//        /*return ResponseEntity.ok("key: " + mailgunProperties.getApiKey() + "domain: "+ mailgunProperties.getDomain() +
//                "url: " + mailgunProperties.getBaseUrl());*/
//        mailgunEmailService.sendVerificationEmail(
//                "boubacar35sangare@gmail.com",
//                "Test",
//                "hey just for testing MailGun :)"
//        );
//        return ResponseEntity.ok("Email verified successfully!");
//    }
}
