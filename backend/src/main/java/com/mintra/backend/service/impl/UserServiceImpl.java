package com.mintra.backend.service.impl;

import com.mintra.backend.entities.UserAddress;
import com.mintra.backend.entities.UserDetails;
import com.mintra.backend.entities.Users;
import com.mintra.backend.json.UserAddressJson;
import com.mintra.backend.json.UserCredsJson;
import com.mintra.backend.json.UserDetailsJson;
import com.mintra.backend.json.response.GenericResponse;
import com.mintra.backend.json.response.UserCredsResponseJson;
import com.mintra.backend.json.response.UserDetailsResponseJson;
import com.mintra.backend.repository.UserAddressRepository;
import com.mintra.backend.repository.UserDetailsRepository;
import com.mintra.backend.repository.UserRepository;
import com.mintra.backend.service.UserService;
import com.mintra.backend.util.Encryption;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static com.mintra.backend.json.error.MessageDescriptions.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    @Transactional
    public GenericResponse registerNewUser(UserCredsJson userCredsJson) {

        Users existingUser = userRepository.getUserByUserName(userCredsJson.getUserName());
        if(Objects.nonNull(existingUser)){
            return new GenericResponse(USER_REGISTRATION_FAILED);
        }
        Users user = new Users(userCredsJson.getUserName(), Encryption.encrypt(userCredsJson.getPassword()));
        userRepository.addUser(user);
        return new UserCredsResponseJson(USER_REGISTRATION_SUCCESSFULL, user.getId(), user.getUserName());
    }

    @Override
    public GenericResponse isUserValid(String encryptedPassword, String userName) {
        Users user = userRepository.getUserByUserName(userName);
        if(Objects.nonNull(user) && user.getPassword().equals(encryptedPassword)){
            return new GenericResponse(VALID_USER);
        }else {
            return new GenericResponse(INVALID_USER);
        }
    }

    @Override
    @Transactional
    public GenericResponse saveOrUpdateUserDetails(UserDetailsJson userDetailsJson) {
        Users users = userRepository.getUserByUserName(userDetailsJson.getUserName());
        if(Objects.isNull(users)){
            return new GenericResponse(USER_NOT_FOUND);
        }
        UserDetails userDetails = userDetailsRepository.getUserDetailsByuserName(userDetailsJson.getUserName());
        if(Objects.isNull(userDetails)) {
            userDetails = new UserDetails(userDetailsJson.getUserName(), userDetailsJson.getEmail(), userDetailsJson.getMobileNumber());
        }else {
            userDetails.setEmail(userDetailsJson.getEmail());
            userDetails.setMobileNumber(userDetailsJson.getMobileNumber());
        }
        userDetailsRepository.saveOrUpdateUserDetails(userDetails);
        return new UserDetailsResponseJson(USER_DETAILS_SAVED_SUCCESSFULLY,userDetails.getUserName());
    }

    @Override
    public GenericResponse getUserDetails(String userName, boolean fetchUserAddress) {
        Users users = userRepository.getUserByUserName(userName);
        if(Objects.isNull(users)){
            new UserDetailsResponseJson(USER_NOT_FOUND, userName);
        }

        UserDetails userDetails = userDetailsRepository.getUserDetailsByuserName(userName);
        UserDetailsResponseJson userDetailsResponseJson;
        if(Objects.nonNull(userDetails)) {
            userDetailsResponseJson = new UserDetailsResponseJson(SUCCESS, userDetails.getUserName(), userDetails.getEmail(), userDetails.getMobileNumber());
            if(fetchUserAddress) {
                List<UserAddress> userAddressList = userAddressRepository.retrieveUserAddressByUserName(userName);
                if(!CollectionUtils.isEmpty(userAddressList)) {
                    List<UserAddressJson> userAddressJsonList = userAddressList.stream()
                            .map(userAddress -> new UserAddressJson(userAddress.getId(), userAddress.getAliasName(),
                                    userAddress.getStreet1(), userAddress.getStreet2(), userAddress.getStreet3(),
                                    userAddress.getLandMark(), userAddress.getTown(), userAddress.getDistrict(),
                                    userAddress.getState(), userAddress.getPincode(), userAddress.getAddressType()))
                            .toList();
                    userDetailsResponseJson.setUserAddressList(userAddressJsonList);
                }
            }
        }else {
            userDetailsResponseJson = new UserDetailsResponseJson(USER_DETAILS_NOT_FOUND, userName);
        }
        return userDetailsResponseJson;
    }

    @Override
    @Transactional
    public GenericResponse saveOrUpdateUserAddress(UserDetailsJson userDetailsJson) {
        Users users = userRepository.getUserByUserName(userDetailsJson.getUserName());
        if(Objects.isNull(users)){
            return new GenericResponse(USER_NOT_FOUND);
        }

        UserAddressJson userAddressJson = userDetailsJson.getUserAddressList().get(0);
        UserAddress userAddress = new UserAddress(userDetailsJson.getUserName(), userAddressJson.getAliasName(),
                userAddressJson.getStreet1(), userAddressJson.getStreet2(), userAddressJson.getStreet3(),
                userAddressJson.getLandMark(), userAddressJson.getTown(), userAddressJson.getDistrict(), userAddressJson.getState(),
                userAddressJson.getPincode(), userAddressJson.getAddressType());
        userAddressRepository.saveOrUpdateUserAddress(userAddress);
        return new GenericResponse(ADDRESS_SAVED_SUCCESSFULLY);
    }

    @Override
    @Transactional
    public GenericResponse deleteUserAddress(UserDetailsJson userDetailsJson) {
        Users users = userRepository.getUserByUserName(userDetailsJson.getUserName());
        if(Objects.isNull(users)){
            return new GenericResponse(USER_NOT_FOUND);
        }
        UserAddressJson userAddressJson = userDetailsJson.getUserAddressList().get(0);
        int row =userAddressRepository.deleteUserAddress(userAddressJson.getAddressId(), userDetailsJson.getUserName());
        return new GenericResponse(row + " " + ADDRESS_DELETED_SUCCESSFULLY);
    }
}
