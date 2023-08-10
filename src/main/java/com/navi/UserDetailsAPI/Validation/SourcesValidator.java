package com.navi.UserDetailsAPI.Validation;

import com.navi.UserDetailsAPI.services.NewsResponse;
import com.navi.UserDetailsAPI.services.NewsService;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
public class SourcesValidator
{
    NewsService newsService = new NewsService();
    public boolean isValidSources(HashSet<String> preferredSource, String selectedCategory, String selectedCountry)
    {
        NewsResponse response = newsService.getSources(selectedCategory,selectedCountry);
        HashSet<String> sources = new HashSet<>();
        for(NewsResponse.Source source:response.getSources())
        {
            sources.add(source.getId());
        }


        for(String source:preferredSource)
        {
            if(!sources.contains(source))
                return false;
        }
        return true;
    }

}
