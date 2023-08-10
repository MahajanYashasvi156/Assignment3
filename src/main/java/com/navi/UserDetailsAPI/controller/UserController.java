package com.navi.UserDetailsAPI.controller;

import com.navi.UserDetailsAPI.Validation.CategoryValidator;
import com.navi.UserDetailsAPI.Validation.CountryValidator;
import com.navi.UserDetailsAPI.Validation.EmailValidator;
import com.navi.UserDetailsAPI.Validation.SourcesValidator;
import com.navi.UserDetailsAPI.entity.User;
import com.navi.UserDetailsAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController
{

    // Autowire the UserService
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SourcesValidator sourcesValidator = new SourcesValidator();
    // Get user details
    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam String email) {
        return Optional
                .ofNullable(userService.fetchUser(email))
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    // Create a new user
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        if(!EmailValidator.isValidEmail(user.getEmail()))
        {
            return ResponseEntity.badRequest().body("Invalid email");
        }
        if(!CountryValidator.isValidCountry(user.getSelectedCountry()))
        {
            return ResponseEntity.badRequest().body("Invalid country");
        }
        if(!CategoryValidator.isValidCategory(user.getSelectedCategory()))
        {
            return ResponseEntity.badRequest().body("Invalid category");
        }
        if(!sourcesValidator.isValidSources(user.getPreferredSource(),user.getSelectedCategory(), user.getSelectedCountry()))
        {
            return ResponseEntity.badRequest().body("Invalid sources");
        }
        User createdUser = userService.createUser(user);

        if (createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }
        else
        {
            return ResponseEntity.badRequest().body("Failed to create user");
        }
    }
}
