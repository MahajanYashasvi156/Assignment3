package com.navi.UserDetailsAPI.controller;
import com.navi.UserDetailsAPI.entity.User;
import com.navi.UserDetailsAPI.repository.UserRepository;
import com.navi.UserDetailsAPI.services.NewsResponse;
import com.navi.UserDetailsAPI.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NewsController
{
    // Autowire the NewsService and UserRepository
    private final NewsService newsService;
    private final UserRepository userRepository;

    @Autowired
    public NewsController(NewsService newsService, UserRepository userRepository) {
        this.newsService = newsService;
        this.userRepository = userRepository;
    }

    // Get top headlines for a user
    @GetMapping("/sources")
    public ResponseEntity<?> getTopHeadlinesForUser(@RequestParam String email)
    {
        // Fetch the user from the database
        User user = userRepository.fetchUser(email);

        // If the user exists, get the top headlines for the user's selected category and country
        if (user != null)
        {
            // Get the user's selected category and country
            String selectedCategory = user.getSelectedCategory();
            String selectedCountry = user.getSelectedCountry();
            // Get the top headlines for the user's selected category and country
            NewsResponse newsResponse = newsService.getSources(selectedCategory, selectedCountry);
            return ResponseEntity.ok(newsResponse);
        }
        // If the user does not exist, return a 404 Not Found response
        else
        {
            // Return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }
}
