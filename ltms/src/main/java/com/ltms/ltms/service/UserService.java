package com.ltms.ltms.service;

import com.ltms.ltms.entity.UserEntity;
import com.ltms.ltms.models.UserModel;

import java.util.List;

public interface UserService {
    UserEntity findUserById(Long id);
    UserEntity createUser(UserModel userModel);
    List<UserEntity> getUserList();

    UserEntity updateUser(UserModel userModel, Long userId);

    void deleteUser(Long userId);
}
