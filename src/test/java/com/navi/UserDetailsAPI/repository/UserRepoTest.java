package com.navi.UserDetailsAPI.repository;

import com.navi.UserDetailsAPI.entity.User;
import org.junit.jupiter.api.Test;

public class UserRepoTest
{
    @Test
    void createUserTest()
    {
        User user = new User("yashasvi154@gmail.com","business","in",null);
        UserRepositoryImp userRepo = new UserRepositoryImp();
        userRepo.createUser(user);
        assert(userRepo.fetchUser(user.getEmail()).equals(user));
    }

    @Test
    void createUserAgain()
    {
        User user = new User("yashasvi154@gmail.com","business","in",null);
        UserRepositoryImp userRepo = new UserRepositoryImp();
        userRepo.createUser(user);
        assert(userRepo.createUser(user)==null);
    }

}
