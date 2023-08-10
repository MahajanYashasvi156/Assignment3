package com.navi.UserDetailsAPI.Validation;

import com.navi.UserDetailsAPI.entity.Country;

public class CountryValidator
{

    public static boolean  isValidCountry(String selectedCountry)
    {
        Country.listCountry();
        return Country.getCountry().contains(selectedCountry);
    }
}
