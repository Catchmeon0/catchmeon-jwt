package com.catchmeon.catchmeonjwt.services;

import com.catchmeon.catchmeonjwt.models.UserCMO;

import java.util.concurrent.ExecutionException;


public interface UserService {

    Iterable<UserCMO> getAllUsers();
    UserCMO getUser(String name);
    UserCMO getUserbyId(String name);
    UserCMO createUser(UserCMO userCMO) throws ExecutionException, InterruptedException;
    UserCMO updateUser(UserCMO userCMO);
    void deleteUser(String name);


}
