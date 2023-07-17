package com.kata.clientprofileavatar.dao;

import com.kata.clientprofileavatar.entity.Avatar;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AvatarDao {
    Avatar getAvatarById(Integer id);
    List<Avatar> getListOfAvatars();
    Avatar getByAvatarUUID(String username);
    void deleteAvatarById(Integer id);

    void updateAvatar(MultipartFile file, Integer id);
    //2
    List<Avatar> getListAvatarsByProfileIdentification(String profileIdentification);
    void addAvatarActive(MultipartFile file,String profileIdentification,boolean active);
    void updateAvatarActive(MultipartFile file, Integer id, boolean active);
    Avatar getAvatarByProfileIdentificationAndActive(String profileIdentification);
    void deleteAvatarByProfileIdentification(String profileIdentification);
    void updateActive(Integer id, boolean active);
    List<Avatar> getDuplicateAvatars(MultipartFile file);
    Integer сheckPercentDuplicateAvatars(MultipartFile file, String profileIdentification);
}
