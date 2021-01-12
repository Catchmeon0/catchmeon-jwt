package com.catchmeon.catchmeonjwt.services;

import com.catchmeon.catchmeonjwt.models.UserCMO;


public interface UserService {

    Iterable<UserCMO> getAllUsers();
    UserCMO getUser(String name);
    UserCMO getUserbyId(String name);
    UserCMO createUser(UserCMO userCMO);
    UserCMO updateUser(UserCMO userCMO);
    void deleteUser(String name);


}
