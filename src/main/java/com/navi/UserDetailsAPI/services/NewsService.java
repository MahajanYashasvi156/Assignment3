package com.navi.UserDetailsAPI.services;
import com.navi.UserDetailsAPI.Validation.CategoryValidator;
import com.navi.UserDetailsAPI.Validation.CountryValidator;
import com.navi.UserDetailsAPI.entity.Category;
import com.navi.UserDetailsAPI.entity.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.navi.UserDetailsAPI.entity.Country;
import java.util.List;
import java.util.Map;

@Service
public class NewsService {

    // Autowire the apiKey from application.properties
    @Value("${news.api.key}")
    private String apiKey; // Set this in your application properties

//    @Value("${news.api.rooturl}")
//    private String rooturl;

    public NewsResponse getSources(String category, String country)
    {
        if(!CountryValidator.isValidCountry(country))
            throw new IllegalArgumentException("Invalid country");

        if(!CategoryValidator.isValidCategory(category))
        {
            throw new IllegalArgumentException("Invalid category");
        }

        String url = "https://newsapi.org/v2/top-headlines/sources?category=" + category + "&country=" + country + "&apiKey=b65c20eba5524f41962d0bedc2bb0a3e";
        RestTemplate restTemplate = new RestTemplate();
        NewsResponse response =  restTemplate.getForObject(url, NewsResponse.class);
        return response;
    }
}
