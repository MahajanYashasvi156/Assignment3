package com.navi.UserDetailsAPI.entity;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * The User class represents a basic user entity with properties such as username, full name, and email,address.
 * This class provides methods to get and set these properties.
 */
public class User
{
    private String email;
    private String selectedCategory;
    private String selectedCountry;
    private HashSet<String> preferredSource = new HashSet<>();

    public User()
    {}

    public User(String email, String selectedCategory,String selectedCountry,HashSet<String> preferredSource) {
        this.selectedCategory =  selectedCategory;
        this.preferredSource = preferredSource;
        this.selectedCountry = selectedCountry;
        this.email = email;
    }

    /**
     * Constructs a new User object with the specified username.
     *
     * @param email  for the user.
     */
    public User(String email) {
        this.email = email;
    }

    /**
     * Retrieves the username of the user.
     *
     * @return The username of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the username of the user.
     *
     * @param email The new username for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Retrieves the selected_category of the user.
     *
     * @return The selectedCategory by the user.
     */
    public String getSelectedCategory() {
        return selectedCategory;
    }

    /**
     * Sets the selected_category  of the user.
     *
     * @param selectedCategory  for the user.
     */
    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }


    /**
     * Retrieves the selectedCountry of the user.
     *
     * @return The selectedCountry by the user.
     */
    public String getSelectedCountry() {
        return selectedCountry;
    }

    /**
     * Sets the selectedCountry  of the user.
     *
     * @param selectedCountry  for the user.
     */
    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public HashSet<String> getPreferredSource() {
        return preferredSource;
    }
    public void setPreferredSource(HashSet<String> preferredSource) {
        this.preferredSource = preferredSource;
    }
}
