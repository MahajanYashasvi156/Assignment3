package com.navi.UserDetailsAPI.Validator;
import com.navi.UserDetailsAPI.Validation.EmailValidator;
import com.navi.UserDetailsAPI.Validation.SourcesValidator;
import com.navi.UserDetailsAPI.services.NewsResponse;
import com.navi.UserDetailsAPI.services.NewsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    NewsResponse response;

    @Mock
    NewsService newsService;

    @BeforeEach
    void setUp() {
        //newsService = new NewsService();
        response = new NewsResponse();
    }
    @Test
    void testValidEmail() {
        assertThat(EmailValidator.isValidEmail("yashasvi@example.com")).isTrue();
    }

    @Test
    void testInvalidEmail()
    {
        assertThat( EmailValidator.isValidEmail("invalid-email@")).isFalse();
        assertThat( EmailValidator.isValidEmail("invalid-email@gmail")).isFalse();
        assertThat( EmailValidator.isValidEmail("invalid-email.com")).isFalse();
        assertThat( EmailValidator.isValidEmail("_invalid-email@")).isFalse();
    }



//    @Test
//    void testValidSource()
//    {
//        response.addSources(new NewsResponse.Source("google-news-in","Google News (India)"));
//        response.addSources(new NewsResponse.Source("the-hindu","The Hindu"));
//
//        Mockito.when(newsService.getSources("business","in")).thenReturn(response);
//
//        SourcesValidator sourcesValidator = new SourcesValidator();
//
//        HashSet<String> prefSources = new HashSet<>();
//        prefSources.add("google-news-in");
//        assertThat(sourcesValidator.isValidSources(prefSources,"business","in")).isTrue();
//
//    }


}