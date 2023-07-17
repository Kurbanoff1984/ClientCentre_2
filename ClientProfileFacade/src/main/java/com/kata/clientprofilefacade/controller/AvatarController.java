package com.kata.clientprofilefacade.controller;

import com.kata.clientprofilefacade.service.ProfileAvatarService;
import com.kata.clientprofilefacade.util.AvatarUrls;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * This controller class refers to the microservice ClientProfileAvatar
 */
@RestController
@RequestMapping("/api/avatars")
@AllArgsConstructor
public class AvatarController {


    private final ProfileAvatarService profileAvatarService;

    /**
     * This method refers to the ClientProfileAvatar microservice to create an avatar
     */
    @PostMapping("/save")
    public <T> ResponseEntity<T> save(@RequestParam("file") MultipartFile file,
                                      @RequestParam("profileIdentification") String profileIdentification,
                                      @RequestParam("active") boolean active)  {
        return profileAvatarService.performAvatarOperation(file,null, profileIdentification,null,active, AvatarUrls.SAVE, HttpMethod.POST,(Class<T>)void.class);
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to update an avatar
     */
    @PatchMapping("/update")
    public <T> ResponseEntity<T> updateAvatar(@RequestParam("file") MultipartFile file,
                                              @RequestParam("id") Integer id)  {
        return  profileAvatarService.performAvatarOperation(file,id,null,null,null,AvatarUrls.UPDATE, HttpMethod.PATCH,(Class<T>)HttpStatus.class);
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to update and active avatar
     */
    @PatchMapping("/updateAvatarAndActive")
    public <T> ResponseEntity<T> updateAvatarActive(@RequestParam("file") MultipartFile file,
                                                    @RequestParam("id") Integer id,
                                                    @RequestParam("active") boolean active)  {
        return profileAvatarService.performAvatarOperation(file,id,null,null,active,AvatarUrls.UPDATE_AVATAR_AND_ACTIVE,HttpMethod.PATCH, (Class<T>) HttpStatus.class);
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to update active avatar
     */
    @PatchMapping("/updateActive")
    public <T> ResponseEntity<T> updateActive(@RequestParam("id") Integer id, @RequestParam("active") boolean active)  {
        return profileAvatarService.performAvatarOperation(null,id,null,null,active,AvatarUrls.UPDATE_ACTIVE,HttpMethod.PATCH, (Class<T>) HttpStatus.class);
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to get avatar by id
     */
    @GetMapping("/getAvatarById")
    public <T> ResponseEntity<T> getAvatarById(@RequestParam("id") Integer id)  {
        return profileAvatarService.performAvatarOperation(null,id,null,null,null,AvatarUrls.GET_AVATAR_BY_ID,HttpMethod.GET,(Class<T>) String.class);
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to get avatar by uuid
     */
    @GetMapping("/getAvatarByUuid")
    public <T> ResponseEntity<T> getAvatarByUuid(@RequestParam("uuid") String uuid)  {
        return profileAvatarService.performAvatarOperation(null,null,null,uuid, null,AvatarUrls.GET_AVATAR_BY_UUID,HttpMethod.GET,(Class<T>) String.class);
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to get active avatar by PI
     */
    @GetMapping("/getActiveAvatarByProfileIdentification")
    public <T> ResponseEntity<T> getActiveAvatarByProfileIdentification(@RequestParam("profileIdentification") String profileIdentification)  {
        return profileAvatarService.performAvatarOperation(null,null,profileIdentification,null,null,AvatarUrls.GET_ACTIVE_AVATARS_BY_PI,HttpMethod.GET,(Class<T>) String.class);
    }

    /**
     * This method refers to the ClientProfileAvatar microservice to get avatars by PI
     */
    @GetMapping("/getAvatarsByProfileIdentification")
    public <T> ResponseEntity<T> getAvatarsByProfileIdentification(@RequestParam("profileIdentification") String profileIdentification) {
        return profileAvatarService.performAvatarOperation(null,null,profileIdentification,null,null,AvatarUrls.GET_AVATARS_BY_PI,HttpMethod.GET,(Class<T>) List.class);
    }

    /**
     * This method accesses the ClientProfileAvatar microservice to remove the avatar by id
     */
    @DeleteMapping("/deleteAvatarById")
    public <T> ResponseEntity<T> deleteAvatarById(@RequestParam("id") Integer id)  {
        return profileAvatarService.performAvatarOperation(null,id,null,null,null,AvatarUrls.DELETE_AVATAR_BY_ID,HttpMethod.DELETE,(Class<T>) HttpStatus.class);
    }

    /**
     * This method accesses the ClientProfileAvatar microservice to remove the active avatar by PI
     */
    @DeleteMapping("/deleteActiveAvatarByProfileIdentification")
    public <T> ResponseEntity<T> deleteActiveAvatarByProfileIdentification(@RequestParam("profileIdentification") String profileIdentification) {
        return profileAvatarService.performAvatarOperation(null,null,profileIdentification,null,null,AvatarUrls.DELETE_ACTIVE_AVATAR_BY_PI, HttpMethod.DELETE,(Class<T>) HttpStatus.class);
    }

}
