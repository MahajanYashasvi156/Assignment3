package com.navi.UserDetailsAPI.entity;

import java.util.HashSet;

public class Category
{
    static HashSet<String>  categoryList = new HashSet<String>();

    public static void listCategory()
    {
        categoryList.add("business");
        categoryList.add("entertainment");
        categoryList.add("general");
        categoryList.add("health");
        categoryList.add("science");
        categoryList.add("sports");
        categoryList.add("technology");
    }
    public static HashSet<String> getCategory()
    {
        return categoryList;
    }
}
