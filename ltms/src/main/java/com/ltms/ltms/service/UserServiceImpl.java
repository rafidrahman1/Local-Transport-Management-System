package com.ltms.ltms.service;

import com.ltms.ltms.entity.BusEntity;
import com.ltms.ltms.entity.UserEntity;
import com.ltms.ltms.models.UserModel;
import com.ltms.ltms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserEntity findUserById(Long userId) {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow();
        return userEntity;
    }

    @Override
    public UserEntity createUser(UserModel userModel) {
        UserEntity user = UserEntity.builder()//no need to build constructor
                .id(userModel.getId())
                .name(userModel.getName())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .balance(userModel.getBalance())
                .build();

        UserEntity savedUser =  userRepository.save(user);//elborated
        return savedUser;
    }

    @Override
    public List<UserEntity> getUserList() {
        return null;
    }

    @Override
    public UserEntity updateUser(UserModel userModel, Long userId) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

//    @Override
//    public BusEntity createBus(BusModel busModel) {
//        BusEntity bus = BusEntity.builder()//no need to build constructor
//                .name(busModel.getName())
//                .price(busModel.getPrice())
//                .route(busModel.getRoute())
//                .build();
//
//        BusEntity savedBus =  busRepository.save(bus);//elborated
//        return savedBus;
//    }
//
//    @Override
//    public List<BusEntity> getBusList() {
//        List<BusEntity> busEntityList = busRepository.findAll();
//        return busEntityList;
//    }
//
//    @Override
//    public BusEntity updateBus(BusModel busModel, Long busId) {
//        BusEntity busFromDB = busRepository.findById(busId)
//                .orElseThrow();
//        if (busModel.getPrice() != null) busFromDB.setPrice(busModel.getPrice());
//        if (busModel.getRoute() != null) busFromDB.setRoute(busModel.getRoute());
//        BusEntity updatedBus = busRepository.save(busFromDB);
//        return updatedBus;
//    }
//
//    @Override
//    public void deleteBus(Long busId) {
//        busRepository.deleteById(busId);
//    }


}