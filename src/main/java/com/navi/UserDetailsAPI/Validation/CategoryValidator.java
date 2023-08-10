 package com.navi.UserDetailsAPI.Validation;

import com.navi.UserDetailsAPI.entity.Category;


import java.util.HashSet;

public class CategoryValidator
{
    public static boolean isValidCategory(String selectedCategory)
    {
        Category.listCategory();
        return Category.getCategory().contains(selectedCategory);

    }
}

