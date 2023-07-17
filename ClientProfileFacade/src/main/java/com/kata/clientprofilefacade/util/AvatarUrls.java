package com.kata.clientprofilefacade.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AvatarUrls {
    public static String SAVE;
    public static String UPDATE;
    public static String UPDATE_AVATAR_AND_ACTIVE;
    public static String UPDATE_ACTIVE;
    public static String GET_AVATAR_BY_ID;
    public static String GET_AVATAR_BY_UUID;
    public static String GET_ACTIVE_AVATARS_BY_PI;
    public static String GET_AVATARS_BY_PI;
    public static String DELETE_AVATAR_BY_ID;
    public static String DELETE_ACTIVE_AVATAR_BY_PI;



    @Autowired
    public AvatarUrls(
            @Value("http://localhost:8080/avatars/addAvatar") String SAVE,
            @Value("http://localhost:8080/avatars") String UPDATE,
            @Value("http://localhost:8080/avatars/update") String UPDATE_AVATAR_AND_ACTIVE,
            @Value("http://localhost:8080/avatars/updateActive") String UPDATE_ACTIVE,
            @Value("http://localhost:8080/avatars/get/id/") String GET_AVATAR_BY_ID,
            @Value("http://localhost:8080/avatars/get/UUID/") String GET_AVATAR_BY_UUID,
            @Value("http://localhost:8080/avatars/get/profileIdentification") String GET_ACTIVE_AVATARS_BY_PI,
            @Value("http://localhost:8080/avatars/get/list/") String GET_AVATARS_BY_PI,
            @Value("http://localhost:8080/avatars/delete/id") String DELETE_AVATAR_BY_ID,
            @Value("http://localhost:8080/avatars/delete/active") String DELETE_ACTIVE_AVATAR_BY_PI
    ) {
        AvatarUrls.SAVE = SAVE;
        AvatarUrls.UPDATE = UPDATE;
        AvatarUrls.UPDATE_AVATAR_AND_ACTIVE = UPDATE_AVATAR_AND_ACTIVE;
        AvatarUrls.UPDATE_ACTIVE = UPDATE_ACTIVE;
        AvatarUrls.GET_AVATAR_BY_ID = GET_AVATAR_BY_ID;
        AvatarUrls.GET_AVATAR_BY_UUID = GET_AVATAR_BY_UUID;
        AvatarUrls.GET_ACTIVE_AVATARS_BY_PI = GET_ACTIVE_AVATARS_BY_PI;
        AvatarUrls.GET_AVATARS_BY_PI = GET_AVATARS_BY_PI;
        AvatarUrls.DELETE_AVATAR_BY_ID = DELETE_AVATAR_BY_ID;
        AvatarUrls.DELETE_ACTIVE_AVATAR_BY_PI = DELETE_ACTIVE_AVATAR_BY_PI;
    }

}
